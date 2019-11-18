package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CourseDescriptionPOM {
	private WebDriver driver; 
	
	public CourseDescriptionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(linkText="My courses")
	private WebElement mycourses;
	
	@FindBy(linkText="123testing")
	private WebElement myRegsiteredCourse;
	
	
	@FindBy(linkText="Course description")
	private WebElement courseDescription;
	
	@FindBy(xpath="//ul[@class='breadcrumb']")
	private WebElement descriptionpagedetails;
	
    
	

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickOnMyCourses() {
		this.mycourses.click();
	}
	
	public void ClickOnRegisteredCourseName() {
		this.myRegsiteredCourse.click();;
		
	}
	
	public void ClickOnCourseDescription() {
		this.courseDescription.click();;
		
	}
	
	public void DescriptionPage() {
		this.descriptionpagedetails.isDisplayed();
		Boolean bl=this.descriptionpagedetails.isDisplayed();
		System.out.println(bl);
		
		
	}
	
	
	
	
}

