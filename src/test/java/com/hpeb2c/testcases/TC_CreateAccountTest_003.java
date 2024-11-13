package com.hpeb2c.testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
import com.hpeb2c.pageObjects.CreateAccount;
import com.hpeb2c.pageObjects.LoginPage;

public class TC_CreateAccountTest_003 extends BaseClass {

@Test
public void createacc() throws InterruptedException
{

	Random rand = new Random();
	int upperbound = 25000;
	//it will generate random numbers
	int int_random = rand.nextInt(upperbound);
			
	LoginPage lp = new LoginPage(driver);
	lp.myacc().click();
	
	CreateAccount ca = new CreateAccount(driver);
	
	
	//Click on Create account link
	ca.createAccount();
	
	
	 
		//click on email address field
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click", ca.emailAddress());
	
		String email = "sanitycheck"+int_random+"@yopmail.com";
		System.out.println(email);
		ca.emailAddress().sendKeys(email);
	
	//enter password
	ca.password("Tesh@1234");
	ca.repeatPassword("Tesh@1234");
	
	WebElement ss = ca.titles();
	
	Select s = new Select(ss);

	s.selectByValue("mr");
	//Enter First name
	
	ca.firstName("ususer");
	//Enter last name
	
	ca.lastName("sanity");
	
	
	//Enter company name
	ca.company("HPE");
	
	
	//enter address
	ca.address1("3255 Lakeshore Ave");
	
	//enter city
	ca.city("Oakland");
	
	
	
	WebElement state = driver.findElement(By.id("select2"));
	Select stat = new Select(state);
	stat.selectByValue("CA");
	
	//enter zip
	ca.zip("94610-2719");
	
	
	//click on register button
	//WebElement  createacc = driver.findElement(By.id("registerUserBtn"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",ca.registerButton());
	
		//Address text
	ca.addressText();
		Thread.sleep(3000);
	
		//click on register button twice
		for (int click = 0; click < 2; click++) {

			try {
				JavascriptExecutor jss = (JavascriptExecutor) driver;
				jss.executeScript("arguments[0].click();",ca.registerButton());
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.toString());
			}
		}
		
		
		
	/*WebElement succmsh = driver.findElement(By.id("successMessage"));
	boolean message = succmsh.isDisplayed();
	String ssmsg = succmsh.getText();*/
		//ca.successMsg();
	boolean message = ca.successMesg();
		
	System.out.println(ca.successMesg());
	Thread.sleep(15000);
	
	//<!---------------------------------------------------------------------------------------------------------------->

	/*	driver.get("https://yopmail.com/");
	driver.findElement(By.xpath("//input[@id='login']")).sendKeys(email);
	driver.findElement(By.xpath("//button[@title='Check Inbox @yopmail.com']")).click();
	Thread.sleep(5000);
	driver.switchTo().frame("ifmail");
	Thread.sleep(5000);
	WebElement  createacc4 = driver.findElement(By.xpath("//span[contains(text(),'Activate HPE Account')]"));
	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("arguments[0].click();",createacc4);*/
}




}
