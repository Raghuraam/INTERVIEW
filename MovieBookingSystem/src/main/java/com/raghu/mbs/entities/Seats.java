package com.raghu.mbs.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Seats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int seatNumber;
	
	@ManyToOne
	Shows show;
	
	@ManyToOne
	Users user;
	
	@ManyToOne
	Bookings bookings; 
	
	String reserved_time;
	
	boolean isSeatConfirmed;

	public Seats(int id, int seatNumber, Shows show, Users user) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.show = show;
		this.user = user;
	}
	
	public Seats() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}

	public String getReserved_time() {
		return reserved_time;
	}

	public void setReserved_time(String reserved_time) {
		this.reserved_time = reserved_time;
	}

	public boolean isSeatConfirmed() {
		return isSeatConfirmed;
	}

	public void setSeatConfirmed(boolean isSeatConfirmed) {
		this.isSeatConfirmed = isSeatConfirmed;
	}

	@Override
	public String toString() {
		return "Seats [id=" + id + ", seatNumber=" + seatNumber + ", show=" + show + ", user=" + user + "]";
	}

	public Seats(int seatNumber, Shows show, Users user) {
		super();
		this.seatNumber = seatNumber;
		this.show = show;
		this.user = user;
	}
	
	
}
