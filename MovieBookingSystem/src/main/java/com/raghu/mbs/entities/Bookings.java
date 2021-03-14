package com.raghu.mbs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	Shows show;
	
	@ManyToOne
	Users user;
	
	boolean isPaymentdone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}

	public boolean isPaymentdone() {
		return isPaymentdone;
	}

	public void setPaymentdone(boolean isPaymentdone) {
		this.isPaymentdone = isPaymentdone;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Bookings(Shows show, Users user, boolean isPaymentdone) {
		super();
		this.show = show;
		this.user = user;
		this.isPaymentdone = isPaymentdone;
	}
	
	public Bookings() {
		
	}
	
	
	
}
