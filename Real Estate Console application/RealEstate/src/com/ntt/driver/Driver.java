package com.ntt.driver;
import java.util.Scanner;
import com.ntt.dao.FormDAO;
import com.ntt.dbcon.DBConnectionException;

public class Driver 
{
	public static void main(String arg[])throws DBConnectionException
	{
		int status=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO REALESTATE PROJECT");
		do{
			int ch=0;
			System.out.println("\n\n<-------MAIN PAGE---------->\n\n");
			System.out.println("PRESS 1 FOR REGISTRATION");
			System.out.println("PRESS 2 FOR LOGIN");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				FormDAO.registrationForm();//calling method for Registration 
				break;
			case 2:
				FormDAO.loginPart();//calling method for Login 
				break;
			default:
				System.out.println("INVALID INPUT");
			}
			System.out.println("\n\nPress 0 to exit or press any number to go to the Main Page\n\n");
			status=sc.nextInt();
		}
		while(!(status==0));
		System.out.println("\n\n Thank You \n\n");
	}

}
