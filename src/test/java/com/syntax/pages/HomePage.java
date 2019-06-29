package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashBoard;
	
	@FindBy(xpath="//span[text()='PIM']")
	public WebElement pim;
	
	@FindBy(xpath="//span[text()='Add Employee']")
	public WebElement addEmployee;
	
	@FindBy(xpath="//span[@class='left-menu-title'][contains(text(),'Admin')]")
	public WebElement admin;
	
	@FindBy(xpath="//span[text()='Organization']")
	public WebElement organization;
	
	@FindBy(xpath="//span[text()='Locations']")
	public WebElement location;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
