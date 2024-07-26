package com.hpeb2c.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_PDPTest_006 extends BaseClass {

	@Test(priority = 2, dataProvider = "ValidLoginData", dataProviderClass = DataProviders.class)
	public void pdp(String username, String password, String exp) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.myacc().click();
		lp.hpeStoreLoginButton();

		lp.enterUsername(username);
		lp.clickSignInButton();
		// Thread.sleep(5000);

		lp.enterPassword(password);
		lp.clickonsign2();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Storage")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'File Storage')]")).click();

		List<WebElement> prodnames = driver.findElements(By.xpath(
				"//h2[@class='hpe-headline hpe-headline--strong hpe-headline--small hpe-product-list__name hpe-headline-reduced']"));
		for (int i = 0; i < prodnames.size(); i++) {
			String productname = prodnames.get(i).getText();
			// System.out.println(i);
			System.out.println("product names are " + productname);

			if (productname.contains("HPE Solutions with Qumulo")) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@class='enable-analytics brand-color']")).click();
				break;
			}
		}

		// <!--Clicks on Variant product and navigates to PDP>
		
		List<WebElement> pdpproduts = driver.findElements(By
				.xpath("//h2[@class='hpe-headline hpe-headline--strong hpe-headline--small hpe-product-list__name']"));
		for (int i = 0; i < pdpproduts.size(); i++) {
			String pdpproductname = pdpproduts.get(i).getText();
			// System.out.println(i);
			System.out.println("product names are " + pdpproductname);

			if (pdpproductname.contains("HPE Apollo 4200 Gen10 Plus 36TB 25Gb TAA‑compliant Node for Qumulo")) {
				Thread.sleep(3000);
				// driver.findElement(By.xpath("//a[@class='hpe-anchor
				// hpe-anchor--primary']")).click();

				WebElement pdpproduct = driver.findElement(By.xpath("//a[@class='hpe-anchor hpe-anchor--primary']"));
				JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
				clickquotebutton.executeScript("arguments[0].click();", pdpproduct);
				break;
			}
		}

		WebElement getquotebtn = driver.findElement(By.xpath("//div[contains(text(),'Get Quote')]"));
		JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
		clickquotebutton.executeScript("arguments[0].click();", getquotebtn);

	
	
	}

}