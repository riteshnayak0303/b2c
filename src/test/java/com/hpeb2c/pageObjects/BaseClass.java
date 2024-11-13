package com.hpeb2c.pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hpeb2c.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getBaseURL();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome"))
		{
		System.setProperty("webriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		}
		else 
		{
			System.setProperty("webriver.gecko.driver",readconfig.getfirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

	@FindBy(xpath="//div[contains(text(),'Select model')]")
	WebElement SelectBtn;

	public WebElement selectbutton() {
		return SelectBtn;
	}
}
