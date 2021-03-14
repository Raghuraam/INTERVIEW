package com.raghu.mbs.dto;

import java.util.List;

public class BookingResponseViewDTO {

	Integer showId;
	List<String> seats;
	boolean isSeatConfimed;
	
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	
	public List<String> getSeats() {
		return seats;
	}
	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
	public boolean isSeatConfimed() {
		return isSeatConfimed;
	}
	public void setSeatConfimed(boolean isSeatConfimed) {
		this.isSeatConfimed = isSeatConfimed;
	}
	@Override
	public String toString() {
		return "BookingResponseViewDTO [showId=" + showId + ", seats=" + seats + ", isSeatConfimed=" + isSeatConfimed
				+ "]";
	}
	public BookingResponseViewDTO(Integer showId, List<String> seats, boolean isSeatConfimed) {
		super();
		this.showId = showId;
		this.seats = seats;
		this.isSeatConfimed = isSeatConfimed;
	}
	
	
	
	
}
