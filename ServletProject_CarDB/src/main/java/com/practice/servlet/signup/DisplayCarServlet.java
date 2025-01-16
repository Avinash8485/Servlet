package com.practice.servlet.signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayCarServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int carId =Integer.parseInt(req.getParameter("carId"));
		
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_cardb","root","book");
			
			String insterQuery ="SELECT * From cars where carId =?";
			
			PreparedStatement pst = con.prepareStatement(insterQuery);
			
			pst.setInt(1, carId);
			
			
			ResultSet rs = pst.executeQuery();
		
			PrintWriter out = res.getWriter();
			
			while(rs.next()) {
				out.print("<h1>THE DETAILS OF THE CAR IS <h1>");
				out.print("<h3> CAR ID = "+rs.getInt("carId")+"<h3>");
				out.print("<h3> CAR BRAND = "+rs.getString("carBrand")+"<h3>");
				out.print("<h3> CAR MODEL = "+rs.getString("carModel")+"<h3>");
				out.print("<h3> CAR PRICE = "+rs.getInt("carPrice")+"<h3>");
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
