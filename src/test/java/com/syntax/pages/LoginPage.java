package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPage extends BaseClass{
	//locating WebElements using @FindBy annotation
	@FindBy(id = "txtUsername")
	public WebElement userName;
	
	@FindBy(name="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;

	@FindBy(css="img[src*='logo.png']")
	public WebElement logo;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement errorMessage;
	
	//we have to initialize all of our variables
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String usrname,String pwd) {
		CommonMethods.sendText(userName, usrname);
		CommonMethods.sendText(password, pwd);
		CommonMethods.click(loginBtn);
		
	}
}
