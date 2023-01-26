package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.AdminDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.training.domain.PropertyDetails;

public class Validity implements HttpRequestHandler// Class to validate the property
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propertyid = Integer.parseInt(request.getParameter("propertyid"));
		String valid=request.getParameter("valid");
		int result=0;
		PropertyDetails pd=new PropertyDetails(propertyid, valid);
		try {
			result=AdminDAO.validity(pd);
			if(result>0)
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\successvalid.jsp");
				request.setAttribute("success",
						"Your Site Validation Updated Successfully");
				request.setAttribute("propertyid", propertyid);
				request.setAttribute("valid", valid);
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("validate.jsp");
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
