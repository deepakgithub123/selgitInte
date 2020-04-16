package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
 public ReadConfig()
 {
	
	File src=new File("./Configuration/config.properties");
	
	try {
		FileInputStream fis= new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception is"+e.getMessage());
	}

 }

public String getApplicationURL()
{
	String url=pro.getProperty("Siteurl");
	return url;
}

public String getChromePath()
{
	String chromePath=pro.getProperty("chromepath");
	return chromePath;
}

public String getFirefoxPath()
{
	String firefoxPath=pro.getProperty("firefoxpath");
	return firefoxPath;
}

public String getIEPath()
{
	String iePath=pro.getProperty("iepath");
	return iePath;
}

}