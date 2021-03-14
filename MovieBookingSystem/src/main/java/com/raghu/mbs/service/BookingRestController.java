package com.raghu.mbs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.catalina.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.mbs.dto.BookShowDTO;
import com.raghu.mbs.dto.BookingResponseViewDTO;
import com.raghu.mbs.dto.MovieShowResponseDTO;
import com.raghu.mbs.dto.PaymentDTO;
import com.raghu.mbs.entities.Bookings;
import com.raghu.mbs.entities.Cinemas;
import com.raghu.mbs.entities.Movies;
import com.raghu.mbs.entities.Seats;
import com.raghu.mbs.entities.Shows;
import com.raghu.mbs.entities.Users;
import com.raghu.mbs.repository.BookingRepository;
import com.raghu.mbs.repository.CinemaRepository;
import com.raghu.mbs.repository.MovieRepository;
import com.raghu.mbs.repository.SeatRepository;
import com.raghu.mbs.repository.ShowRepository;
import com.raghu.mbs.repository.UserRepository;
import com.raghu.mbs.util.StaticData;



@RestController
public class BookingRestController {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	ShowRepository showRepository;

	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	StaticData staticData;

	@RequestMapping("/hello")
	public String hello() {
		return "Welcome to Online Movie Booking System";
	}

	@RequestMapping("/persistStaticData")
	public boolean persistStaticData() {
		return staticData.PersistStaticData();
	}

	@RequestMapping("/getMovies")
	public List<Movies> getMovies() {
		return movieRepository.findAll();
	}

	@RequestMapping("/getShows")
	public List<MovieShowResponseDTO> getShows() {
		List<MovieShowResponseDTO> responseViewDTO = new ArrayList<MovieShowResponseDTO>();

		List<Object[]> movieShows = showRepository.getMovieShows();

		List<Object[]> bookedSeatsFromDB = seatRepository.getConfirmedSeats();
		
		Map<Integer, List<Integer>> showSeatMap = new ConcurrentHashMap<>();
		
		bookedSeatsFromDB.parallelStream().forEach(objArray -> {
			Integer showId = (Integer) objArray[0];
			String rawbookedSeats = (String) objArray[1];
			List<Integer> seatsList = Stream.of(rawbookedSeats.split(",")).mapToInt(i -> Integer.parseInt(i)).boxed().collect(Collectors.toList());
			
			showSeatMap.put(showId, seatsList);
			
		});
		
		System.out.println("showSeatMap "+showSeatMap);
		
		for (Object[] shows : movieShows) {

			int showId = (int) shows[0];
			String movieName = (String) shows[1];
			String showTiming = (String) shows[2];
			Integer cinemaId = (Integer) shows[3];
			List<Integer> booked_seats = showSeatMap.get(showId);
			if(booked_seats == null) {
				booked_seats = Collections.EMPTY_LIST;
			}
			List<Integer> seat_avail = getAvailableSeats(showRepository.getOne(showId), booked_seats);
			Cinemas cinema = cinemaRepository.getOne(cinemaId);
			MovieShowResponseDTO movieShowResponseDTO = new MovieShowResponseDTO(showId, movieName,showTiming, cinema.getName(),seat_avail);
			responseViewDTO.add(movieShowResponseDTO);
		}

		return responseViewDTO;
	}
	
	/**
	 * {
		"userId":1,
		"showId":1,
		"seatNo":[1,2]
		}
	 * @param bookShowDTO
	 * @return
	 */
	@PostMapping("/bookShow")
	public synchronized Object book(@RequestBody BookShowDTO bookShowDTO) {
		
	System.out.println(bookShowDTO);
	
	Integer showId = Integer.parseInt(bookShowDTO.getShowId());
	Integer userId = Integer.parseInt(bookShowDTO.getUserId());
	List<Integer> seats = bookShowDTO.getSeatNo();
	
	int reservedSeat =  seatRepository.getReservedSeat(userId, showId);
	
	System.out.println(reservedSeat);
	
	if(reservedSeat+seats.size()>6)
		return -1;
	
	Optional<Shows> optionalshows = showRepository.findById(showId);
	Shows show = optionalshows.get();
	
	Optional<Users> optionalusers = userRepository.findById(userId);
	Users user = optionalusers.get();
	
	
	LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);//2021-03-09 14:34:23
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
    
    Bookings bookings = new Bookings(show, user, false);
    bookings = bookingRepository.save(bookings);
    
	for(int seatno: seats) {
		Seats seat = new Seats(seatno, show , user);
		seat.setReserved_time(formattedDate);
		seat.setBookings(bookings);
		seatRepository.save(seat);
	}
	
	return bookings.getId();
	
	}
	
	@GetMapping("/getBooking/{bookingId}")
	public BookingResponseViewDTO getBooking(@PathVariable("bookingId") int bookingId) {

		Bookings bookings = bookingRepository.getOne(bookingId);

		List<String> seats = new ArrayList<String>();
		String rawSeats = seatRepository.getSeatsForBooking(bookingId);
		seats = Arrays.asList(rawSeats.split(","));
		BookingResponseViewDTO bookingResponseViewDTO = new BookingResponseViewDTO(bookings.getShow().getId(), seats, bookings.isPaymentdone());
		return bookingResponseViewDTO;

	}
	
	@PostMapping("/payForSeat")
	public Object payForSeat(@RequestBody PaymentDTO paymentDTO) {
		
		System.out.println(paymentDTO);
		Bookings bookings = bookingRepository.getOne(Integer.parseInt(paymentDTO.getBookingId()));
		bookings.setPaymentdone(true);
		bookingRepository.save(bookings);
		
		seatRepository.updateConfirmedSeats(Integer.parseInt(paymentDTO.getBookingId()));
		
		return true;
	}
	
	private List<Integer> getAvailableSeats(Shows show, List<Integer> bookedSeatsList){
		
		int seatCapacity = cinemaRepository.getSeatCapacity(show.getCinema().getId());
		IntStream stream = IntStream.range(1, seatCapacity);
		
        List<Integer> available_seats = stream.filter(o -> !bookedSeatsList.contains(o))
                                    .boxed()
                                    .collect(Collectors.toList());
        return available_seats;
	}
	
	
}
