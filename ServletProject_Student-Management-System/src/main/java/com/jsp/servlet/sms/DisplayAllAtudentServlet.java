package com.jsp.servlet.sms;

import java.io.IOException;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display-all-student")
public class DisplayAllAtudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system","root","book");
			PreparedStatement pst = con.prepareStatement("select * from student");
			
			ResultSet rs = pst.executeQuery();
			
		req.setAttribute("resultset", rs);
		RequestDispatcher rd = req.getRequestDispatcher("DisplayAllStudent.jsp");
		rd.forward(req, resp);
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
