package com.ntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.PropertyDetails;

public class SellerDAO 
{
	public static void insertOperation(String userid)// method to insert data in DataBase property Table
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER LOCATION");
		String location=sc.next();
		System.out.println("ENTER TYPE OF THE PROPERTY :- 1BHK,2BHK,3BHK or others");
		String type=sc.next();
		System.out.println("ENTER PRICE FOR YOUR SITE");
		long price=sc.nextLong();
		System.out.println("PRESS 1 TO POST THE SITE");
		System.out.println("Enter 2 TO RE-ENTER THE DETEILS");
		System.out.println("ENTER ANY NUMBER TO EXIT");
		int num=sc.nextInt();
		do {
			num=1;
			if(num==1) 
			{
				String available="YES";
				PropertyDetails pd= new PropertyDetails(location, type,price,available,userid);
				int result=insertPropertyDetails(pd);
				if(result!=0)
				{
					System.out.println("PROPETY POST SUCCESSFULLY");
					break;
				}
				else 
					System.out.println("PLEASE RE-ENTER ALL THE VALUES IN PROPER FORMATE");

				num=2;
			}
		}while(num==2);

	}

	public static void availability(String userid)// method to insert data in DataBase property Table
	{
		Scanner sc=new Scanner(System.in);
		int result=0; 
		String avail=null;
		List list= getUserProperty(userid);
		System.out.println("ALL YOUR PROPERTIES ");
		for(Iterator it=list.iterator();it.hasNext();)//Printing all the details present inside the list
		{
			System.out.println(it.next());
		}
		System.out.println("ENTER PROPERTY ID WHICH YOU WHAT TO CHANGE THE AVAILABILITY");
		int pid=sc.nextInt();
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

		result=updateAvailability(pid,avail);

		if(result!=0)
			System.out.println("YOUR AVAILABILITY UPDATED SUCCESSFULLY");
		else 
			System.out.println("PLEASE RE-ENTER ALL THE VALUES IN PROPER FORMATE");
	}


	////////////////////////////////////////////////////////////////////////////////////////




	public static int insertPropertyDetails(final PropertyDetails pd) //seller insert data in property table
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper INSERTPROPERTYDETAILS=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setString(1, pd.getLocation());
					preStmt.setString(2, pd.getType());
					preStmt.setLong(3, pd.getPrice());
					preStmt.setString(4, pd.getAvailable());
					preStmt.setString(5, pd.getEmail());
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.INSERTPROPERTYDETAILS,INSERTPROPERTYDETAILS);


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



	public static int updateAvailability(final int pid,String ava) //method to Update availability
	{
		int result=0;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATEAVAILABILITYMAPPER=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setString(1, ava);
					preStmt.setInt(2, pid);
				}
			};

			result=DBHelper.executeUpdate(con,SQLMapper.UPDATEAVAILABILITY,UPDATEAVAILABILITYMAPPER);

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



	public static List getUserProperty(final String id)// get User property details
	{
		List listofproperty=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper USERPROPERTYMAPPER=new ParamMapper()
			{
				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,id);
				}

			};//ananymous class

			listofproperty=DBHelper.executeSelect
					(con,SQLMapper.FETCHUSERPROPERTY,SQLMapper.ALLPROPERTYMAPPER, USERPROPERTYMAPPER );		

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
}

