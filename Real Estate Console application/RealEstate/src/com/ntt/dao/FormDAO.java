package com.ntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.UserDetails;

public class FormDAO
{

	public static void registrationForm()//Registraion form 
	{
		System.out.println("\n<----------REGISTRATION FORM ----------->\n");
		Scanner sc=new Scanner(System.in);
		int result=0;
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
		String email=sc.next();
		System.out.println("ENTER YOUR PASSWORD :-");
		String password=sc.next();
		System.out.println("ENTER YOUR CONTACT NUMBER :-");
		long contactnum=sc.nextLong();
		UserDetails userdetails=new UserDetails(roleid, name, email, password, contactnum);//creating object of user details and store all the values
		result=insertUserDetails(userdetails);//call method to insert all the values in data base- user details table
		if(result!=0)//checking my data is properly insert or not
		{
			System.out.println("\n<------------YOUR ACCOUNT HAS BEEN CREATED SUCCESSFULLY------------>\n");
		}
		else
		{
			System.out.println("\n<------------FAILED TO CREATE YOUR ACCOUNT PLAESE TRY AGAIN------------>\n");
		}
	}


	public static void loginPart()//Login form
	{
		System.out.println("\n<----------LOGIN PAGE ----------->\n");
		Scanner sc=new Scanner(System.in);
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
		String userpassword=sc.next();
		UserDetails ud=new UserDetails(userid,userpassword,cnum);
		List clist=getUserDetails(ud);//calling method to check role Id
		if(clist!=null)//which type of person try to login
		{
			UserDetails obj=(UserDetails) clist.get(0);//Down casting to convert object class object to userdetails class object
			int i=obj.getRoleid();//getting role id by getter method from usesdetails class
			if(i==101)//if he or she is buyer then this part will execute
			{
				int status =0;
				do {
					System.out.println("PRESS 1 :- SELECT THE SITE BASED ON THE LOCATION, PROPERTY TYPR AND BUDGET AND AVAIABILITY OF HOME");
					System.out.println("PRESS 2 :- BOOK THE DATE FOR SITE VISIT");
					System.out.println("PRESS 3 :- FOR THE PAYMENT");
					int ch=sc.nextInt();
					switch(ch)
					{
					case 1:
						BuyerDAO.selectAndViweSite();//calling method for select and view all the sites  
						break;
					case 2:
						BuyerDAO.bookSite(userid);//calling method for booking date to site visit
						break;
					case 3:
						BuyerDAO.makePayment(userid);//calling method for payment
						break;
					default:
						System.out.println("INVALID INPUT");
					}
					System.out.println("\nPress 0 to exit or press any number to select the details again\n");
					status=sc.nextInt();

				}while(!(status==0));
			}
			else if(i==102)//if he or she is seller then this part will execute
			{
				int status =0;
				do {
					System.out.println("PRESS 1 :- POST SITE");
					System.out.println("PRESS 2 :- CHANGE THE AVAILABILITY FOR YOUR POST");
					int ch=sc.nextInt();
					switch(ch)
					{
					case 1:
						SellerDAO.insertOperation(userid);//calling method insert values in DataBase property details table
						break;
					case 2:
						SellerDAO.availability(userid);//calling method to change the availability
						break;
					default:
						System.out.println("INVALID INPUT");
					}
					System.out.println("\nPress 0 to exit or press any number to select the details again\n");
					status=sc.nextInt();

				}while(!(status==0));
			}
			else if(i==103)
			{
				int status =0;
				do {
					
					System.out.println("PRESS 1 :- VALIDATE THE PROPERTY DETAILS");
					System.out.println("PRESS 2 :- VIEW ALL THE PROPERTY");
					System.out.println("PRESS 3 :- TO CLOSE THE DEAL AND REMOVE DATA FROM THE TABLE");
					int ch=sc.nextInt();
					switch(ch)
					{
					case 1:
						AdminDAO.validateData();//calling method to insert data in validate column
						break;
					case 2:
						AdminDAO.viewAllPropertry();//calling method to display all the details in property table
						break;
					case 3:
						AdminDAO.delete();//calling method to delete property from database
						break;
					default:
						System.out.println("INVALID INPUT");
					}
					System.out.println("\nPress 0 to exit or press any number to select the details again\n");
					status=sc.nextInt();

				}while(!(status==0));
			}
			else
				System.out.println("INVALID INPUT");
		}
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////
	
	
	public static int insertUserDetails(final UserDetails ud) //insert data in user details table
	{
		
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper INSERTUSERDETAILS=new ParamMapper()
			{	
				@Override
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, ud.getRoleid());
					preStmt.setString(2, ud.getName());
					preStmt.setString(3, ud.getEmail());
					preStmt.setString(4, ud.getPassword());
					preStmt.setLong(5, ud.getContactnum());
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.INSERTUSERDETAILS,INSERTUSERDETAILS);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return result;


	}
	
	public static List getUserDetails(final UserDetails ud)//get roleid
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List userdetails=null;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper USERDETAILSMAPPER=new ParamMapper()
			{
				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,ud.getEmail());
					preStmt.setString(2,ud.getPassword());
					preStmt.setLong(3,ud.getContactnum());
					preStmt.setString(4,ud.getPassword());
					
				}

			};//ananymous class

			userdetails=DBHelper.executeSelect
					(con,SQLMapper.FETCHUSERIDPASS,SQLMapper.USERDETAILSMAPPER, USERDETAILSMAPPER );		

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
		return userdetails;

	}
	
}
