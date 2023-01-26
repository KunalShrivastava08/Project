package com.ntt.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import com.ntt.dao.AdminDAO;
import com.ntt.dao.RealEstateDAOException;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.PropertyDetails;

public class AdminTest 
{
	Scanner sc=new Scanner(System.in);

	@Test
	public void testValidateData()//test method to validate data in property table 
	{
		int actual=0;
		System.out.println("ENTER PROPERTY ID WHICH YOU WANT TO VALIDATE");
		int propertyid=sc.nextInt();
		String valid="null";
		System.out.println("PRESS 1 :- IF THIS PROPERTY IS VALID");
		System.out.println("PRESS 2 :- IF THIS PROPERTY IS NOT VALID");
		int check=sc.nextInt();
		if(check==1)
		{
			valid="VAILID PROPERTY";
		}
		else if(check==2)
		{
			valid="NOT VAILID PROPERTY";
		}
		else 
			System.out.println("PLEASE ENTER VALID INPUT");		
		PropertyDetails pd=new PropertyDetails(propertyid, valid);
		actual=AdminDAO.updateValidity(pd);
		System.out.println("Enter Expected update rows in table");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
	
	
	@Test
	public void testViewAllPropertry()////test method to select all property from table 
	{
		int actual=0;
		List all=null;
		try
		{
			all=AdminDAO.getAllPropertry();
		} catch (DBFWException e) {
			e.printStackTrace();
		} catch (RealEstateDAOException e) {
			e.printStackTrace();
		} catch (DBConnectionException e) {
			e.printStackTrace();
		}
		actual=all.size();
		System.out.println("Enter Expected row you want to see");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
	

	@Test
	public void testDeleteProperty()//test method to delete property from property and booking table. 
	{
		
		int result1=0;
		int result2=0;
		do {
			System.out.println("PRESS 1 :- IF YOU WANT TO DELETE PROPERTY FROM BOOKING TABLE");
			System.out.println("PRESS 2 :- IF YOU WANT TO DELETE PROPERTY FROM PROPERTY TABLE");
			int check=sc.nextInt();
			if(check==1)
			{
				System.out.println("ENTER PROPERTY ID WHICH YOU WANT TO DELETE");
				int propertyid=sc.nextInt();
				PropertyDetails pd=new PropertyDetails(propertyid);
				result1=AdminDAO.deleteBookProperty(pd);
				
			}
			else if(check==2)
			{
				System.out.println("ENTER PROPERTY ID WHICH YOU WANT TO DELETE");
				int propertyid=sc.nextInt();
				PropertyDetails pd=new PropertyDetails(propertyid);
				result2=AdminDAO.deleteProperty(pd);
			}
			else 
				System.out.println("PLEASE ENTER VALID INPUT");
		}while((result1+result2)<2);
			
		int actual=result1+result2;
		System.out.println("Enter Expected total no. of rows you deleted from both table");
		int expected=sc.nextInt();
		assertEquals(expected,actual);
	}
	
}
