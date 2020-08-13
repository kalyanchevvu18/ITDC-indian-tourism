package com.dxc.daos;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.bson.Document;

import com.dxc.pojos.Booking;
import com.dxc.pojos.hotel;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
public class MyDaos {
	int x=0;
	Random ran=new Random();
	int av=0;
	int booked=0;

    MongoClient client=new MongoClient("localhost",27017);
     MongoDatabase mdb=client.getDatabase("test");
     MongoCollection<Document> collection= mdb.getCollection("admin");
     MongoCollection<Document> collection1= mdb.getCollection("user");
     MongoCollection<Document> hotel_coll= mdb.getCollection("hotel");
     MongoCollection<Document> book_coll= mdb.getCollection("booking");
    

     public boolean checkId(int id) {
    		boolean flag=false;
    		
   		 FindIterable<Document> cursor= collection.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
           while(itr.hasNext())
   	     {
   	         int x= (int) itr.next().get("AdminId");
   	         
           	    if(x==id)
           	    {
           	    	
           	    	flag=true;
           	    }
           	
           	    
   	    	
   	     }
   	   
   		
   		return flag;
 	}
      
	

	
	public boolean addAdmin(int id, String pass, String repass) {
	if(pass.equalsIgnoreCase(repass))
	{
	     Document d=new Document();
	     d.append("AdminId",id);
	     d.append("password",pass);
	     collection.insertOne(d);
	     return true;
	}
	else {
		return false;
	}
	}




	public boolean checkUId(int id) {
		boolean flag=false;
		
  		 FindIterable<Document> cursor= collection1.find();
  	     MongoCursor<Document> itr=cursor.iterator();
  	     
          while(itr.hasNext())
  	     {
  	         int x= (int) itr.next().get("UserId");
  	    	
          	    if(x==id)
          	    {
          	    	
          	    	flag=true;
          	    }
          	
          	    
  	    	
  	     }
  	   
  		
  		return flag;
	}




	public boolean addUser(int id, String pass, String repass) {
		
		if(pass.equalsIgnoreCase(repass))
		{
		  Document d1=new Document();
		     d1.append("UserId",id);
		     d1.append("password",pass);
		     collection1.insertOne(d1);
		     return true;
		}
		else {
			return false;
		}
		
		
	}




	public boolean adminLogin(int id, String pass) {
		boolean f=false;
		 Document s1=new Document();
	     s1.append("AdminId",id);
	     FindIterable<Document> cursor= collection.find(s1);
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
	     while(itr.hasNext())
  	     {
  	         String p=itr.next().getString("password");
  	   
  	         if(p.equalsIgnoreCase(pass))
          	    {
          	    	
          	    	f=true;
          	    }	    
  	    	
  	     }
	     
	     
		return f;
	     
	}




	public boolean userLogin(int id, String pass) {
		boolean f=false;
		 Document s2=new Document();
	     s2.append("UserId",id);
	     FindIterable<Document> cursor= collection1.find(s2);
  	     MongoCursor<Document> itr=cursor.iterator();
  	     
	     while(itr.hasNext())
 	     {
 	         String p=itr.next().getString("password");
 	   
 	         if(p.equalsIgnoreCase(pass))
         	    {
         	    	x=id;
         	    	f=true;
         	    }	    
 	    	
 	     }
	     
	     
		return f;
	}




	public boolean hotelId(hotel h) {
		
		boolean status=false;
		 FindIterable<Document> cursor= hotel_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
   	   
           while(itr.hasNext())
   	     {
        	   String s=itr.next().getString("Hotel_Id");
        	   if(h.getId().equalsIgnoreCase(s))
        	   {
        		   status=true;
        	   }
        	   
        	   
   	     }
           return status;
		
	}

	public void addHotel(hotel h) {
		

	  
		Document h1= new Document();
		h1.append("Hotel_Id",h.getId());
		h1.append("Hotel Name", h.getName());
		h1.append("Hotel Address", h.getAddress());
		h1.append("Contact Number", h.getPh_no());
		h1.append("Total_Rooms", h.getTotal_rooms());
		h1.append("Available_Rooms", h.getAvail_rooms());
		h1.append("Booked_Rooms", h.getBooked_rooms());
		h1.append("Cost_Of_Room", h.getCost());
	
		hotel_coll.insertOne(h1);
		
	}




	public List<hotel> getHotels() {
	   List<hotel> hlis=new ArrayList<>();
		List<Document> dlis=new ArrayList<>();
		 FindIterable<Document> cursor= hotel_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
           while(itr.hasNext())
   	     {
             dlis.add(itr.next());
        	   
   	     }
           for(Document d1:dlis)
           {
        	   hotel h01=new hotel();
        	   h01.setId(d1.getString("Hotel_Id").toString());
        	   h01.setName(d1.getString("Hotel Name").toString());
        	   h01.setAddress(d1.getString("Hotel Address").toString());
        	   h01.setPh_no(d1.getLong("Contact Number"));
        	   h01.setTotal_rooms(d1.getInteger("Total_Rooms"));
        	   h01.setAvail_rooms(d1.getInteger("Available_Rooms"));
        	   h01.setBooked_rooms(d1.getInteger("Booked_Rooms"));
        	   h01.setCost(d1.getDouble("Cost_Of_Room"));
        	   
        	   hlis.add(h01);
           }
		return hlis;
		
	}




	public hotel searchHotel(String id) {
		 FindIterable<Document> cursor= hotel_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	  hotel h01=new hotel();
           while(itr.hasNext())
   	     {
        	Document d01=itr.next();
        	String s=d01.getString("Hotel_Id");
            if(s.equalsIgnoreCase(id))
            {
            	
          	   h01.setId(d01.getString("Hotel_Id").toString());
          	   h01.setName(d01.getString("Hotel Name").toString());
          	   h01.setAddress(d01.getString("Hotel Address").toString());
          	   h01.setPh_no(d01.getLong("Contact Number"));
          	   h01.setTotal_rooms(d01.getInteger("Total_Rooms"));
          	   h01.setAvail_rooms(d01.getInteger("Available_Rooms"));
          	   h01.setBooked_rooms(d01.getInteger("Booked_Rooms"));
          	   h01.setCost(d01.getDouble("Cost_Of_Room"));
            }
        	   
   	     }
		return h01;
		
	}



	public String bookRoom(Booking b) {
		 FindIterable<Document> cursor= hotel_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
   	     String out="";
   	 
   	     
		while(itr.hasNext())
		{
			Document dd=itr.next();
				if(dd.getString("Hotel_Id").equalsIgnoreCase(b.getH_Id()))
				{   
                       
					
								if((dd.getInteger("Available_Rooms"))>0)
									{
			 
														if((dd.getInteger("Available_Rooms"))>=b.getNo_of_rooms())
																{
					                                                 double price=dd.getDouble("Cost_Of_Room");
					                                                 int d=b.getNo_of_days();
			      						
			      														out="ok";
			      														int nor=b.getNo_of_rooms();
			      														int brom=dd.getInteger("Booked_Rooms");
			      														av=(int) (dd.getInteger("Available_Rooms")-(nor));
			      														booked=brom+nor;
			      														String name=dd.getString("Hotel Name");
					                        							Document b01=new Document();
			      														int z=ran.nextInt(100);
			      							                         
			      														double bill=(price*nor*d);
			      														
			      														
			      														
			      														b01.append("User_Id", x);
			      														b01.append("Booking_Id", z);
			      														b01.append("H_Id", b.getH_Id());
			      														b01.append("Hotel_Name", name);
			      														b01.append("Customer_Name",b.getCustomer_Name());
			      														b01.append("Phone_Number", b.getPhone_Number());
			      														b01.append("Address", b.getAddress());
			      														b01.append("Proof_Name", b.getProof_Name());
			      														b01.append("Proof_Details", b.getProof_Details());
			      														b01.append("no_of_perons", b.getNo_of_perons());
			      														b01.append("no_of_rooms", b.getNo_of_rooms());
			      														b01.append("no_of_days", b.getNo_of_days());
			      														b01.append("date", b.getDate());
			      														b01.append("bill", bill);
			      														b01.append("Booking_Status","Booking Confirmed");
			      														book_coll.insertOne(b01);	
			      														
																}
														
														else {
					  	
															out="noroom";
														}
				
										}
								else {
						
									out="zero";
								}
			      			
				}
		
			
			
				
			
		}
	
		
		return out;
		
	
		
	}




	public void updateRooms(Booking b) {


Document oldH=new Document();
oldH.append("Hotel_Id",b.getH_Id());
 Document updH=new Document();
 
  updH.append("$set",new Document("Available_Rooms",av));
  hotel_coll.updateOne(oldH, updH);
  
  updH.append("$set",new Document("Booked_Rooms",booked));
  hotel_coll.updateOne(oldH, updH);

	
		
	}




	public List<Booking> getPrevBooks() {
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     List<Booking> list=new ArrayList<>();
   	  List<Document> dl=new ArrayList<>();
   	     while(itr.hasNext())
   	     {
   	    	 Document d3=itr.next();
   	    	 if((d3.getInteger("User_Id"))==x)
   	    	 {
   	          dl.add(d3); 
   	    	 }
       
        	   
   	     }
           for(Document d1:dl)
           {
        	 Booking b11=new Booking();
        	 b11.setBooking_Id(d1.getInteger("Booking_Id"));
        	 b11.setH_Id(d1.getString("H_Id").toString());
        	 b11.setUser_Id(x);
        	 b11.setHotel_Name(d1.getString("Hotel_Name"));
        	 b11.setCustomer_Name(d1.getString("Customer_Name"));
        	 b11.setNo_of_perons(d1.getInteger("no_of_perons"));
        	 b11.setNo_of_rooms(d1.getInteger("no_of_rooms"));
        	 b11.setNo_of_days(d1.getInteger("no_of_days"));
        	 b11.setDate(d1.getString("date"));
        	 b11.setBill(d1.getDouble("bill"));
        	 b11.setBooking_Status(d1.getString("Booking_Status"));
        	   list.add(b11);
           }
		return list;
		
	}




	public List<Booking> getAllBookings() {
		
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     List<Booking> list=new ArrayList<>();
   	  List<Document> dl=new ArrayList<>();
   	     while(itr.hasNext())
   	     {
   	    	 Document d3=itr.next();
   	       dl.add(d3); 
   	    	 
       
        	   
   	     }
           for(Document d1:dl)
           {
        	 Booking b11=new Booking();
        	 b11.setBooking_Id(d1.getInteger("Booking_Id"));
        	 b11.setUser_Id(d1.getInteger("User_Id"));
        	 b11.setH_Id(d1.getString("H_Id").toString());
        	 b11.setHotel_Name(d1.getString("Hotel_Name"));
        	 b11.setCustomer_Name(d1.getString("Customer_Name"));
        	 b11.setPhone_Number(d1.getLong("Phone_Number"));
        	 b11.setAddress(d1.getString("Address"));
        	 b11.setProof_Name(d1.getString("Proof_Name"));
        	 b11.setProof_Details(d1.getLong("Proof_Details"));
        	 b11.setNo_of_perons(d1.getInteger("no_of_perons"));
        	 b11.setNo_of_rooms(d1.getInteger("no_of_rooms"));
        	 b11.setNo_of_days(d1.getInteger("no_of_days"));
        	 b11.setDate(d1.getString("date"));
        	 b11.setBill(d1.getDouble("bill"));
        	 b11.setBooking_Status(d1.getString("Booking_Status"));
        	 
        	   list.add(b11);
           }
		return list;
	}




	public boolean cancelBooking(int bid) {
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
   	  FindIterable<Document> cursor1= hotel_coll.find();
	     MongoCursor<Document> itr1=cursor1.iterator();
	     
	     boolean f=false;
	     String hid="";
	     int rom;
   	  while(itr.hasNext())
	     {
   		       Document d3=itr.next();
   		       if((d3.getInteger("User_Id"))==x && d3.getInteger("Booking_Id")==bid)
   		       {
   		    	   		hid=d3.getString("H_Id");
   		    	   		rom=d3.getInteger("no_of_rooms");
   		    	   		
	    		     
	    		 
	    		      				/*	while(itr1.hasNext())
	    		      					{
	    		      									Document d4=itr1.next();
	    		      							if(d4.getString("Hotel_Id").equalsIgnoreCase(hid))
	    		      							{
	    		 			 
	    		      								Document or=new Document();
	    		      								Document nr=new Document();
	    		      								
	    		      								or.append("Hotel_Id",hid);
	    		      								int oldrom=d4.getInteger("Available_Rooms");
	    		      								int updrom=oldrom+rom;	 
	    		      								nr.append("$set",new Document("Available_Rooms",updrom));
	    		      								hotel_coll.updateOne(or,nr);
	    		      								
	    		      								int bkrom=d4.getInteger("Booked_Rooms");
	    		      								int bokrom=bkrom-rom;
	    		      								nr.append("$set",new Document("Booked_Rooms",bokrom));
	    		      								hotel_coll.updateOne(or,nr);
	    		      							}
	    		      					}*/
	    		      
	    		      					Document s01=new Document();
	    		   		    	   		s01.append("Booking_Id",bid);
	    		   		    	   		
	    		   		    	   	Document s02=new Document();
	    	   		    	   		s02.append("$set",new Document("Booking_Status","Requested For Cancellation"));
	    	   		    	   	book_coll.updateOne(s01,s02);
	    		      					 f=true;
	    		   }
   		   }
	return f;
   	  		
	}




	public boolean adminCancel(int uid, int bid) {
	
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
   	  FindIterable<Document> cursor1= hotel_coll.find();
	     MongoCursor<Document> itr1=cursor1.iterator();
   	     
	     String hid="";
	     int rom;
   	     
   	     boolean f=false;
   	  while(itr.hasNext())
	     {
		       Document d3=itr.next();
		       if((d3.getInteger("User_Id"))==uid && d3.getInteger("Booking_Id")==bid)
		       {
		    	        hid=d3.getString("H_Id");
		    	   		rom=d3.getInteger("no_of_rooms");
		    	   		Document s01=new Document();
		    	   		s01.append("Booking_Id",bid);
		    	   		
		    	   		while(itr1.hasNext())
      					{
      									Document d4=itr1.next();
      							if(d4.getString("Hotel_Id").equalsIgnoreCase(hid))
      							{
 			 
      								Document or=new Document();
      								Document nr=new Document();
      								or.append("Hotel_Id",hid);
      								int oldrom=d4.getInteger("Available_Rooms");
      								int updrom=oldrom+rom;	 
      								nr.append("$set",new Document("Available_Rooms",updrom));
      								hotel_coll.updateOne(or,nr);
      							}
      					}
		    	   		
		    	   		
		    	   		book_coll.deleteOne(s01);
		    	   		f=true;
		    	   
		       }
		       
	     }
	return f;
		
	}




	public boolean delHotel(String hid) {
		boolean f=false;
		FindIterable<Document> cursor1= hotel_coll.find();
	     MongoCursor<Document> itr1=cursor1.iterator();
	     while(itr1.hasNext())
			{
							Document d4=itr1.next();
					if(d4.getString("Hotel_Id").equalsIgnoreCase(hid))
					{

						
						hotel_coll.deleteOne(d4);
						f=true;
					}
					
					
			}
		return f;
	}




	public List<Booking> ReqBookCan() {
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	  List<Booking> list=new ArrayList<>();
   	  while(itr.hasNext())
	     {
		       Document d3=itr.next();
		       if(d3.getString( "Booking_Status").equalsIgnoreCase("Requested For Cancellation"))
		       {
		    	   Booking b11=new Booking();
		        	 b11.setBooking_Id(d3.getInteger("Booking_Id"));
		        	 b11.setH_Id(d3.getString("H_Id").toString());
		        	 b11.setUser_Id(x);
		        	 b11.setHotel_Name(d3.getString("Hotel_Name"));
		        	 b11.setCustomer_Name(d3.getString("Customer_Name"));
		        	 b11.setNo_of_perons(d3.getInteger("no_of_perons"));
		        	 b11.setNo_of_rooms(d3.getInteger("no_of_rooms"));
		        	 b11.setNo_of_days(d3.getInteger("no_of_days"));
		        	 b11.setDate(d3.getString("date"));
		        	 b11.setBill(d3.getDouble("bill"));
		        	 b11.setBooking_Status(d3.getString("Booking_Status"));
		        	 
		        	   list.add(b11);
		       }
	     }
	return list;
	}




	public String cancel_user_req(int uid, int bid) {
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
   	  FindIterable<Document> cursor1= hotel_coll.find();
	     MongoCursor<Document> itr1=cursor1.iterator();
   	     
   	     String s="";
   	  String hid="";
	     int rom;
	     
		 while(itr.hasNext())
	     {
		       Document d3=itr.next();
		       if((d3.getInteger("User_Id"))==uid && d3.getInteger("Booking_Id")==bid)
		       {
		    		hid=d3.getString("H_Id");
		    	   		rom=d3.getInteger("no_of_rooms");
		    	   		
    		     
    		 
    		      					while(itr1.hasNext())
    		      					{
    		      									Document d4=itr1.next();
    		      							if(d4.getString("Hotel_Id").equalsIgnoreCase(hid))
    		      							{
    		 			 
    		      								Document or=new Document();
    		      								Document nr=new Document();
    		      								
    		      								or.append("Hotel_Id",hid);
    		      								int oldrom=d4.getInteger("Available_Rooms");
    		      								int updrom=oldrom+rom;	 
    		      								nr.append("$set",new Document("Available_Rooms",updrom));
    		      								hotel_coll.updateOne(or,nr);
    		      								
    		      								int bkrom=d4.getInteger("Booked_Rooms");
    		      								int bokrom=bkrom-rom;
    		      								nr.append("$set",new Document("Booked_Rooms",bokrom));
    		      								hotel_coll.updateOne(or,nr);
    		      							}
    		      					}
    		      					Document s01=new Document();
    		   		    	   		s01.append("Booking_Id",bid);
    		   		    	   		
    		   		    	   	Document s02=new Document();
    	   		    	   		s02.append("$set",new Document("Booking_Status","Cancelled"));
    	   		    	   	book_coll.updateOne(s01,s02);
    	   		    	 book_coll.updateOne(s01,s02);
    		      					
    		      					s="found";
		    	   
		       }
		       
		     
	     }
		return s;
		
	}




	public void approveall() {
		 FindIterable<Document> cursor= book_coll.find();
   	     MongoCursor<Document> itr=cursor.iterator();
   	     
   	  FindIterable<Document> cursor1= hotel_coll.find();
	     MongoCursor<Document> itr1=cursor1.iterator();
   	     
   	     String s="";
   	  String hid="";
	     int rom;
	     
		 while(itr.hasNext())
	     {
		       Document d3=itr.next();
		       if(d3.getString( "Booking_Status").equalsIgnoreCase("Requested For Cancellation"))
		       {
		    		hid=d3.getString("H_Id");
		    	   		rom=d3.getInteger("no_of_rooms");
		    	   		
    		     
    		 
    		      					while(itr1.hasNext())
    		      					{
    		      									Document d4=itr1.next();
    		      							if(d4.getString("Hotel_Id").equalsIgnoreCase(hid))
    		      							{
    		 			 
    		      								Document or=new Document();
    		      								Document nr=new Document();
    		      								
    		      								or.append("Hotel_Id",hid);
    		      								int oldrom=d4.getInteger("Available_Rooms");
    		      								int updrom=oldrom+rom;	 
    		      								nr.append("$set",new Document("Available_Rooms",updrom));
    		      								hotel_coll.updateOne(or,nr);
    		      								
    		      								int bkrom=d4.getInteger("Booked_Rooms");
    		      								int bokrom=bkrom-rom;
    		      								nr.append("$set",new Document("Booked_Rooms",bokrom));
    		      								hotel_coll.updateOne(or,nr);
    		      							}
    		      					}
    		      					Document s01=new Document();
    		   		    	   		s01.append("Booking_Id",d3.getInteger("Booking_Id"));
    		   		    	   		
    		   		    	   	Document s02=new Document();
    	   		    	   		s02.append("$set",new Document("Booking_Status","Cancelled"));
    	   		    	   	book_coll.updateOne(s01,s02);
    	   		    	 book_coll.updateOne(s01,s02);
    		      					
		    	   
		       }
		       
		     
	     }
	
		
	}




	
	

}
