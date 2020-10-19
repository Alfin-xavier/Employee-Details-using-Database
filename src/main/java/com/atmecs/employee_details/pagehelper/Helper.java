package com.atmecs.employee_details.pagehelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.atmecs.employee_details.constants.Constants;
import com.atmecs.employee_details.utilities.PropertyReader;

public class Helper 
{
	public void getFromDb() throws SQLException, ClassNotFoundException
	{
		WebDriver driver;
		Properties properties;
		String baseUrl;
		String browserUrl;

		String dbUrl = "jdbc:mysql://127.0.0.1:3306/employee";
		String username = "Alfin Anthonyraj";
		String password = "AlfinXavier@118";
		String query = "select *  from emp_details;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		 while (rs.next())
		 {
			 properties = PropertyReader.readProperties(Constants.CONFIG);
				baseUrl = properties.getProperty("url");
				browserUrl = properties.getProperty("browser");
				
					System.setProperty(Constants.CHROME_DIR, Constants.CHROME_PATH);
					driver = new ChromeDriver();
					driver.get(baseUrl);
			 
			 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(rs.getString("e_mail"));
			 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(rs.getString("emp_name"));
			 driver.findElement(By.xpath("//button[@name='login']")).click();
		 }
        con.close();
        

	}
	
}