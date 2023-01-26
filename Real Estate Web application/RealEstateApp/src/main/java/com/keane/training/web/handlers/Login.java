package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.LoginDao;
import com.keane.training.domain.UserDetails;
import com.keane.mvc.HttpRequestHandler;

public class Login implements HttpRequestHandler // Class for Login 
{
	static Logger log= Logger.getLogger(Login.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password=request.getParameter("password");
		
		int roleid = 0;
		List users = null;
		LoginDao dao=new LoginDao();
		try {
			users = dao.validateUser(email);
			log.info(users);
			for (Object object : users) {

				UserDetails user = (UserDetails) object;
				if (user.getPassword().equals(password)) {
					roleid = user.getRoleid();
					break;
				}
			}
			log.info("Role Id in login " + roleid);
			if (roleid == 101) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("buyer.jsp");
				request.setAttribute("email", email);
				dispatcher.forward(request, response);

			} 
			else if (roleid == 102) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("seller.jsp");
				request.setAttribute("email", email);
				dispatcher.forward(request, response);

			}
			else if (roleid == 103) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("admin.jsp");
				request.setAttribute("email", email);
				dispatcher.forward(request, response);

			}
			else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Login.jsp");
				request.setAttribute("Err",
						"User Id are password is incorrect");
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
