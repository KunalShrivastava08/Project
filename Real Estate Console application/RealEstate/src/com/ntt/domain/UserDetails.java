package com.ntt.domain;

public class UserDetails 
{
	private int roleid;
	private String name;
	private String email;
	private String password;
	private long contactnum;
	
	public UserDetails(int id, String name, String email, String password, long contactnum) 
	{
		this.roleid = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactnum = contactnum;
	}

	public UserDetails(int roleid) 
	{
		this.roleid = roleid;
	}

	public UserDetails(String email, String password,long contactnum) 
	{
		this.email = email;
		this.password = password;
		this.contactnum = contactnum;
	}

	public int getRoleid()
	{
		return roleid;
	}

	public void setRoleid(int id)
	{
		this.roleid = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public long getContactnum() 
	{
		return contactnum;
	}

	public void setContactnum(long contactnum)
	{
		this.contactnum = contactnum;
	}

	@Override
	public String toString() 
	{
		return "USER DETAILS ROWID = " + roleid + ", NAME = " + name + ", EMAIL = " + email + ", PASSWORD = " + password + ", CONTACT NUMBER ="
				+ contactnum;
	}


}
