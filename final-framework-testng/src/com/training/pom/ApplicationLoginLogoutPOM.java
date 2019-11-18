
package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ApplicationLoginLogoutPOM {
	private WebDriver driver; 
	
	public ApplicationLoginLogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	

    @FindBy(xpath="//img[@class='img-circle']")
	private WebElement logouticon;
    
    @FindBy(id="logout_button")
    private WebElement logoutbutton;
	
    
	

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		String value1 =this.userName.getAttribute("value");
		System.out.println(value1);
		Assert.assertEquals(value1, "kumark");
		
	}
	public void sendPassword(String password) throws InterruptedException {
		this.password.clear();
		this.password.sendKeys(password);
		Thread.sleep(2000);
		String value2 =this.password.getAttribute("value");
		System.out.println(value2);
		Assert.assertEquals(value2, "kumarkundan1!");
		
		System.out.println(value2);
		
	
		Assert.assertEquals(value2, "kumarkundan1!");
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void gotoLogoutIcon() {
		this.logouticon.click();
	}
	
	public void clickOnLogout() {
		this.logoutbutton.click();
	}
	
	
	
	
	
}

