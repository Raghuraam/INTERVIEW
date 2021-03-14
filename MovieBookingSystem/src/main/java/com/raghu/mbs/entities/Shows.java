package com.raghu.mbs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Shows {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	Movies movies;
	
	@ManyToOne
	Cinemas cinema;
	
	String showTiming;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}
	
	public Cinemas getCinema() {
		return cinema;
	}

	public void setCinema(Cinemas cinema) {
		this.cinema = cinema;
	}

	public Shows(int id, Movies movies, String showTiming) {
		super();
		this.id = id;
		this.movies = movies;
		this.showTiming = showTiming;
	}
	
	public Shows(int id, Movies movies, Cinemas cinema, String showTiming) {
		super();
		this.id = id;
		this.movies = movies;
		this.cinema = cinema;
		this.showTiming = showTiming;
	}

	public Shows() {
		super();
	}
	
}
