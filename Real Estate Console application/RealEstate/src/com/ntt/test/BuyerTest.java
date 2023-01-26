package com.ntt.test;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import com.ntt.dao.BuyerDAO;
import com.ntt.domain.BookPropertyDetail;
import com.ntt.domain.PropertyDetails;

public class BuyerTest
{
	Scanner sc=new Scanner(System.in);
	
	@Test
	public void testSelectAndViweSite()//test method for select and view part 
	{
		List availableproperty=null;
		System.out.println("ENTER YOUR LOCATION WHERE YOU WANT HOME");
		String location=sc.next();
		System.out.println("ENTER PROPERTY TYPE :-1BHK,2BHK,3BHK or others");
		String type=sc.next();
		System.out.println("ENTER YOUR BUDGET");
		long budget=sc.nextLong();
		PropertyDetails pd=new PropertyDetails(location, type, budget);
		 availableproperty=BuyerDAO.getAvailableProperty(pd);
		int actual=availableproperty.size();
		System.out.println("Enter Expected no. of row display ");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBookSite()//test method to book date 
	{
		System.out.println("ENTER PROPERTY ID");
		int propertyid=sc.nextInt();
		System.out.println("ENTER DATE TO SITE VISIT IN 'YYYYMMDD' FORMATE");
		String date=sc.next();
		System.out.println("ENTER USER ID");
		String userid=sc.next();
		BookPropertyDetail bookpropertydetail=new BookPropertyDetail(propertyid, userid, date);
		int actual=BuyerDAO.setBookingDate(bookpropertydetail);		
		System.out.println("Enter Expected no. of row added ");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMakePayment()//test method to payment 
	{
		List listprice=null;
		long actual=0;
		System.out.println("ENTER email id");
		String userid=sc.next();
		BookPropertyDetail bpd=new BookPropertyDetail(userid);
		listprice=BuyerDAO.getPrice(bpd);
		PropertyDetails obj=(PropertyDetails) listprice.get(0);
		actual=obj.getPrice();
		System.out.println("Enter Expected price");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
}
