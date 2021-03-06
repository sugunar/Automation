package com.Automation.StepDef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.Automation.PageObjects.YoutubeResultsPage;
import com.Automation.PageObjects.YoutubeSearchPage;
import com.Automation.Utility.BrowserOperations;
import com.Automation.Utility.BrowserUtility;
import com.Automation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YoutubeReults 
{
	private static WebDriver driver;
	PropertiesFileReader p = new PropertiesFileReader();
	
	@Given("^Open browser and enter the url$")
	public void open_browser_and_enter_the_url() throws Throwable 
	{
		Properties prop = p.getProperty();
//		driver = BrowserOperations.OpenBrowser(driver,prop.getProperty("browser.name"), prop.getProperty("browser.baseURL"));
	    driver = BrowserUtility.OpenBrowser(driver, prop.getProperty("browser.name"), prop.getProperty("browser.baseURL"));
	}

	@When("^user enters Search crieria like Vtu$")
	public void user_enters_Search_crieria_like_Vtu() throws Throwable 
	{
		new YoutubeSearchPage(driver).NavigateToResultPage();
	    
	}

	@When("^clicks on first link$")
	public void clicks_on_first_link() throws Throwable 
	{
		new YoutubeResultsPage(driver).ClickOnLink();
	}

	@Then("^user should be navigated to Channel page$")
	public void user_should_be_navigated_to_Channel_page() throws Throwable 
	{
		new YoutubeResultsPage(driver).ValidateChannelPageTitle();
	    
	}


}
