package com.Automation.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions
(
		features = "./features/",
		glue = {"com.Automation.StepDef"},
		tags = {"@UATTesting"},
		plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"},
		monochrome = true
)
public class TestRunner 
{
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider = "features")
	public void features(CucumberFeatureWrapper cucumberFeature)
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features()
	{
		return testNGCucumberRunner.provideFeatures();
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception
	{
		testNGCucumberRunner.finish();
	}
}
