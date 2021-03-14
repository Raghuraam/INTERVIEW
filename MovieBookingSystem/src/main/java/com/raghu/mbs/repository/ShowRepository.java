package com.raghu.mbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raghu.mbs.entities.Shows;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Integer> {

	@Query(value = "select s.id, name, show_timing, s.cinema_id from shows s left outer join movies m on m.id=s.movies_id", nativeQuery = true)
	public List<Object[]> getMovieShows();
	
}
