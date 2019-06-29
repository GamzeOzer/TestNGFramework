package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddLocationPage {

	@FindBy(css="input#name")
	public WebElement name;
	
	@FindBy(xpath="//*[@id='countryCode_inputfileddiv']//div//input")
	public WebElement country;
	
	@FindBy(xpath="//*[@id='countryCode_inputfileddiv']//div/ul/li")
	public List<WebElement> listOfCountry;
	
	@FindBy(xpath="//div[@id='state_inputfileddiv']//div//input")
	public WebElement state;
	
	@FindBy(xpath="//div[@id='state_inputfileddiv']//div//ul//li")
	public List<WebElement> listOfState;
	
	@FindBy(css="input#city")
	public WebElement city;
	
	@FindBy(css="input#zipCode")
	public WebElement zipCode;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement saveBtn;
	
	
	public AddLocationPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
