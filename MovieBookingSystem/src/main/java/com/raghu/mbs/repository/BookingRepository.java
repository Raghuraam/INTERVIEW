package com.raghu.mbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raghu.mbs.entities.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {

	
	@Query(value = "select (select name from movies where id=?1) as movie_name, s.seat_number  from Bookings b left outer join seats s on s.show_id=?1", nativeQuery = true)
	public List<Object[]> getBooking(int bookingId);
}
