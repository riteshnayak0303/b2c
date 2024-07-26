package com.hpeb2c.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	 
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@title='My account']")
	WebElement myac;
	
	@FindBy(xpath="//a[@class='checkout']")
	WebElement hpeStoreLogin;
	
	@FindBy(id="j_username")
	WebElement userEmail;
	
	@FindBy(id="hpeLoginBtn")
	WebElement signin; 
	
	@FindBy(id="password-sign-in")
	WebElement password;
	
	@FindBy(className="close-icon")
	WebElement closeicon;
	
	@FindBy(id="onepass-submit-btn")
	WebElement signin2;
	
	@FindBy(id="widget-login-error")
	WebElement loginerrormessage;
	
	@FindBy(id="hpe-store-signed-in-indicator")
	WebElement greendot;
	
	public WebElement myacc()
	{
		return myac;
		
	}

	public void hpeStoreLoginButton()
	{
		hpeStoreLogin.click();
	}
	
	public void enterUsername(String uname)
	{
		userEmail.sendKeys(uname);
	}
	
	public void clickSignInButton()
	{
		signin.click();
	}
	
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	
	public void clickonsign2()
	{
		signin2.click();
	}
	
	public WebElement displayErrorMsg()
	{
		return loginerrormessage;
		
	}
	
	public void closeicon()
	{
		closeicon.click();
		
	}
	
	public WebElement greendotdisplay()
	{
		return greendot;
		
	}
}
