package com.Automation.StepDef;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Automation.PageObjects.YoutubeSearchPage;
import com.Automation.Utility.BrowserUtility;
import com.Automation.Utility.PropertiesFileReader;

//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YoutubeSearch //extends BrowserUtility
{
	private  WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();

	@Given("^Open the browcer and enter the url$")
	public void open_the_browcer_and_enter_the_url() throws Throwable 
	{
		Properties prop = obj.getProperty();
	    driver = BrowserUtility.OpenBrowser(driver, prop.getProperty("browser.name"), prop.getProperty("browser.baseURL"));
		
	}

	@When("^Enter search criteria$")
	public void enter_search_criteria() throws Throwable 
	{
		
		new YoutubeSearchPage(driver).NavigateToResultPage();
   
	}

	@Then("^user should be redirected to search results page$")
	public void user_should_be_redirected_to_search_results_page() throws Throwable 
	{
		new YoutubeSearchPage(driver).ValidateReultsPageTitle();
	}
	
	
}
//	@Test(alwaysRun = true)
//	public void demo()
//	{
//		// TODO Auto-generated method stub
//		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		WebDriver d = new ChromeDriver();
//		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		d.get("https://www.google.co.in/");
//	}
//}
