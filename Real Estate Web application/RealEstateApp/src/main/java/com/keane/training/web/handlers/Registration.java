package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.RegisterDAO;
import com.keane.training.domain.UserDetails;

public class Registration implements HttpRequestHandler//Class for registration
{
	static Logger log = Logger.getLogger(Registration.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RegisterDAO dao = new RegisterDAO();
		int roleid=(Integer.parseInt(request.getParameter("roleid")));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		long contactnum=(Long.parseLong(request.getParameter("contactnum")));
		UserDetails ud = new UserDetails(roleid, name, email, password, contactnum);
		boolean isExists;
		try {
			isExists = dao.validateUser(ud.getEmail());

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\Register.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} else {
				int finalRes = dao.registerUser(ud);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\success.jsp");
					request.setAttribute("success",
							"User succesfully registered in the system");
					request.setAttribute("details", ud);
					dispatcher.forward(request, response);
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		
	}

}
