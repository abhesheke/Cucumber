package com.compugain.api;

public class CreateUserDetails {

	public  String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public  String email;
	public  String firstName;
	public  String lastName;
	public  String language;
	public  String title;
	public  String username;
	public  String roleId;
	
	/*public CreateUserDetails(){
	
		String threeAlphanumeric= RandomStringUtils.randomAlphabetic(3);
		
		Random r = new Random();
		int countryCode = r.nextInt((1900 - 500) + 1) + 500;
		int localCode = r.nextInt((1500 - 400) + 1) + 400;
		int phNumber = r.nextInt((19000 - 4500) + 1) + 4500;
	
		 phoneNumber = "(" + countryCode + ") " + localCode + "-" + phNumber + "";
	//	 firstName = "fnameAPiuser" + threeAlphanumeric;

		String language = "en";
		email="emailAPI"+threeAlphanumeric+"@gmail.com";
		*//*** lastName ***//*
		int lnameRND = r.nextInt((1100 - 10) + 1) + 10;
	//	lastName = "lnameAPiuser" + threeAlphanumeric;
		*//*** title ***//*
		 title = firstName;
		*//*** userName ***//*
		 username = firstName;
		System.out.println("UserName is--->" + username);
		
	}*/
	
	public  void userType(String roleId){
		setRoleId(roleId);
	}
	
	public void CreateUserDetails_withoutUsername(String roleId){
		this.roleId=roleId;
		this.username="";
	}
	
}
