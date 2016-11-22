package com.compugain.api;

public class LoginUserDetails {

	public String username;
	public String password;

	public LoginUserDetails(){};
	
	public LoginUserDetails(String username ,String password){
		this.username=username;
		this.password=password;
		
	}
	
	public String getUsername(){
		
		return username;
	}
	
	public String getPassword(){
		
		return password;
	}
	
	public void setUserName(String username){
		
		this.username=username;
		
	}
	public void setPassword(String password){
		
		this.password=password;
		
	}
}
