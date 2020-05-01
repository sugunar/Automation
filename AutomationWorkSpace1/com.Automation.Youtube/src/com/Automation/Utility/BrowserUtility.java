package com.Automation.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility 
{
	public static WebDriver OpenBrowser(WebDriver driver, String browserName, String url) throws InterruptedException
	{
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(3000);
			return driver;
		}
			
		else 
			if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(3000);
			return driver;
		}
		return null;
	}

}
