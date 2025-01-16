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

public class UpdateCarServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId =Integer.parseInt(req.getParameter("carId"));
		String carModel =req.getParameter("carModel");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_cardb","root","book");
			
			String updateQuery ="UPDATE cars set carPrice =? , carModel =? where carId=?";
			
			PreparedStatement pst = con.prepareStatement(updateQuery);
			
			pst.setInt(1, carPrice);
			pst.setString(2, carModel);
			pst.setInt(3, carId);
			
			
			int rowUpdate = pst.executeUpdate();
			
			PrintWriter out = res.getWriter();
			if(rowUpdate>0) {
				out.print("<h1> "+rowUpdate +" Data Updated Sucessfullu!!</h1>");
			}
			else {
				out.print("<h1> Data Not Updated!!</h1>");
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
