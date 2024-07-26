package com.hpeb2c.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_LoginTest_001 extends BaseClass{

	
	@Test(priority=1,dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void InvalidloginTest(String username, String password, String exp) throws InterruptedException
	{
		
		
		LoginPage lp = new LoginPage(driver);
		lp.myacc().click();
		lp.hpeStoreLoginButton();
		lp.enterUsername(username);
		lp.clickSignInButton();
		//Thread.sleep(5000);
		
		lp.enterPassword(password);
		lp.clickonsign2();
		
		//With invalid credentials
		boolean errormessage = lp.displayErrorMsg().isDisplayed();
		
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(errormessage==true)
			{
				Assert.assertTrue(true);
			}
		
			else
			{
				Assert.assertTrue(false);
			}	
		}
		//close icon
		lp.closeicon();
	}

	@Test(priority=2,dataProvider="ValidLoginData", dataProviderClass=DataProviders.class)
	public void ValidloginTest(String username, String password, String exp) throws InterruptedException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.myacc().click();
	lp.hpeStoreLoginButton();
		
		lp.enterUsername(username);
		lp.clickSignInButton();
		//Thread.sleep(5000);
		
		lp.enterPassword(password);
		lp.clickonsign2();
		
		//With valid credentials
		
		boolean greenicon = lp.greendotdisplay().isDisplayed();
		Assert.assertTrue(true);
		
	
	}
}

