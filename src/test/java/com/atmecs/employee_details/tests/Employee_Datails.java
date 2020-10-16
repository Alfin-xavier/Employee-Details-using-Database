package com.atmecs.employee_details.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class Employee_Datails 
{
	@Test
	public void getData() throws SQLException, ClassNotFoundException
	{
		 String dbUrl = "jdbc:mysql://127.0.0.1:3306/employee";
		 String username = "Alfin Anthonyraj";
		 String password = "AlfinXavier@118";
		 String query = "select *  from emp_details;";
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection(dbUrl,username,password);
		 Statement stmt = con.createStatement();
		 ResultSet rs= stmt.executeQuery(query);
		 while (rs.next())
		 {
			int id = rs.getInt(1);
     		String name = rs.getString(2);								        
     		String email = rs.getString(3); 
     		String phone = rs.getString(4);
     		
     		System.out.println("Employee Details\n");
             System. out.println("Employee Id:"+" "+id);
             System.out.println("Employee Name:"+" "+name);
             System.out.println("Employee Mail:"+" "+email);
             System.out.println("Mobile:"+" "+phone);
		 }
         con.close();
		 
	}
}
