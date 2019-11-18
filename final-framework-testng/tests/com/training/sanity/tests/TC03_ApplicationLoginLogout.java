
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ApplicationLoginLogoutPOM;


import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC03_ApplicationLoginLogout {

	private WebDriver driver;
	private String baseUrl2;
	private ApplicationLoginLogoutPOM AL;
	private static Properties properties;
	private ScreenShot screenShot;
	private String myRC;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		AL = new ApplicationLoginLogoutPOM(driver); 
		baseUrl2 = properties.getProperty("baseURL2");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl2);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test()
	public void validLoginTest() throws InterruptedException {
		AL.sendUserName("kumark");
		screenShot.captureScreenShot("TC03_First");
		
		AL.sendPassword("kumarkundan1!");
		screenShot.captureScreenShot("TC03_2nd");
		System.out.println();
		AL.clickLoginBtn(); 
	
		screenShot.captureScreenShot("TC03_3rd");
		AL.gotoLogoutIcon();
		screenShot.captureScreenShot("TC03_4th");
		
		AL.clickOnLogout();
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC03_5th");
		
		
		
		
	}
	
}


