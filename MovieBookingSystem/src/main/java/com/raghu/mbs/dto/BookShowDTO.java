package com.raghu.mbs.dto;

import java.util.List;

public class BookShowDTO {

	String userId;
	String showId;
	List<Integer> seatNo;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public List<Integer> getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(List<Integer> seatNo) {
		this.seatNo = seatNo;
	}
	public BookShowDTO(String userId, String showId, List<Integer> seatNo) {
		super();
		this.userId = userId;
		this.showId = showId;
		this.seatNo = seatNo;
	}
	
	@Override
	public String toString() {
		return "BookShowDTO [userId=" + userId + ", showId=" + showId + ", seatNo=" + seatNo + "]";
	}
	
	
}
