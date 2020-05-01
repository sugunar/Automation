package com.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class YoutubeSearchPage 
{
	private WebDriver driver;
	public YoutubeSearchPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.ID, using="search")
	public WebElement searchTextBox;
	
	@FindBy(how=How.CLASS_NAME, using="Tg7LZd")
	public WebElement searchBtn;
	
	public void NavigateToResultPage()
	{
		searchTextBox.sendKeys("Vtu");
		searchBtn.click();
	}
	
	public void ValidateReultsPageTitle() throws InterruptedException
	{
		Thread.sleep(4000);
		Assert.assertEquals("Vtu - YouTube", driver.getTitle());
		System.out.println(driver.getTitle());
	}

}
