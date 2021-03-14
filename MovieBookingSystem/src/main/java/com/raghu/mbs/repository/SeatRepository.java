package com.raghu.mbs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.raghu.mbs.entities.Seats;

@Transactional
public interface SeatRepository extends JpaRepository<Seats, Integer> {

	@Query(value = "select count(*) as count from seats where user_id=?1 and show_id=?2", nativeQuery = true)
	public int getReservedSeat(int userId, int show_id);

	@Query(value = "select id from seats where is_seat_confirmed=false and timestampdiff(Minute, reserved_time, sysdate())>2", nativeQuery = true)
	public List<Integer> getUnConfirmedSeat();

	@Modifying
	@Query(value = "update seats set is_seat_confirmed=true where bookings_id=?1", nativeQuery = true)
	public void updateConfirmedSeats(int bookingId);

	@Query(value = "SELECT SHOW_ID, GROUP_CONCAT(SEAT_NUMBER SEPARATOR ',') AS BOOKED_SEATS FROM SEATS GROUP BY SHOW_ID", nativeQuery = true)
	public List<Object[]> getConfirmedSeats();

	@Query(value = "select GROUP_CONCAT(SEAT_NUMBER SEPARATOR ',') as seat_no from seats where bookings_id=?1", nativeQuery = true)
	public String getSeatsForBooking(int bookingId);
}
