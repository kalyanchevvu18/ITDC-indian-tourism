package com.dxc.services;

import java.util.List;

import org.bson.Document;


import com.dxc.daos.MyDaos;
import com.dxc.pojos.Booking;
import com.dxc.pojos.hotel;

public class AdminServiceImpl {

	MyDaos dao=new MyDaos();
	
	public boolean checkId(int id) {
		
		return dao.checkId(id);
	}
	
	
	
	
	public boolean addAdmin(int id, String pass, String repass) {
		
		return dao.addAdmin(id,pass,repass);
	}




	public boolean checkUId(int id) {

		return dao.checkUId(id);
	}




	public boolean addUser(int id, String pass, String repass) {
		return dao.addUser(id,pass,repass);
		
	}




	public boolean adminLogin(int id, String pass) {
		
		return dao.adminLogin(id,pass);
	}




	public boolean userLogin(int id, String pass) {
		return dao.userLogin(id,pass);
	}




	public void addHotel(hotel h) {
		dao.addHotel(h);
		
	}




	public List<hotel> getHotels() {
		
		return dao.getHotels();
	}




	public boolean hotelId(hotel h) {
		return dao.hotelId(h);
	}




	public hotel searchHotel(String id) {
		return dao.searchHotel(id);
		
	}




	public String bookRoom(Booking b) {
		
		return dao.bookRoom(b);
		
	}




	public void updateRooms(Booking b) {
		dao.updateRooms(b);
		
	}




	public List<Booking> getPrevBooks() {
		
		return dao.getPrevBooks();
	}




	public List<Booking> getAllBookings() {
		
		return dao.getAllBookings();
		}




	public boolean cancelBooking(int bid) {
		return dao.cancelBooking(bid);
		
	}




	public boolean adminCancel(int uid, int bid) {
	
		return dao.adminCancel(uid,bid);
	}




	public boolean delHotel(String hid) {
		
		return dao.delHotel(hid);
	}




	public List<Booking> ReqBookCan() {
		
		return dao.ReqBookCan();
	}




	public String cancel_user_req(int uid, int bid) {
		return dao.cancel_user_req( uid, bid);
		
	}




	public void approveall() {
	dao.approveall();
		
	}


	


	

}
