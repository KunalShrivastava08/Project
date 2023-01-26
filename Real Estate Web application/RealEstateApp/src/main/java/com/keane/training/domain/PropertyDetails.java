package com.keane.training.domain;

public class PropertyDetails 
{
	private int propertyid;
	private String location;
	private String type;
	private long price;
	private String available;
	private String email;
	private String validity;
	
	
	public PropertyDetails(String location, String type, long price, String available, String email) {
		this.location = location;
		this.type = type;
		this.price = price;
		this.available = available;
		this.email = email;
	}

	
	
	
	
	public PropertyDetails(String location, String type, long price)//use
	{
		this.location = location;
		this.type = type;
		this.price = price;
	}





	public PropertyDetails(int propertyid, String location, String type, long price, String available)//use
	{
		this.propertyid = propertyid;
		this.location = location;
		this.type = type;
		this.price = price;
		this.available = available;
	}
	
	

	public PropertyDetails(int propertyid, String location, String type, long price, String available, String email,
			String validity) //use
	{
		this.propertyid = propertyid;
		this.location = location;
		this.type = type;
		this.price = price;
		this.available = available;
		this.email = email;
		this.validity = validity;
	}

	public PropertyDetails(String email,String available)//use
	{
		this.email=email;
		this.available=available;
	}





	public PropertyDetails(int propertyid, String validity)//use
	{
		this.propertyid = propertyid;
		this.validity = validity;
	}





	public PropertyDetails(int propertyid) //use
	{
		this.propertyid = propertyid;
	}





	public PropertyDetails(long price) 
	{
		this.price = price;
	}





	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	@Override
	public String toString() {
		return "PropertyDetails PROPERTY ID = " + propertyid + ", LOCATION = " + location + ", TYPE = " + type + ", PRICE = "
				+ price + ", AVAILABLE = " + available + ", SELLER EMAIL ID = " + email + ", VARIFIED = "+validity;
	}
	
    

}
