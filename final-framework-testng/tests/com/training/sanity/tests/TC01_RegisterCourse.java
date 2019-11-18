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
import com.training.pom.RegisterCoursePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC01_RegisterCourse {

	private WebDriver driver;
	private String baseUrl2;
	private RegisterCoursePOM RC;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		RC = new RegisterCoursePOM(driver); 
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
		RC.sendUserName("kumark");
		RC.sendPassword("kumarkundan1!");
		System.out.println();
		RC.clickLoginBtn(); 
	
		screenShot.captureScreenShot("First");
		

		System.out.println("pre-requisite met");
		RC.clickOnCourseCatalog();
		screenShot.captureScreenShot("2nd");
		System.out.println("Coursedetails opens");
		RC.enterCourseName("IYTLRHV");
		RC.clickOnSearch();
		screenShot.captureScreenShot("3rd");
		RC.clickOnCoursenameFound();
		screenShot.captureScreenShot("4th");
		RC.clickOnSubscribe();
		screenShot.captureScreenShot("5th");
		RC.subscribeconfirmed();
		System.out.println("SubscribeConfirmed");
		screenShot.captureScreenShot("6th");
	}
	
}
