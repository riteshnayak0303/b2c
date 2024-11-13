package com.hpeb2c.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.pageObjects.PDPPage;
import com.hpeb2c.pageObjects.PLPPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_PLPTest_005 extends BaseClass {

	@Test(priority = 1, dataProvider = "ValidLoginData", dataProviderClass = DataProviders.class)
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
		PDPPage pdp = new PDPPage(driver);
		PLPPage plp = new PLPPage(driver);
		
		// Click on server and system link
		for (int retry = 0; retry < 5; retry++) {

			try {
				plp.serversandsystems();
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.toString());
			}
		}

	}

	@Test(priority = 2)
	public void addquoteproductfromplp() throws InterruptedException {
		PLPPage plp = new PLPPage(driver);
		PDPPage pdp = new PDPPage(driver);
		// click on HPE Proliant servers tile

		plp.hpeProLiantGen11servers();

		// click on page dropdown

		JavascriptExecutor pgedrop = (JavascriptExecutor) driver;
		pgedrop.executeScript("arguments[0].click();", plp.dropDown());
		Select s = new Select(plp.dropDown());
		s.selectByValue("100");


		for (int i = 0; i < pdp.categoryproductTitle().size(); i++) {
			String catgoryproductTitle = pdp.categoryproductTitle().get(i).getText();
			// System.out.println(i);
			System.out.println("product names are " + catgoryproductTitle);

			if (catgoryproductTitle.contains("HPE ProLiant DL345 Gen11")) {
				Thread.sleep(3000);

				WebElement plpprodtitle = pdp.plpproductTitle().get(i);
				JavascriptExecutor clickprodtitle = (JavascriptExecutor) driver;
				clickprodtitle.executeScript("arguments[0].click();", plpprodtitle);
				break;

			}
		}
		Thread.sleep(5000);

		// click on select button
		JavascriptExecutor clickplpprod = (JavascriptExecutor) driver;
		clickplpprod.executeScript("arguments[0].click();", plp.selectbutton());

		//List<WebElement> plpproducts = driver
				//.findElements(By.xpath("//div[@class='col-md-9 hpe-full-bleed--mobile productModels']"));
		
		List<WebElement> plpproducts=plp.plpproducts();
		for (int i = 0; i < plpproducts.size(); i++) {
			String productname = plpproducts.get(i).getText();

			System.out.println("product names are " + productname);

			if (productname.contains("HPE ProLiant DL345 Gen11 9124 3.0GHz 16"))

			{
				System.out.println("selected product names are " + productname);

				Thread.sleep(3000);

				WebElement requestquotebtn = plp.requestQuotebutton().get(i);

				JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
				clickquotebutton.executeScript("arguments[0].click();", requestquotebtn);

				break;
			}

		}

	}

}