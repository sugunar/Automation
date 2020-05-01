package com.Automation.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BrowserOperations 
{
	static WebDriver driver;
	public static WebDriver OpenBrowser(WebDriver driver,String browserName, String url) throws InterruptedException
	{
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
			open(url);
			
			
		}
			
		else 
			if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			open(url);
			
		}
		return null;
	}

	private static WebDriver open(String burl) throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get(burl);
		Thread.sleep(3000);
		return driver;
	}
	
}


