package com.vmb.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/*
Author : Raja
Date : 03-07-2018
Description : TC001 - Login Successful
*/

import org.testng.annotations.Test;
import com.vmb.pageobjects.SalesForceLogin;
import com.vmb.pageobjects.Salesforce_UnlimitedEdition;
import com.vmb.utility.BasicFunctions;

public class TC001_LoginSalesForce {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String title_actual;
	public static String title_expected1 = "Salesforce - Unlimited Edition - Console";
	public static String title_expected2 = "Salesforce - Unlimited Edition";
	
	@BeforeTest
	
	public static void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		
	}
	
	@Test
	public static void loginSuccessful () {		
		
		//opening URL
		BasicFunctions.openURL(driver, "https://test.salesforce.com/"); 
		BasicFunctions.getScreenShots(driver, "OpenedURL");
		
		//Entering Details
		BasicFunctions.enterText(driver, SalesForceLogin.username, "rajasingh.nadar@infosys.com.vmstdemo");
		BasicFunctions.enterText(driver, SalesForceLogin.password, "Raja@1506$$$$$$");
		BasicFunctions.getScreenShots(driver, "Enter Details");
		
		//Clicking Button
		BasicFunctions.clickElement(driver, SalesForceLogin.loginbutton);
		
		//Validation 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Salesforce_UnlimitedEdition.headerImage)));
		title_actual = BasicFunctions.getPageTitle(driver);
		System.out.println("Title is " +title_actual);
		
		if(title_actual.equalsIgnoreCase(title_expected1) || (title_actual.equalsIgnoreCase(title_expected2))) {
			
			Assert.assertTrue(true);
			
		}
		else {
			
			Assert.assertTrue(false);
			
		}
		
		BasicFunctions.getScreenShots(driver, "LoggedInPage");
		
	}
	
	@AfterTest
	
	public static void afterTest() {
		
		try {
			Thread.sleep(5000);
			driver.close();
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
