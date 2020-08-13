package com.dxc.controller;




import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Booking;
import com.dxc.pojos.hotel;
import com.dxc.services.AdminServiceImpl;

@Controller

public class MyController {
	
	AdminServiceImpl as=new AdminServiceImpl();

	@RequestMapping("/open")
	public String create()
	{
		return "create";
	}
	
	@RequestMapping("/admin")
	public String addAdmin(@RequestParam int id,@RequestParam String pass,@RequestParam String repass, Model m)
	{
	
		if(as.checkId(id))
		{
			String message="Admin is already exist,please register with another details";
			m.addAttribute("message", message);
			return "message";
		}
		
		else
		{
			
			if(as.addAdmin(id,pass,repass))
			{
			    String message="Admin Sucessfully Created";
				m.addAttribute("message", message);
				return "message";
			}
			else
			{
				String message="Passwords Do not Match";
				m.addAttribute("message", message);
				return "message";
			}
		    
		}
	
	}
	
	
	
	@RequestMapping("/user")
	public String addUser(@RequestParam int id,@RequestParam String pass,@RequestParam String repass,Model m)
	{
		

		if(as.checkUId(id))
		{
			String message="UserIdis alreday in use. Please enter Different one";
			m.addAttribute("message", message);
			return "message";
		}
		else
		{
			
			if(as.addUser(id,pass,repass))
			{
				 String message="User Sucessfully created";
					m.addAttribute("message", message);
					return "message";
			}
			else {
				String message="Passwords Do not Match";
				m.addAttribute("message", message);
				return "message";
			}
		   
		}
	
	}
	

	
	
	
	@RequestMapping("/adminlog")
	public String adminLogin(@RequestParam int id,@RequestParam String pass,Model m)
	{
		
			
		if(as.checkId(id))
		{
					if(as.adminLogin(id,pass))
					{
						String message="Login Successful..!!";
						m.addAttribute("message", message);
						return "adminOpp";
					}
					else
					{
						
					    String message="Wrong Password..:(";
						m.addAttribute("message", message);
						return "message";
					}
		}
		else
		{
			
		    String message="Wrong AdminId..:(";
			m.addAttribute("message", message);
			return "message";
		}
		
		
		
	}
	
	
	
	@RequestMapping("/userlog")
	public String userLogin(@RequestParam int id,@RequestParam String pass,Model m)
	{

		if(as.checkUId(id))
		{
				if(as.userLogin(id,pass))
				{
						String message="Login Successful..!!";
						m.addAttribute("message", message);
						return "userOpp";
				}
				else
				{
					
				    String message="Wrong Password..:(";
					m.addAttribute("message", message);
					return "message";
				}
		}
		else
		{
			
		    String message="Wrong UserId..:(";
			m.addAttribute("message", message);
			return "message";
		}
		
		
		
		
	}
	
	
	
	@GetMapping("/addhotel")
	public String addHotel(@ModelAttribute hotel h,Model m)
	{

	if(as.hotelId(h))
		{
			String message="Hotel_Id  is alreday in use. Please enter Different id";
			m.addAttribute("message", message);
			return "message";
		}
		else
		{
			
			 as.addHotel(h);
		        String message="Hotel Added Succesfully...!!";
				m.addAttribute("message", message);
				return "message";
		}
		   
		
		
	}
	
	

	
	@RequestMapping("/hotels")
	public String getHotels(Model m)
	{
		   
	List<hotel> list= as.getHotels();
		String message="Hotels for U..!!";
		m.addAttribute("message", message);
		m.addAttribute("list", list);
			return "hotellist";
		
		
	}
	
	
	
	
	@RequestMapping("/searhotel")
	public String searchHotel(@RequestParam String id,Model m)
	{
		   
	  hotel h= as.searchHotel(id);
	  List<hotel> list=new ArrayList();
	  list.add(h);
		String message="Details of Hotel ..";
		m.addAttribute("message", message);
		m.addAttribute("list", list);
		
			return "searhotel";
		
		
	}
	
	@RequestMapping("/book")
	public String bookRoom(@ModelAttribute Booking b,Model m)
	
	{
		String s=as.bookRoom(b);
		  if(s.equalsIgnoreCase("ok"))
			{
			  as.updateRooms(b);
			 
				String message="Rooms are Booked in hotel..:)!!";
				m.addAttribute("message", message);
				return "msg";
			}
		
	  if(s.equalsIgnoreCase("noroom"))
		{
			String message="You Entered More No.Of Rooms than Available Rooms  in this hotel..:(";
			m.addAttribute("message", message);
			return "message";
		}
	  if(s.equalsIgnoreCase("zero"))
			{
				String message="No More Rooms Available in this hotel..:(";
				m.addAttribute("message", message);
				return "message";
			}
	  else
	  {
		  String message="Hotel With Id You Entered is not found..:(";
			m.addAttribute("message", message);
			return "message";
	  }

		
	}
	@RequestMapping("/prevbook")
	public String getPrevBooks(Model m)
	{
		List<Booking> lis=as.getPrevBooks();
		  String message="Here Your Previous Bookings..!!";
				m.addAttribute("message", message);
				m.addAttribute("list", lis);
		return "prevbooks";
		
	}
	
	@RequestMapping("/bookings")
	public String getAllBookings(Model m){
		List<Booking> lis=as.getAllBookings();
		 String message="Here Your Have All Hotel Bookings..!!";
			m.addAttribute("message", message);
			m.addAttribute("list", lis);
		return "allbookings";
		
	}
	
	
	@RequestMapping("/cancel")
	public String cancelBooking(@RequestParam int bid,Model m){
		if(as.cancelBooking(bid))
		{
				 String message="Your Cancellation Request with Booking_Id-"+bid+" is sent to Admin";
					m.addAttribute("message", message);
					
				return "message";
			}

		else
		{
			String message="Booking_Id-"+bid+" is not found in Your Bookings..:(";
			m.addAttribute("message", message);
			
		return "message";
		}
		
		
		
	}
	
	
	@RequestMapping("/admincancel")
	public String adminCancel(@RequestParam int uid,@RequestParam int bid,Model m)
	{
	      if(as.adminCancel(uid,bid))
	       {
	    	      String message="Booking with Uers_Id-"+uid+" & Booking_Id-"+bid+" is Cancelled";
				  m.addAttribute("message", message);
				  return "message";
	    	 }
		
	  	else
		{
			String message="Booking with Uers_Id-"+uid+" & Booking_Id-"+bid+" is not found in Bookings..:(";
			m.addAttribute("message", message);
			
		return "message";
		}
	}
	
	
	@RequestMapping("/delhotel")
	public String delHotel(@RequestParam String hid,Model m)
	{
		if(as.delHotel(hid))
		{
			   String message="Hotel with Hote_Id-"+hid+" is Removed";
				  m.addAttribute("message", message);
				  return "message";
	    	 }
		
	  	else
		{
	  		String message="Hotel with Hote_Id-"+hid+" is not Found";
			m.addAttribute("message", message);
			
		return "message";
		}
	}
	
	
	
	@RequestMapping("/user_req_can")
	public String getcanceluserreq(Model m)
	{
		List<Booking> req_can_boklis=as.ReqBookCan();
		 String message="User Requested for Cancellation of this bookings";
			m.addAttribute("message", message);
			m.addAttribute("list",req_can_boklis);
	return "req_can_lis";
	
		
	}
	@RequestMapping("/approve")
	public String canceluserreq(@RequestParam int uid,@RequestParam int bid,Model m)
	{
		String st=as.cancel_user_req(uid,bid);
		if(st.equalsIgnoreCase("found")) {
			 String message=" Cancellation is done on User Request";
				m.addAttribute("message", message);
				return "message";
		}
		else {
			 String message="User_Id and Booking_Id Donot match TO cancle Booking";
				m.addAttribute("message", message);
				return "message";
		}
		
	
		
	}
	
	@RequestMapping("/approveall")
	public String cancel_alluserreq(Model m)
	
	{
		as.approveall();
		 String message="All Cancellations are done on Users Request";
			m.addAttribute("message", message);
			return "message";
		
	}
	
	
	
	
	

}
