package com.raghu.mbs.dto;

import java.util.List;

public class MovieShowResponseDTO {

	int show_id;
	String movie_name;
	String show_timing;
	String cinema_name;
	List<Integer> seats_available;
	
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getShow_timing() {
		return show_timing;
	}
	public void setShow_timing(String show_timing) {
		this.show_timing = show_timing;
	}
	public List<Integer> getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(List<Integer> seats_available) {
		this.seats_available = seats_available;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	@Override
	public String toString() {
		return "MovieShowResponseDTO [show_id=" + show_id + ", movie_name=" + movie_name + ", show_timing="
				+ show_timing + ", cinema_name=" + cinema_name + ", seats_available=" + seats_available + "]";
	}
	public MovieShowResponseDTO(int show_id, String movie_name, String show_timing, String cinema_name,
			List<Integer> seats_available) {
		super();
		this.show_id = show_id;
		this.movie_name = movie_name;
		this.show_timing = show_timing;
		this.cinema_name = cinema_name;
		this.seats_available = seats_available;
	}
	
	

}
