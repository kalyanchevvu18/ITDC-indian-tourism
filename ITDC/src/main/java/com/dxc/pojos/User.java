package com.dxc.pojos;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	private int UserId;
	private String UserName;
	
	
	
	
	public User()
	{
		
	}
	
	
	
	
	
	public User(int userId, String userName) {
		super();
		UserId = userId;
		UserName = userName;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}





	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + "]";
	}
	
	
	
	
	
}
