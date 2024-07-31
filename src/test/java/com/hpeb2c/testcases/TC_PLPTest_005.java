package com.hpeb2c.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_PLPTest_005 extends BaseClass {

	@Test(priority = 2, dataProvider = "ValidLoginData", dataProviderClass = DataProviders.class)
	public void plp(String username, String password, String exp) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.myacc().click();
		lp.hpeStoreLoginButton();

		lp.enterUsername(username);
		lp.clickSignInButton();
		// Thread.sleep(5000);

		lp.enterPassword(password);
		lp.clickonsign2();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Servers and Systems")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'HPE ProLiant Gen 11 servers')]")).click();

		List<WebElement> prodnames = driver.findElements(By.xpath(
				"//h2[@class='hpe-headline hpe-headline--strong hpe-headline--small hpe-product-list__name hpe-headline-reduced']"));
		for (int i = 0; i < prodnames.size(); i++) {
			String productname = prodnames.get(i).getText();
			// System.out.println(i);
			System.out.println("product names are " + productname);

			if (productname.contains("HPE ProLiant ML110 Gen11")) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@class='enable-analytics brand-color']")).click();
				break;
			}
		}
		//h2[@class='hpe-headline hpe-headline--strong hpe-headline--small hpe-product-list__name']
		
		
		List<WebElement> btn = driver.findElements(By.xpath(
				"//div[@class='hpe-product-list__meta row product-models-slot']"));
		for (int i = 0; i < btn.size(); i++) {
			String productname = btn.get(i).getText();
			// System.out.println(i);
			System.out.println("product names are " + productname);

			if (productname.contains("Request Quote")) {
				Thread.sleep(3000);
				
				WebElement  requestquote = driver.findElement(By.xpath("//button[contains(text(),'Request Quote')]"));
				JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
				clickquotebutton.executeScript("arguments[0].click();",requestquote);
				break;
			}
		}
		
		
		
	
	}

}