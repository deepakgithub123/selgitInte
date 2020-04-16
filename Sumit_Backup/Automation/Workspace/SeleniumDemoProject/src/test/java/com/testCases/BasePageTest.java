package com.testCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBaseSetup;
import com.pageObjects.BasePage;
import org.testng.ITestResult;

//import registrationAuthentication.ITestResult;

import org.testng.annotations.AfterMethod;
//import com.testCases.ITestResult;

public class BasePageTest extends TestBaseSetup{
	
	BasePage basePage;
	@Test
	public void verifyIndexPage()
	{
		basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Index page title doesn't match");
		
	}

	@AfterMethod
	public void scrShot(ITestResult result) throws Exception{
		if(ITestResult.FAILURE==result.getStatus())
		{
			String testName = result.getName().toString().trim();
			String activeClass = getClass().getName().trim();
			takeSnapShot(driver, "D:\\Sumit_Backup\\Automation\\Workspace\\SeleniumDemoProject\\Screenshots\\"+testName+".png");
		}
	}
	
}
