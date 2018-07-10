package com.vmb.utility;

/*
Author : Raja
Date : 03-07-2018
Description : Common functions which are used 
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	
	
	
	
	
}
