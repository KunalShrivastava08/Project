package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.keane.training.dao.AdminDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.domain.PropertyDetails;

public class DeleteProperty  implements HttpRequestHandler // Class to Delete property from Data Base
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propertyid = Integer.parseInt(request.getParameter("propertyid"));
		String tablename=request.getParameter("tablename");
		int result=0;
		try {
			if(tablename.equalsIgnoreCase("BPD"))
			{
				PropertyDetails pd=new PropertyDetails(propertyid);
				result=AdminDAO.deleteBookProperty(pd);
				if(result>0)
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\successdelete.jsp");
					request.setAttribute("success",
							"Your Site Delete Successfully From Book Property Table");
					request.setAttribute("propertyid", propertyid);
					dispatcher.forward(request, response);
				}
				else
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("delete.jsp");
					request.setAttribute("Err",
							"Invalid input re-enter");
					dispatcher.forward(request, response);

				}
			}
			else
			{
				PropertyDetails pd=new PropertyDetails(propertyid);
				result=AdminDAO.deleteProperty(pd);
				if(result>0)
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\successdelete.jsp");
					request.setAttribute("success",
							"Your Site Delete Successfully From Property Table");
					request.setAttribute("propertyid", propertyid);
					dispatcher.forward(request, response);
				}
				else
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("delete.jsp");
					request.setAttribute("Err",
							"Invalid input re-enter or First delete from Book Property Table ");
					dispatcher.forward(request, response);

				}
				
			}
			
		}catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		
		
	}

}
