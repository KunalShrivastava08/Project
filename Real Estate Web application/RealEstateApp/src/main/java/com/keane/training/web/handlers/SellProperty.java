package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.SellerDAO;
import com.keane.training.domain.PropertyDetails;

public class SellProperty implements HttpRequestHandler // Class to post user site 
{
	static Logger log = Logger.getLogger(Registration.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String email=request.getParameter("email");
		String location=request.getParameter("location");
		String type=request.getParameter("type");
		long price=Long.parseLong(request.getParameter("price"));
		String available="YES";
		
		PropertyDetails pd=new PropertyDetails(location, type,price,available,email);
		
		int result=0;
		try {
			result = SellerDAO.insertPropertyDetails(pd);
			if (result > 0) {

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\successpost.jsp");
				request.setAttribute("success",
						"Your Site Successfully Posted");
				request.setAttribute("propertydetails", pd);
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("sellProperty.jsp");
				request.setAttribute("Err",
						"Invalid input re-enter");
				dispatcher.forward(request, response);
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		
		
	}

}
