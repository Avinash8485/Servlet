package com.practice.servlet.signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteCarServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int carId =Integer.parseInt(req.getParameter("carId"));
		
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_cardb","root","book");
			
			String insterQuery ="DELETE FROM cars WHERE carId=?";
			
			PreparedStatement pst = con.prepareStatement(insterQuery);
			
			pst.setInt(1, carId);
			
			
			int rowsDeleted = pst.executeUpdate();
			
			PrintWriter out = res.getWriter();
			if(rowsDeleted>0) {
				out.print("<h1> "+rowsDeleted +" Data Deleted Sucessfullu!!</h1>");
			}
			else {
				out.print("<h1> Data Not found!!</h1>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
