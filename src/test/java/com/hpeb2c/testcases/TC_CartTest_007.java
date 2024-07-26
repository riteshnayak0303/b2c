package com.hpeb2c.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_CartTest_007 extends BaseClass {

	@Test(priority = 2, dataProvider = "ValidLoginData", dataProviderClass = DataProviders.class)
	public void cartPage(String username, String password, String exp) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.myacc().click();
		lp.hpeStoreLoginButton();

		lp.enterUsername(username);
		lp.clickSignInButton();
		// Thread.sleep(5000);

		lp.enterPassword(password);
		lp.clickonsign2();
		Thread.sleep(5000);
		// <!--Clicks on RequestQuote button>
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		
	}

}