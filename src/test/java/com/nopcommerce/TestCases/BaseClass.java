package com.nopcommerce.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.Utilities.ReadConfig;

public class BaseClass 
{
	public WebDriver driver;
	
	ReadConfig RC = new ReadConfig();
	public String baseURL = RC.getApplicationURL();
	public String UserName = RC.getUsername();
	public String Password = RC.getPassword();
	public String ChromePath = RC.getChromepath();
	public String FirefoxPath = RC.getFirefoxpath();
	public String IEPath = RC.getIEpath();
	
	public Logger logger;
	
			
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger = Logger.getLogger("nopCommerceV4");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",ChromePath);
		    driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",FirefoxPath);
		    driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",IEPath);
		    driver = new InternetExplorerDriver();
		}
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}
}
