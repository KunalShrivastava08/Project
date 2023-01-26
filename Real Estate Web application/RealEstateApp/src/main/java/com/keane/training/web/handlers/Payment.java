package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.BuyerDAO;
import com.keane.training.domain.PropertyDetails;

public class Payment implements HttpRequestHandler // Class to make payment
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propertyid = Integer.parseInt(request.getParameter("propertyid"));
	
		try {
			List listprice =null;
			listprice = BuyerDAO.getPrice(propertyid);
			if (listprice.size()> 0 && listprice!=null)
			{
				PropertyDetails pd=(PropertyDetails) listprice.get(0);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\successpayment.jsp");
				request.setAttribute("success",
						"Your Payment Successfully Done");
				request.setAttribute("propertydetails", pd);
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("payment.jsp");
				request.setAttribute("Err",
						"Please Book Property First");
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
