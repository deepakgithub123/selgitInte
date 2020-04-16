package com.testCases;

import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.base.TestBaseSetup;
import com.pageObjects.SignupPage;

public class SignupTest extends TestBaseSetup {
	
	@Test(priority=1)
	public void registration() throws InterruptedException
	{

	//Click on Sign in
	driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();

	//Click on email field
	//driver.findElement(By.id("email_create")).click();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	SignupPage sp=new SignupPage();

	String invalidEmail= sp.generateInvalidEmail(20);
	driver.findElement(By.id("email_create")).sendKeys(invalidEmail);

	//Click on Create an account button
	driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();

//	Thread.sleep(3000);

	//Clear email field
	driver.findElement(By.id("email_create")).clear();

	//Thread.sleep(3000);

	String validEmail= sp.generateValidEmail(20);

	driver.findElement(By.id("email_create")).sendKeys(validEmail);

	//Click on Create an account button
	driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();

	}

	
	@Test(priority=2)
	public void personalInformation() throws InterruptedException
	{
	//	Thread.sleep(6000);
		
		driver.findElement(By.id("customer_firstname")).click();
		
		//Fill first name
		driver.findElement(By.id("customer_firstname")).sendKeys("deepak");
	
		//Fill last name
		driver.findElement(By.id("customer_lastname")).sendKeys("chamoli");
		
		//get email id
		String emailId =driver.findElement(By.id("email")).getAttribute("value");
	//	System.out.println(emailId);
		
		//Fill password
		driver.findElement(By.id("passwd")).sendKeys("chamoli");
		
		Thread.sleep(3000);
		
		String password= driver.findElement(By.id("passwd")).getAttribute("value");
//		System.out.println(password);
		
		//Date of Bitrh
		Select day= new Select(driver.findElement(By.id("days")));
		day.selectByValue("4");
		
		Thread.sleep(3000);
		
		Select month= new Select(driver.findElement(By.id("months")));
		month.selectByValue("3");

		Thread.sleep(3000);
		
		Select year= new Select(driver.findElement(By.id("years")));
		year.selectByValue("2020");

		//Address info..
		//First name
	//	driver.findElement(By.id("firstname")).sendKeys("deep");
		
		//Lastname
//		driver.findElement(By.id("lastname")).sendKeys("chamoli");
		
		//Address
		driver.findElement(By.id("address1")).sendKeys("phase 7");
		
		//city
		driver.findElement(By.id("city")).sendKeys("Mohali");
		
		//state
		Select state= new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("43");

		//postcode
		driver.findElement(By.id("postcode")).sendKeys("45678");
		
		//Country
		Select country= new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");

		//mobile
		driver.findElement(By.id("phone_mobile")).sendKeys("8798456787");

		//Address alias
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("# 1786,phase 7, mohali");
		
		//submit
	//	driver.findElement(By.id("submitAccount")).click();
		 
		
	//	String[] valueToWrite = { elements.get(i).getAttribute("title"), elements.get(i).getAttribute("href") };
		
		String[] valueToWrite = {emailId, password};
			
		SignupPage objExcelFile = new SignupPage();
objExcelFile.writeExcel("D:\\Sumit_Backup\\Automation\\Workspace\\SeleniumDemoProject\\testData","Data.xlsx", "Login", valueToWrite);

		
		//	System.out.print("XXXXXSuccess");

	
	
	
	
	}
	
	
	
	
}
