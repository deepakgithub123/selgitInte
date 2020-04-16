package com.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.testng.log4testng.Logger;

import com.listeners.MyListener;
import com.utilities.ReadConfig;

public class TestBaseSetup{

	public static WebDriver driver;
	
	ReadConfig con= new ReadConfig();
	
	public String siteUrl= con.getApplicationURL();
	
//	public WebDriver getDriver() {
//		return driver;
//	}

//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		System.out.print("BR value"+br);
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",con.getChromePath());
			driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", con.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", con.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		Logger logger = Logger.getLogger("TestBaseSetup");
		PropertyConfigurator.configure("D:\\Sumit_Backup\\Automation\\Workspace\\SeleniumDemoProject\\log4j.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(siteUrl);
		logger.info("URL is opened"); 

		driver.manage().window().maximize();
		logger.info("Window is maximized"); 

	}
		
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
            File DestFile=new File(fileWithPath);
   //  File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");

                //Copy file at destination
                FileUtils.copyFile(SrcFile, DestFile);

    }

	
	
	
	
}