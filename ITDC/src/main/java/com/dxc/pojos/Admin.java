package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
	
	@Id
	private int AdminId;
	private String Password;
	
	public Admin()
	
	{
		
	}
	
	
	public Admin(int adminId, String password) {
		super();
		AdminId = adminId;
		Password = password;
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", Password=" + Password + "]";
	}
	

}
