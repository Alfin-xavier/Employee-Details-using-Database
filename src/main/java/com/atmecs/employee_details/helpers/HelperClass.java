package com.atmecs.employee_details.helpers;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass 
{
	WebDriver driver;
	Properties properties;
	JavascriptExecutor js;
	
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void textDatas(String xpath, String values)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(values);
	}
	
	public void selectValueFromDropDown(String xpath, String values)
	{
		Select selectValue = new Select(driver.findElement(By.xpath(xpath)));
		selectValue.selectByValue(values);
	}
	
	public void clickOperation(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void switchToFrame(String xpath) 
	{
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);

		WebElement frame = driver.findElement(By.xpath(xpath));

		wait.until(ExpectedConditions.elementToBeClickable(frame));

		driver.switchTo().frame(frame);
	}
	
	public void clickable(String xpath)
	{
		WebElement button = driver.findElement(By.xpath(xpath));

		js.executeScript("arguments[0].click();", button);
	}
	
	public void jsMethods(String xpath)
	{
		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement chaticon = driver.findElement(By.xpath(xpath));
		
		js.executeScript("arguments[0].click();", chaticon);
	}
}