package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  com.keane.training.dao.BuyerDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.domain.BookPropertyDetail;

public class BookProperty implements HttpRequestHandler//class to book my property
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int propertyid = Integer.parseInt(request.getParameter("propertyid"));
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		BookPropertyDetail pd=new BookPropertyDetail(propertyid, email, date);//creating object of bookpropertydetatil class and store data in variables 
		
		try {
			int check=0;
			check=BuyerDAO.setBookingDate(pd);
			if (check > 0) {

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\successbookproperty.jsp");
				request.setAttribute("success",
						"Successfully Book Date");
				request.setAttribute("propertydetails", pd);
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Login.jsp");
				request.setAttribute("Err",
						"Please re-login");
				dispatcher.forward(request, response);
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}//calling method to insert object data into data base

	}
}


