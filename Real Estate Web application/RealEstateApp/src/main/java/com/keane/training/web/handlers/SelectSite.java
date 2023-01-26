package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.BuyerDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.training.domain.PropertyDetails;

public class SelectSite implements HttpRequestHandler // Class to Select and view available sites
{
	static Logger log= Logger.getLogger(Login.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String location = request.getParameter("location");
		String type=request.getParameter("type");
		long price= Long.parseLong(request.getParameter("price"));
		PropertyDetails pd=new PropertyDetails(location, type, price);
		
		try {
			List availableproperty=null;
			availableproperty=BuyerDAO.getAvailableProperty(pd);
			log.info(pd);
			if(availableproperty!=null && availableproperty.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("DisplayProperty.jsp");
				request.setAttribute("property", availableproperty);
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("SelectAndViweSite.jsp");
				request.setAttribute("Err",
						"Property not avaiable please change your details");
				dispatcher.forward(request, response);
			}
			
			
			
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}//calling method to get list of the properties in given criteria
		
		
		

	
		
	}

}
