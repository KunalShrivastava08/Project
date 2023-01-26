package com.ntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.BookPropertyDetail;
import com.ntt.domain.PropertyDetails;

public class BuyerDAO 
{
	public static void selectAndViweSite()//method to get available properties in site
	{
		Scanner sc=new Scanner(System.in);
		List availableproperty=null;
		System.out.println("ENTER YOUR LOCATION WHERE YOU WANT HOME");
		String location=sc.next();
		System.out.println("ENTER PROPERTY TYPE :-1BHK,2BHK,3BHK or others");
		String type=sc.next();
		System.out.println("ENTER YOUR BUDGET");
		long budget=sc.nextLong();
		PropertyDetails pd=new PropertyDetails(location, type, budget);
		availableproperty=getAvailableProperty(pd);//calling method to get list of the properties in given criteria
		if(!(availableproperty.isEmpty()))//checking here my list is not empty
		{
			System.out.println("\n**** PROPERTES AVAILABLE *** \n");
			System.out.println("------------------------------------");
			for(Iterator it=availableproperty.iterator();it.hasNext();)//Printing all the details present inside the list
			{
				System.out.println(it.next());
			}
			System.out.println();
		}

		else
		{
			System.out.println("\n<----------SORRY NO PROPERTES AVAILABLE PLEASE CHANGE LOCATION,TYPE AND BUDGET------------>\n");
		}

	}



	public static void bookSite(String userid)//method for booking date to site visit
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER PROPERTY ID");
		int propertyid=sc.nextInt();
		System.out.println("ENTER DATE TO SITE VISIT IN 'YYYYMMDD' FORMATE");
		String date=sc.next();
		BookPropertyDetail bookpropertydetail=new BookPropertyDetail(propertyid, userid, date);//creating object of bookpropertydetatil class and store data in variables 
		int check=0;
		check=setBookingDate(bookpropertydetail);//calling method to insert object data into data base
		if(check!=0)//checking data inserted or not
		{
			System.out.println("\nYOUR BOOKING DONE\n");
		}
		else
			System.out.println("\nYOUR BOOKING NOT DONE PLEASE INSERT VALID DATA\n");
	}

	public static void makePayment(String email) //method for payment
	{
		Scanner sc=new Scanner(System.in);
		List listprice=null;
		long price=0;
		BookPropertyDetail bpd=new BookPropertyDetail(email);
		System.out.println("PRESS 1 :- TO CONFIRM THE PAYMENT");
		System.out.println("PRESS ANY NO. TO CANCEL THE TRANSACTION ");
		int ch=sc.nextInt();
		switch (ch) {
		case 1:
			listprice=getPrice(bpd);

			if((listprice.size()!=0))
			{
				PropertyDetails obj=(PropertyDetails) listprice.get(0);//Down casting to convert object class object to PropertyDetails class object
				price=obj.getPrice();//getting price		
			}
			else 
				System.out.println("FIRST BOOK SITE");

			break;

		default:
			System.out.println("YOUR TRANSACTION HAS BEEN CANCELED");
			break;
		}

		if(price!=0)//check and print price of that property
			System.out.println("YOUR PAYMENT OF Rs."+price+" IS SUCCESSFUL");
		else
			System.out.println("PLEASE ENTER VALID DETAILS");
	}



	////////////////////////////////////////////////////////////////////////////////////////





	public static List getAvailableProperty(final PropertyDetails pd)// get available properties from DataBase
	{
		List listofproperty=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper AVAILABLEPROPERTYMAPPER=new ParamMapper()
			{
				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,pd.getLocation());
					preStmt.setString(2,pd.getType());
					preStmt.setLong(3,pd.getPrice());
				}

			};//ananymous class

			listofproperty=DBHelper.executeSelect
					(con,SQLMapper.FETCHAVAILABLEPROPERTY,SQLMapper.ALLPROPERTYMAPPER, AVAILABLEPROPERTYMAPPER );		

		} catch (DBConnectionException e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		return listofproperty;
	}





	public static int setBookingDate(final BookPropertyDetail bp)//Book date
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper INSERTBOOKINGDETAILSMAPPER=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, bp.getPropertyid());
					preStmt.setString(2, bp.getEmail());
					preStmt.setString(3,bp.getDate());

				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.INSERTBOOKPROPERTYDETAIL,INSERTBOOKINGDETAILSMAPPER);

		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return result;
	}





	public static List getPrice(final BookPropertyDetail bpd) 
	{

		List listprice=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper GETEMAILMAPPER=new ParamMapper()
			{
				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException
				{
					preStmt.setString(1,bpd.getEmail());

				}

			};//ananymous class

			listprice=DBHelper.executeSelect
					(con,SQLMapper.FETCHPRICE,SQLMapper.GETPRICEMAPPER, GETEMAILMAPPER );		

		} catch (DBConnectionException e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return listprice;

	}


}


