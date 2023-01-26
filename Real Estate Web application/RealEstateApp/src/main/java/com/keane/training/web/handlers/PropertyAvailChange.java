package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.SellerDAO;

public class PropertyAvailChange implements HttpRequestHandler //class to change availability of property
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int propertyid = Integer.parseInt(request.getParameter("propertyid"));
		String available=request.getParameter("available");
		int result=0;
		 try {
			result=SellerDAO.updateAvailability(propertyid,available);
			if(result>0)
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\successchangeavail.jsp");
				request.setAttribute("success",
						"Your Site Availability Change Successfully");
				request.setAttribute("propertyid", propertyid);
				request.setAttribute("available", available);
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("changeAvail.jsp");
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
