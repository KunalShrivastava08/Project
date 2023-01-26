package com.ntt.domain;

public class BookPropertyDetail {
	private int propertyid;
	private String email;
	private String date;
	
	public BookPropertyDetail(int propertyid, String email, String date) 
	{
		this.propertyid = propertyid;
		this.email = email;
		this.date = date;
	}

	public BookPropertyDetail(String email)
	{
		this.email = email;
	}

	public int getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BOOK PROPERTY DETAIL PROPERTY ID = " + propertyid + ", EMAIL ID = " + email + ", BOOKING DATE = " + date ;
	}
	
	
}
