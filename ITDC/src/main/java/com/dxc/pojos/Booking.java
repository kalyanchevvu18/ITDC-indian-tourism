package com.dxc.pojos;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	@Id
	private int Booking_Id;
	private String Booking_Status;
	private int User_Id;
	private String H_Id;
	private String Hotel_Name;
	private String Customer_Name;
	private long Phone_Number;
	private String Address;
	
	private String Proof_Name;
	private long Proof_Details;
	
	private int no_of_perons ;
	private int no_of_rooms;
	private int no_of_days;
	private String date;
	private double bill;
	
	
	
	
	
	
	public Booking()
			{
		
			}




	public Booking(int booking_Id, String booking_Status, int user_Id, String h_Id, String hotel_Name,
			String customer_Name, long phone_Number, String address, String proof_Name, long proof_Details,
			int no_of_perons, int no_of_rooms, int no_of_days, String date, double bill) {
		super();
		Booking_Id = booking_Id;
		Booking_Status = booking_Status;
		User_Id = user_Id;
		H_Id = h_Id;
		Hotel_Name = hotel_Name;
		Customer_Name = customer_Name;
		Phone_Number = phone_Number;
		Address = address;
		Proof_Name = proof_Name;
		Proof_Details = proof_Details;
		this.no_of_perons = no_of_perons;
		this.no_of_rooms = no_of_rooms;
		this.no_of_days = no_of_days;
		this.date = date;
		this.bill = bill;
	}













	public int getBooking_Id() {
		return Booking_Id;
	}






	public void setBooking_Id(int booking_Id) {
		Booking_Id = booking_Id;
	}






	public int getUser_Id() {
		return User_Id;
	}






	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}






	public String getH_Id() {
		return H_Id;
	}






	public void setH_Id(String h_Id) {
		H_Id = h_Id;
	}






	public String getHotel_Name() {
		return Hotel_Name;
	}






	public void setHotel_Name(String hotel_Name) {
		Hotel_Name = hotel_Name;
	}






	public String getCustomer_Name() {
		return Customer_Name;
	}






	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}






	public long getPhone_Number() {
		return Phone_Number;
	}






	public void setPhone_Number(long phone_Number) {
		Phone_Number = phone_Number;
	}






	public String getAddress() {
		return Address;
	}






	public void setAddress(String address) {
		Address = address;
	}






	public String getProof_Name() {
		return Proof_Name;
	}






	public void setProof_Name(String proof_Name) {
		Proof_Name = proof_Name;
	}






	public long getProof_Details() {
		return Proof_Details;
	}






	public void setProof_Details(long proof_Details) {
		Proof_Details = proof_Details;
	}






	public int getNo_of_perons() {
		return no_of_perons;
	}






	public void setNo_of_perons(int no_of_perons) {
		this.no_of_perons = no_of_perons;
	}






	public int getNo_of_rooms() {
		return no_of_rooms;
	}






	public void setNo_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}






	public int getNo_of_days() {
		return no_of_days;
	}






	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}






	public String getDate() {
		return date;
	}






	public void setDate(String date) {
		this.date = date;
	}






	public double getBill() {
		return bill;
	}






	public void setBill(double bill) {
		this.bill = bill;
	}



	



	public String getBooking_Status() {
		return Booking_Status;
	}




	public void setBooking_Status(String booking_Status) {
		Booking_Status = booking_Status;
	}




	@Override
	public String toString() {
		return "Booking [Booking_Id=" + Booking_Id + ", Booking_Status=" + Booking_Status + ", User_Id=" + User_Id
				+ ", H_Id=" + H_Id + ", Hotel_Name=" + Hotel_Name + ", Customer_Name=" + Customer_Name
				+ ", Phone_Number=" + Phone_Number + ", Address=" + Address + ", Proof_Name=" + Proof_Name
				+ ", Proof_Details=" + Proof_Details + ", no_of_perons=" + no_of_perons + ", no_of_rooms=" + no_of_rooms
				+ ", no_of_days=" + no_of_days + ", date=" + date + ", bill=" + bill + "]";
	}







	

}
