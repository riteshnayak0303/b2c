package com.hpeb2c.testcases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_CreateQuoteTest_008 extends BaseClass {

	@Test(priority = 2, dataProvider = "ValidLoginData", dataProviderClass = DataProviders.class)
	public void createQuote(String username, String password, String exp) throws InterruptedException {

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
		driver.findElement(By.xpath("//button[contains(text(),'Request Quote')]")).click();
		Thread.sleep(3000);
		WebElement ss = driver.findElement(By.xpath("//select[@id='title']"));
		Select s = new Select(ss);
		s.selectByValue("quote_IT Executive");
		
		driver.findElement(By.id("last-name")).clear();
		driver.findElement(By.id("last-name")).sendKeys("test");
		
		
		WebElement radiobtn = driver.findElement(By.xpath("//label[@for='quoteemailcontactrad']"));
		JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
		clickquotebutton.executeScript("arguments[0].click();", radiobtn);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='fe_arrow']")).click();
	
		
		driver.findElement(By.id("bussines-need")).sendKeys("Test sanity quote");
		
		driver.findElement(By.xpath("//div[@class='hpe-input  fe_decision']")).click();
		
		
		WebElement clickquotebutton1 = driver.findElement(By.id("getQuote"));
		JavascriptExecutor quotebutton = (JavascriptExecutor) driver;
		quotebutton.executeScript("arguments[0].click();", clickquotebutton1);
		Thread.sleep(3000);
		
		/*WebElement clickquotebutton11 = driver.findElement(By.id("getQuote"));
		JavascriptExecutor quotebutton2 = (JavascriptExecutor) driver;
		quotebutton2.executeScript("arguments[0].click();", clickquotebutton11);
		
		Thread.sleep(6000);
		Set <String>  s1 =driver.getWindowHandles();
		for(String i:s1) {
			//System.out.println(i);
			String t=driver.switchTo().window(i).getTitle();
		
			String Quotesummarypge =driver.getTitle();
	 
			Assert.assertEquals("Quote Summary Page | HPE Store US" , Quotesummarypge);
			System.out.print(Quotesummarypge);
		}*/
	}

}