package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class LocationPage {

	@FindBy(xpath="//i[text()='add']")
	public WebElement addLocationBtn;
	
	@FindBy(xpath="//div[@class='list-container']//list//table//tbody//tr")
	public List<WebElement> locationList;
	
	
	public LocationPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
}
