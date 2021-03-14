package com.raghu.mbs.dto;

public class PaymentDTO {

	String bookingId;
	String userId;
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PaymentDTO [bookingId=" + bookingId + ", userId=" + userId + "]";
	}
	
	
	
}
