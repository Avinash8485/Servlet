package org.subfolder.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SiteController() {
		super();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		
		case "login":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "loginSubmit":
			authenticate(request, response);
			break;

		default:
			break;
		}

	}
	public void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("Username") && password.equals("pass")) {
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
		    newSession.setMaxInactiveInterval(300);
		    newSession.setAttribute("username", username);
		    String encode = response.encodeURL(request.getContextPath());
		    response.sendRedirect(encode+"/MemberAreaController?action=memberArea");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
		}
	}

}




