package com.hpeb2c.testcases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hpeb2c.pageObjects.BaseClass;

public class TC_CategoryTest_004 extends BaseClass{


	
	
	@Test
public void Categorylinks()
{
	
WebElement headerlinks = driver.findElement(By.id("hpehf-sn-links-wrapper"));

int Headerlinksize = headerlinks.findElements(By.tagName("a")).size();

System.out.println("Total header links available are" + Headerlinksize);

for (int i = 1; i<4; i++) {
	String clickctrl = Keys.chord(Keys.CONTROL, Keys.ENTER);
	headerlinks.findElements(By.tagName("a")).get(i).sendKeys(clickctrl);
}

			Set <String>  s =driver.getWindowHandles();
			for(String i:s) {
				//System.out.println(i);
				String t=driver.switchTo().window(i).getTitle();
				System.out.print(t);
				if(t.contains("Networking | HPE Store US")){
				driver.close();
				}
				if(t.contains("Data Storage Systems | HPE Store US")){
					driver.close();
				}
				if(t.contains("Servers and Server Systems | HPE Store US")) {
					driver.close();
				
				}
			}


}

}
