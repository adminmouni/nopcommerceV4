package com.nopcommerce.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.nopcommerce.PageObjectModels.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		logger.info("URL opened");
		
		LoginPage LP = new LoginPage(driver);
		
		LP.setUsername(UserName);
		logger.info("Provided Username");
		
		LP.setPassword(Password);
		logger.info("Provided Password");
		
		LP.clickLogin();
		logger.info("Clicked Login");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Thread.sleep(3000);
			LP.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");
		}
		else
		{
	       captureScreenshot(driver,"loginTest");
	       Assert.assertTrue(false);
	       logger.info("Login Failed");
	       
		}
	}

}
