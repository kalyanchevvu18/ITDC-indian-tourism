package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class hotel {

	@Id
	private String id;
	private String name;
	private String Address;
	private long ph_no;
	private int total_rooms;
	private int Avail_rooms;
	private int Booked_rooms;
	private double cost;
	
	public hotel()
	{
		
	}

	public hotel(String id, String name, String address, long ph_no, int total_rooms, int avail_rooms, int booked_rooms,
			double cost) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		this.ph_no = ph_no;
		this.total_rooms = total_rooms;
		Avail_rooms = avail_rooms;
		Booked_rooms = booked_rooms;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getPh_no() {
		return ph_no;
	}

	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	public int getTotal_rooms() {
		return total_rooms;
	}

	public void setTotal_rooms(int total_rooms) {
		this.total_rooms = total_rooms;
	}

	public int getAvail_rooms() {
		return Avail_rooms;
	}

	public void setAvail_rooms(int avail_rooms) {
		Avail_rooms = avail_rooms;
	}

	public int getBooked_rooms() {
		return Booked_rooms;
	}

	public void setBooked_rooms(int booked_rooms) {
		Booked_rooms = booked_rooms;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "hotel [id=" + id + ", name=" + name + ", Address=" + Address + ", ph_no=" + ph_no + ", total_rooms="
				+ total_rooms + ", Avail_rooms=" + Avail_rooms + ", Booked_rooms=" + Booked_rooms + ", cost=" + cost
				+ "]";
	}

	
	
	
}
