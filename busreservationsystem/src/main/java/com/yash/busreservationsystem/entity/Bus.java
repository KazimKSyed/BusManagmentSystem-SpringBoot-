package com.yash.busreservationsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bus  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String number;
	private String source;
	private String destination;
	private String busType;
	private int noOfSeatsAvailable;
	private int fare;

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

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
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
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	

	@Override
	public String toString() {
		return "\nBus [id=" + id + ", name=" + name + ", number=" + number + ", source=" + source + ", destination="
				+ destination + ", busType=" + busType + ", noOfSeatsAvailable=" + noOfSeatsAvailable + ", fare=" + fare
				+ "]";
	}

	
	public Bus(String name, String number, String source, String destination, String busType, int noOfSeatsAvailable,
			int fare) {
		super();
		this.name = name;
		this.number = number;
		this.source = source;
		this.destination = destination;
		this.busType = busType;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
		this.fare = fare;
	}

	public Bus() {
		super();
		
	}
	

	

	
	

}
