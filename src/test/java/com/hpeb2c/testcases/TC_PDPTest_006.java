package com.hpeb2c.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.LoginPage;
import com.hpeb2c.pageObjects.PDPPage;
import com.hpeb2c.utilities.DataProviders;

public class TC_PDPTest_006 extends BaseClass {

	@Test(priority = 2, dataProvider = "ValidLoginData", dataProviderClass = DataProviders.class)
	public void pdp(String username, String password, String exp) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		PDPPage pdp = new PDPPage(driver);
		
		
		
		
		lp.myacc().click();
		lp.hpeStoreLoginButton();

		lp.enterUsername(username);
		lp.clickSignInButton();
		// Thread.sleep(5000);

		lp.enterPassword(password);
		lp.clickonsign2();
		Thread.sleep(5000);
		
		//Click on Storage category link 
		pdp.storage();
		
		//Click filestorage tile 
		JavascriptExecutor clickcat = (JavascriptExecutor) driver;
		clickcat.executeScript("arguments[0].click();", pdp.fileStorage());
		
		
		//Click on Product from category list page
		for (int i = 0; i < pdp.categoryproductTitle().size(); i++) {
			String catgoryproductTitle = pdp.categoryproductTitle().get(i).getText();
			// System.out.println(i);
			System.out.println("product names are " + catgoryproductTitle);

			if (catgoryproductTitle.contains("HPE Solutions with Qumulo")) {
				Thread.sleep(3000);
				System.out.println("Selected product names are " + catgoryproductTitle);
				
			WebElement plpprodtitle = pdp.plpproductTitle().get(i);
				JavascriptExecutor clickprodtitle = (JavascriptExecutor) driver;
				clickprodtitle.executeScript("arguments[0].click();", plpprodtitle);
				break;
			}
		}

		
		// <!--Clicks on Variant product and navigates to PDP>
		
			//List<WebElement> pdpproduts = pdp.variantroductTitle();
		  for (int i = 0; i < pdp.variantroductTitle().size(); i++) {
			String pdpproductnamee = pdp.variantroductTitle().get(i).getText();
			// System.out.println(i);
			System.out.println("pdp names are " + pdpproductnamee);
		


		//Click on Variant product name
			
			if (pdpproductnamee.contains("HPE Apollo 4200 Gen10 Plus 36TB 25Gb TAA‑compliant Node for Qumulo")) {
				Thread.sleep(3000);
				

				WebElement pdpproduct = pdp.Variantroductname().get(i);
				JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
				clickquotebutton.executeScript("arguments[0].click();", pdpproduct);
				break;
			}
		}
		  Thread.sleep(3000);
		 //Click on quote button
		WebElement getquotebtn = pdp.Quotebutton();
		JavascriptExecutor clickquotebutton = (JavascriptExecutor) driver;
		clickquotebutton.executeScript("arguments[0].click();", getquotebtn);
		
		
	
	}

	

}