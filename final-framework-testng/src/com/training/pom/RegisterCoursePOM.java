package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterCoursePOM {
	private WebDriver driver; 
	
	public RegisterCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Course catalog")
	private WebElement course;
	
	@FindBy(name="search_term")
	private WebElement coursename;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement search;
	
	@FindBy(linkText="IYTLRHV")
	private WebElement coursenamefound;
	
    @FindBy(linkText="Subscribe")
	private WebElement clicksubscribe;
    
    @FindBy(xpath="//div[@class='alert alert-info']")
    private WebElement subscribeconfirm;
    
	

	
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
	
	public void clickOnCourseCatalog() {
		this.course.click();
	}
	
	public void enterCourseName(String coursename) {
		this.coursename.sendKeys(coursename);
		
	}
	
	public void clickOnSearch() {
		this.search.click();
	}
	
	public void clickOnCoursenameFound() {
		this.coursenamefound.click();
	}
	
	public void clickOnSubscribe() {
		this.clicksubscribe.click();
	}
	
	
	public void subscribeconfirmed() throws InterruptedException {
		Thread.sleep(3000);
		String str=subscribeconfirm.getText();
	Assert.assertEquals(str, "User KUNDAN KUMAR (kumark) has been registered to course IYTLRHV");
	}
}
