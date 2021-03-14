package com.raghu.mbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raghu.mbs.entities.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer>{
	
	

}
