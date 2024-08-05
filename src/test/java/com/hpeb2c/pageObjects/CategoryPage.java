package com.hpeb2c.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

WebDriver ldriver;
	 
	
	public CategoryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

@FindBy (id="hpehf-sn-links-wrapper")
WebElement headerlinks;



public WebElement categorieslink() {
	
	return headerlinks;
}





}
