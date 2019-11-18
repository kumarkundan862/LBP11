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
import com.training.pom.CourseDescriptionPOM;


import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC02_CourseDescription {

	private WebDriver driver;
	private String baseUrl2;
	private CourseDescriptionPOM CD;
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
		CD = new CourseDescriptionPOM(driver); 
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
		CD.sendUserName("kumark");
		CD.sendPassword("kumarkundan1!");
		System.out.println();
		CD.clickLoginBtn(); 
	
		screenShot.captureScreenShot("TC02_First");
		CD.clickOnMyCourses();
		System.out.println("pre-requisite met");
		CD.ClickOnRegisteredCourseName();
		
		myRC= properties.getProperty("MyRC");//did just for understanding how this works, so can ignore this code
		System.out.println("MyCourse "+ myRC +" is selected ");//did just for understanding how this works, so can ignore this code
		screenShot.captureScreenShot("TC02_2nd");
		CD.ClickOnCourseDescription();
		System.out.println("Description Page opens");
		screenShot.captureScreenShot("TC02_3rd");
		CD.DescriptionPage();
		
		
		
	}
	
}

