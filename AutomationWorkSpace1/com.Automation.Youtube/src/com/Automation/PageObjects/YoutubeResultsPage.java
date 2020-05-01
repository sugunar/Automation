package com.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class YoutubeResultsPage 
{
	private WebDriver driver;
	public YoutubeResultsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	/*@FindBy(how=How.ID, using="search")
	public WebElement searchTextBox;
	
	@FindBy(how=How.ID, using="search-icon-legacy")
	public WebElement searchBtn;*/
	
	@FindBy(how=How.LINK_TEXT, using="Digital Evaluation of VTU| How it works??? | Is it good?|")
	public WebElement linkText;
	
	public void NavigateToResultsPage()
	{
		new YoutubeSearchPage(driver).NavigateToResultPage();
	}
	
	public void ClickOnLink() throws InterruptedException
	{
		Thread.sleep(4000);
		linkText.click();
	}
	public void ValidateChannelPageTitle() throws InterruptedException
	{
		Thread.sleep(4000);
		Assert.assertEquals("Digital Evaluation of VTU| How it works??? | Is it good?| - YouTube", driver.getTitle());
	}

}
