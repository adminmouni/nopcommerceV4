package com.nopcommerce.PageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
				
	}
	
	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(xpath ="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	WebElement lnkLogout;
	
	public void setUsername(String uname)
	{
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}

}
