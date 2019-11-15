package com.yash.busreservationsystem.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int busId;
	private int custId;
	private int noOfSeatBooked;
	private String source;
	private String destination;
	private int totalFare;
	private LocalDate bookingDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getNoOfSeatBooked() {
		return noOfSeatBooked;
	}
	public void setNoOfSeatBooked(int noOfSeatBooked) {
		this.noOfSeatBooked = noOfSeatBooked;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	public Ticket(int busId, int custId, int noOfSeatBooked, String source, String destination, int totalFare,
			LocalDate bookingDate) {
		super();
		this.busId = busId;
		this.custId = custId;
		this.noOfSeatBooked = noOfSeatBooked;
		this.source = source;
		this.destination = destination;
		this.totalFare = totalFare;
		this.bookingDate = bookingDate;
	}
	public Ticket() {
		super();
		
	}
	
	
	
}
