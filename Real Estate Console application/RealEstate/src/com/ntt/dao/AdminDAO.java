package com.ntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.PropertyDetails;

public class AdminDAO 
{
	public static void validateData()
	{
		Scanner sc=new Scanner(System.in);
		int result=0;
		System.out.println("ENTER PROPERTY ID WHICH YOU WANT TO VALIDATE");
		int propertyid=sc.nextInt();
		String valid="null";
		do 
		{
			System.out.println("PRESS 1 :- IF PROPERTY IS VALID");
			System.out.println("PRESS 2 :- IF PROPERTY IS NOT VALID");
			int check=sc.nextInt();
			if(check==1)
			{
				valid="VALID PROPERTY";
				break;
			}
			else if(check==2)
			{
				valid="NOT VALID PROPERTY";
				break;
			}
			else 
				System.out.println("PLEASE ENTER VALID INPUT");
		}while(result==0);

		PropertyDetails pd=new PropertyDetails(propertyid, valid);
		result=updateValidity(pd);
		if(result!=0)
			System.out.println("VALIDATED SUCCESSFULLY");
		else 
			System.out.println("VALIDATION NOT DONE PLEASE RE-ENTER THE DATA");
	}


	public static void viewAllPropertry()
	{
		Scanner sc=new Scanner(System.in);
		try {
			List all=null;
			all=getAllPropertry();
			if(!(all.isEmpty()))
			{
				System.out.println("\n\n**** ALL PROPERTY DETAILS *** \n\n");
				System.out.println("------------------------------------");
				for(Iterator it=all.iterator();it.hasNext();)
				{
					System.out.println(it.next());
				}
			}

			else
			{
				System.out.println("NO PROPERTES AVAILABLE");
			}
		} catch (DBFWException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (RealEstateDAOException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (DBConnectionException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void delete()
	{
		Scanner sc=new Scanner(System.in);
		int result1=0;
		int result2=0;
			System.out.println("PRESS 1 :- IF YOU WANT TO DELETE PROPERTY FROM BOOKING TABLE");
			System.out.println("PRESS 2 :- IF YOU WANT TO DELETE PROPERTY FROM PROPERTY TABLE");
			int check=sc.nextInt();
			if(check==1)
			{
				System.out.println("ENTER PROPERTY ID WHICH YOU WANT TO DELETE");
				int propertyid=sc.nextInt();
				PropertyDetails pd=new PropertyDetails(propertyid);
				result1=deleteBookProperty(pd);
				if(result1!=0)
					System.out.println("PROPERTY DELETED SUCCESSFULLY FROM BOOK PROPERTY TABLE");
				else 
					System.out.println("PROPERTY DELETION FROM BOOK PROPERTY TABLE IS NOT DONE PLEASE ENTER VALID DATA");
			}
			else if(check==2)
			{
				System.out.println("ENTER PROPERTY ID WHICH YOU WANT TO DELETE");
				int propertyid=sc.nextInt();
				PropertyDetails pd=new PropertyDetails(propertyid);
				result2=deleteProperty(pd);
				if(result2!=0)
					System.out.println("PROPERTY DELETED SUCCESSFULLY FROM PROPERTY TABLE");
				else 
					System.out.println("PROPERTY DELETION FROM PROPERTY TABLE IS NOT DONE PLEASE ENTER VALID DATA");
			}
			else 
				System.out.println("PLEASE ENTER VALID INPUT");

	}

	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public static List getAllPropertry() throws DBFWException, RealEstateDAOException, DBConnectionException
	{
		List allproperty=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			allproperty=DBHelper.executeSelect(con,SQLMapper.FETCHALLPROPERTYDETAILS,SQLMapper.ALLPROPERTYMAPPER);
					
		} catch (DBConnectionException e) {
			System.out.println(e);
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
				
				System.out.println(e);
			}
		}
		
		
		return allproperty;
	}


	

	public static int deleteBookProperty(final PropertyDetails pd)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result= 0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper DELETEPROPERTYMAPPER=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1,pd.getPropertyid());
				}
			};

			result=DBHelper.executeUpdate(con,SQLMapper.DELETEBOOKPROPERTYDETAIL,DELETEPROPERTYMAPPER);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return result;
	}
	
	
	public static int deleteProperty(final PropertyDetails pd)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result= 0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper DELETEPROPERTYMAPPER=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1,pd.getPropertyid());
				}
			};

			result=DBHelper.executeUpdate(con,SQLMapper.DELETEPROPERTYDETAIL,DELETEPROPERTYMAPPER);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return result;
	}
	
	
	public static int updateValidity(final PropertyDetails pd)//method to update validity
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper UPDATEVALIDITYMAPPER=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setString(1, pd.getValidity());
					preStmt.setInt(2, pd.getPropertyid());
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.UPDATEVALIDITY,UPDATEVALIDITYMAPPER);
		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return result;
	}

}
