package com.ntt.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Scanner;
import org.junit.Test;

import com.ntt.dao.FormDAO;
import com.ntt.domain.UserDetails;

public class FormTest {
	Scanner sc = new Scanner(System.in);


	@Test 
	public void testRegistration()//test method for test registration 
	{
		System.out.println("\n<----------REGISTRATION FORM ----------->\n");
		int roleid=0;
		System.out.println("PRESS 1 :- REGISTERATION FOR BUYER");
		System.out.println("PRESS 2 :- REGISTERATION FOR SELLER");
		System.out.println("PRESS 3 :- REGISTERATION FOR ADMIN");
		int num=sc.nextInt();
		switch (num) 
		{
		case 1:
			roleid=101;
			break;
		case 2:
			roleid=102;
			break;
		case 3:
			roleid=103;
			break;
		default:
			System.out.println("INVALID INPUT");
			break;
		}
		System.out.println("ENTER YOUR NAME :-");
		String name=sc.next(); 
		System.out.println("ENTER YOUR EMAIL ID :-"); 
		String
		email=sc.next(); 
		System.out.println("ENTER YOUR PASSWORD :-"); 
		String
		password=sc.next(); 
		System.out.println("ENTER YOUR CONTACT NUMBER :-"); 
		long contactnum=sc.nextLong();
		UserDetails userdetails=new UserDetails(roleid,name, email, password, contactnum);
		int actual=FormDAO.insertUserDetails(userdetails);
		System.out.println("Enter Expected no. of row added in table"); 
		int expected=sc.nextInt();
		assertEquals(expected,actual); 
	}


	@Test
	public void testLogin()// test method to test login part
	{
		System.out.println("\n<----------LOGIN PAGE ----------->\n");
		String userid=null;
		long cnum=0;
		System.out.println("PRESS 1 :- TO ENTER EMAIL ID");
		System.out.println("PRESS 2 :- TO ENTER CONTACT NUMBER");
		int num=sc.nextInt();
		switch (num) 
		{
		case 1:
			System.out.println("ENTER YOUR EMAIL ID :- ");
			userid=sc.next();
			break;
		case 2:
			System.out.println("ENTER YOUR CONTACT NUMBER :- ");
			cnum=sc.nextLong();
			break;
		default:
			System.out.println("INVALID INPUT");
			break;
		}
		System.out.println("ENTER YOUR PASSWORD :-");
		String userpassword = sc.next();
		UserDetails ud=new UserDetails(userid,userpassword,cnum);
		List clist = FormDAO.getUserDetails(ud);
		UserDetails obj = (UserDetails) clist.get(0);
		int actual = obj.getRoleid();
		System.out.println("Enter Expected roleid.");
		int expected = sc.nextInt();
		assertEquals(expected, actual);
	}

}
