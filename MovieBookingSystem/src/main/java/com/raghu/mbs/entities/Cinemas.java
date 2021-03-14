package com.raghu.mbs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cinemas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	int seatCapacity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", seatCapacity=" + seatCapacity + "]";
	}
	public Cinemas(int id, String name, int seatCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.seatCapacity = seatCapacity;
	}
	public Cinemas() {
		super();
	}
	
	
}
