package com.hpeb2c.testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;
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
	driver.findElement(By.linkText("Create an account")).click();
	
	 
	
		WebElement element = driver.findElement(By.id("email-address"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", element);
	String email = "sanitycheck"+int_random+"@yopmail.com";
	System.out.println(email);
	element.sendKeys(email);
		//element.sendKeys("sanitycheck"+int_random+"@yopmail.com");
	
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Tesh@1234");
	driver.findElement(By.xpath("//input[@id='repeat-password']")).sendKeys("Tesh@1234");
	
	

	
	
	WebElement ss = driver.findElement(By.xpath("//select[@id='select3']"));
	//((JavascriptExecutor) driver).executeScript("arguments[0].click", ss);
	
	
	//ss.click();
	Select s = new Select(ss);

	s.selectByValue("mr");
	driver.findElement(By.id("first-name")).sendKeys("ususer");
	driver.findElement(By.id("last-name")).sendKeys("sanity");
	driver.findElement(By.id("company")).sendKeys("DXC");
	driver.findElement(By.id("address1")).sendKeys("3255 Lakeshore Ave");
	driver.findElement(By.id("city")).sendKeys("Oakland");
	
	WebElement state = driver.findElement(By.id("select2"));
	Select stat = new Select(state);
	stat.selectByValue("CA");
	
	driver.findElement(By.id("zip")).sendKeys("94610-2719");
	
	WebElement  createacc = driver.findElement(By.id("registerUserBtn"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",createacc);
	//Thread.sleep(3000);
	driver.findElement(By.xpath("//h3[contains(text(),'Check your address')]")).isDisplayed();
	Thread.sleep(3000);
	
	/*WebElement  createacc2 = driver.findElement(By.id("registerUserBtn"));
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("arguments[0].click();",createacc2);
	Thread.sleep(3000);
	
	WebElement  createacc3 = driver.findElement(By.id("registerUserBtn"));
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js2.executeScript("arguments[0].click();",createacc3);
	
	WebElement succmsh = driver.findElement(By.id("successMessage"));
	boolean message = succmsh.isDisplayed();
	String ssmsg = succmsh.getText();
	
	System.out.println(ssmsg);*/
	/*Thread.sleep(15000);
	
	
	driver.get("https://yopmail.com/");
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
