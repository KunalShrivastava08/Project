package com.ntt.test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import com.ntt.dao.SellerDAO;
import com.ntt.domain.PropertyDetails;

public class SellerTest 
{
	Scanner sc=new Scanner(System.in);

	@Test
	public void testInsertOperation()//test method insert no. rows in table. 
	{
		System.out.println("ENTER LOCATION");
		String location=sc.next();
		System.out.println("ENTER TYPE OF THE PROPERTY :- 1BHK,2BHK,3BHK or others");
		String type=sc.next();
		System.out.println("ENTER PRICE FOR YOUR SITE");
		long price=sc.nextLong();
		String available="YES";
		System.out.println("ENTER EMAILID");
		String userid=sc.next();
		PropertyDetails pd= new PropertyDetails(location, type,price,available,userid);
		int actual=SellerDAO.insertPropertyDetails(pd);
		System.out.println("Enter Expected value");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}

	@Test
	public void testUpdateAvailability()//test UpdateAvailability and get no. rows change in table. 
	{
		Scanner sc=new Scanner(System.in);
		int actual=0; 
		String avail=null;
		System.out.println("ENTER EMAIL ID");
		String userid=sc.next();
		List list= SellerDAO.getUserProperty(userid);
		System.out.println("ALL YOUR PROPERTIES ");
		for(Iterator it=list.iterator();it.hasNext();)//Printing all the details present inside the list
		{
			System.out.println(it.next());
		}
		int pid=0;
		System.out.println("ENTER PROPERTY ID WHICH YOU WHAT TO CHANGE THE AVAILABILITY");
		pid=sc.nextInt();
		System.out.println("PRESS 1 :- IF YOUR PROPERTY IS AVAILABLE");
		System.out.println("PRESS 2 :- IF YOUR PROPERTY IS SOLD OR NOT AVAILABLE");
		int check=sc.nextInt();
		if(check==1)
		{
			avail="YES";
		}
		else if(check==2)
		{
			avail="NO";
		}
		else 
			System.out.println("PLEASE ENTER VALID INPUT");

		actual=SellerDAO.updateAvailability(pid,avail);
		System.out.println("Enter Expected value");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
}
