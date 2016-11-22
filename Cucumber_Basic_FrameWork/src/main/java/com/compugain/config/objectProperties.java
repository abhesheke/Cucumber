package com.compugain.config;

public enum  objectProperties {
	
	
	cgtt_username("//input[@id='ctl00_ContentPlaceHolder1_txtUserName']"),
	cgtt_password("//input[@id='ctl00_ContentPlaceHolder1_txtPassword']"),
	cgtt_loginsubmitbutton("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']");

	
		private String property;
	private objectProperties(String property) {
		this.setProperty(property);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	
}
