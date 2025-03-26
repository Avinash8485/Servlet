package org.subfolder.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MemberAreaController")
public class MemberAreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public MemberAreaController() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "destroy":
			request.getSession().invalidate();		
			response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
			break;
		case "memberArea":
			request.getRequestDispatcher("memberArea.jsp").forward(request, response);
			break;
		case "memberOnly":
			request.getRequestDispatcher("membersOnly.jsp").forward(request, response);
			break;
		default:
			 
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
