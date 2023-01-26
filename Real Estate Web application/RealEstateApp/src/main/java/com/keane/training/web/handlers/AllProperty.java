package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.keane.training.dao.AdminDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.mvc.HttpRequestHandler;

public class AllProperty implements HttpRequestHandler//class to get all properties
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List all=null;
		try {
			all=AdminDAO.getAllPropertry();
			if(all!=null && all.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("viweAllProperty.jsp");
				request.setAttribute("property", all);
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
