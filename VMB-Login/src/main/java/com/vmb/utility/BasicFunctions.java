package com.vmb.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/*
Author : Raja
Date : 03-07-2018
Description : Common functions which are used 
*/

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class BasicFunctions {
	
	private static WebElement text;
	private static WebElement click_webelement;
	
	//****************************************Opening Browser with the URL********************************
	
	public static void openURL (WebDriver ldriver, String URL) {
				
		ldriver.manage().window().maximize();		
		ldriver.get(URL);		
		
	}
	
	//****************************************Enter Text Function*****************************************
	
	public static void enterText (WebDriver ldriver, String xpath_value, String text_value) {
		
		try {
				text = ldriver.findElement(By.xpath(xpath_value));			
				if(text.isEnabled()) {				
					text.clear();
					text.sendKeys(text_value);				
			}
		} 		
		catch (Exception e) {			
				System.out.println(e.getMessage());
		}		
		
	}	
	
	//****************************************Click Function*********************************************
	
	public static void clickElement (WebDriver ldriver, String xpath_value) {
		
		try {
				click_webelement = ldriver.findElement(By.xpath(xpath_value));
				if(click_webelement.isEnabled()) {
					click_webelement.click();
				}
			} 
		catch (Exception e) {
				System.out.println(e.getMessage());			
		}		
				
	}
	
	//******************************************Get Title*************************************************
	
	public static String getPageTitle (WebDriver ldriver) {
		
		try {
			return ldriver.getTitle();
			} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return null;
		}
				
	}
	
	//******************************************Screenshot*************************************************
	
	public static void getScreenShots (WebDriver ldriver, String screenshot_name) {
		
		try {
				File src = ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./ScreenShots/"+screenshot_name+".png"));
		} 
		catch (Exception e) {			
			System.out.println(e.getMessage());			
		} 
				
	}
	
	
	
	
}
