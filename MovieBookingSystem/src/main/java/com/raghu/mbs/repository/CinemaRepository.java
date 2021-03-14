package com.raghu.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raghu.mbs.entities.Cinemas;

public interface CinemaRepository extends JpaRepository<Cinemas, Integer> {

	@Query(value = "select seat_capacity from cinemas c where c.id=?1", nativeQuery = true)
	public int getSeatCapacity(int cinemaId);
}
