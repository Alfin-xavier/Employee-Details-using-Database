package com.atmecs.employee_details.tests;

import java.sql.SQLException;

import org.testng.annotations.Test;

import com.atmecs.employee_details.pagehelper.Helper;

public class Employee_Datails 
{
	@Test
	public void getData() throws SQLException, ClassNotFoundException
	{
		 Helper helper = new Helper();
		 
		 helper.getFromDb();
	}
}
