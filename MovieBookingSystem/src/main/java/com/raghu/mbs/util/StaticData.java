package com.raghu.mbs.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.raghu.mbs.entities.Cinemas;
import com.raghu.mbs.entities.Movies;
import com.raghu.mbs.entities.Shows;
import com.raghu.mbs.entities.Users;
import com.raghu.mbs.repository.CinemaRepository;
import com.raghu.mbs.repository.MovieRepository;
import com.raghu.mbs.repository.ShowRepository;
import com.raghu.mbs.repository.UserRepository;

@Component
public class StaticData {

	@Autowired
    MovieRepository movieRepository; 
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;
	
	public boolean PersistStaticData(){
		
		//User Data
		Users user1 = new Users(1, "superops");
		Users user2 = new Users(2, "raghu");
		
		List<Users> users = new ArrayList<Users>();
		users.add(user1);
		users.add(user2);
		userRepository.saveAll(users);
		
		System.out.println("----- Users data persisted ----");
		
		//Cinema Data
		Cinemas cinema1 = new Cinemas(1, "Sathyam", 200);
		Cinemas cinema2 = new Cinemas(2, "Kasi", 200);
		Cinemas cinema3 = new Cinemas(3, "S2", 150);
		Cinemas cinema4 = new Cinemas(4, "Woodlands", 100);
		
		List<Cinemas> cinemas = new ArrayList<Cinemas>();
		cinemas.add(cinema1);
		cinemas.add(cinema2);
		cinemas.add(cinema3);
		cinemas.add(cinema4);
		
		cinemaRepository.saveAll(cinemas);
		System.out.println("----- Cinema data persisted ----");
		
		// Movie Data
		Movies movie1 = new Movies(1, "Master", 7, 100);
		Movies movie2 = new Movies(2, "Soorarai potru", 8, 70);
		Movies movie3 = new Movies(3, "Jagame thandhiram", 8, 100);
		Movies movie4 = new Movies(4, "Tenet", 8, 90);
		Movies movie5 = new Movies(5, "Sillu karupatti", 9, 100);
		Movies movie6 = new Movies(6, "Aayirathil Oruvan", 9, 100);
		Movies movie7 = new Movies(7, "Mama Coco", 9, 100);
		Movies movie8 = new Movies(8, "Soul", 9, 90);
		Movies movie9 = new Movies(9, "Drishyam 2", 7, 80);
		Movies movie10 = new Movies(10, "Darbar", 7, 80);
		
		List<Movies> movies = new ArrayList<Movies>();
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
		movies.add(movie6);
		movies.add(movie7);
		movies.add(movie8);
		movies.add(movie9);
		movies.add(movie10);
		
		movieRepository.saveAll(movies);
	
		System.out.println("----- Movie data persisted ----");
		
		// Show Data
		Shows show1 = new Shows(1, movie1, cinema1 ,"02 Mar 2021, 10:00 AM - 12:00PM");
		Shows show2 = new Shows(2, movie1, cinema1 ,"02 Mar 2021, 1:00 PM - 4:00PM");
		Shows show3 = new Shows(3, movie5, cinema2 ,"02 Mar 2021, 10:00 AM - 12:00PM");
		Shows show4 = new Shows(4, movie5, cinema2 ,"02 Mar 2021, 1:00 PM - 4:00PM");
		
		List<Shows> shows = new ArrayList<Shows>();
		shows.add(show1);
		shows.add(show2);
		shows.add(show3);
		shows.add(show4);
		
		showRepository.saveAll(shows);
		
		System.out.println("----- Show data persisted -----");
		
		return true;
	}
	
	public static void main(String[] args) {

		
		
		
	}

}
