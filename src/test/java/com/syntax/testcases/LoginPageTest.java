package com.syntax.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	@Test(groups="smoke")
	public void loginToOrangeHRM() {
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		test.info("Logging in with valid credentials");
		CommonMethods.sendText(login.userName, "Admin");
		CommonMethods.sendText(login.password, "FbThK45@Oi");
		CommonMethods.click(login.btnLogin);
		test.info("verifying dashboard text is displayed");
		HomePage home=new HomePage();
		boolean isDisplayed=home.dashBoard.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(groups="smoke")
	public void doLogin() {
		LoginPage login=new LoginPage();
		CommonMethods.sendText(login.userName,  ConfigsReader.getProperty("username"));
	
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
	
		HomePage home=new HomePage();
		boolean isDisplayed=home.dashBoard.isDisplayed();
		Assert.assertTrue(isDisplayed);
	
	}

	@Test(groups="regression")
	public void NegativeLogin() {
		LoginPage login=new LoginPage();
		login.login(ConfigsReader.getProperty("username"), "45678");
		boolean isDisplayed=login.errorMessage.isDisplayed();
		AssertJUnit.assertTrue(isDisplayed);
	
		//or
		
		String errorMessage=login.errorMessage.getText();
		AssertJUnit.assertEquals(errorMessage, "Invalid Credentials");
	}
	
}
