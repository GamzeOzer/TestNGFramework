package com.syntax.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LocationPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;


//Test Case: Add Location
//1. Login to OrangeHRM
//2. From Admin --> Organization select Locations
//3. Add 5 different locations by providing complete 
//required details (Use data provider)
//4. Save location and verify it has been successfully saved.
public class AddLocationPageTest extends BaseClass{


	@Test(dataProvider="LocationDetails")
	public void AddLocation(String officeName,String countryName,String stateName,String cityName,String zipCode) {
		LoginPage login=new LoginPage();
		HomePage home=new HomePage();
		LocationPage location=new LocationPage();
		AddLocationPage addLocation=new AddLocationPage();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		home.admin.click();
		home.organization.click();
		home.location.click();
		location.addLocationBtn.click();
		CommonMethods.sendText(addLocation.name,officeName);
		CommonMethods.click(addLocation.country);
		CommonMethods.selectList(addLocation.listOfCountry, countryName);
		CommonMethods.click(addLocation.state);
		CommonMethods.selectList(addLocation.listOfState, stateName);
		CommonMethods.sendText(addLocation.city, cityName);
		CommonMethods.sendText(addLocation.zipCode, zipCode);
		CommonMethods.click(addLocation.saveBtn);
		
		
	}
	@DataProvider(name="LocationDetails")
	public Object[][] dataFromExcel(){
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.ORANGE_XL_FILEPATH, "LocationDetails");
		
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i-1][j]=obj.getCellData(i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name="addLocationData")
	public Object[][] addLocationData(){
		Object[][] data=new Object[5][5];
		data[0][0]="West Office";
		data[0][1]="United States";
		data[0][2]="Alabama";
		data[0][3]="city1";
		data[0][4]="45678";
		
		
		data[1][0]="Smart Office";
		data[1][1]="United States";
		data[1][2]="Texas";
		data[1][3]="city2";
		data[1][4]="45689";
		
		data[2][0]="North Office";
		data[2][1]="United States";
		data[2][2]="Alaska";
		data[2][3]="city3";
		data[2][4]="67678";
		
		data[3][0]="Blue Office";
		data[3][1]="United States";
		data[3][2]="Arkansas";
		data[3][3]="city4";
		data[3][4]="78678";
		
		data[4][0]="Red Office";
		data[4][1]="United States";
		data[4][2]="Colorado";
		data[4][3]="city5";
		data[4][4]="45678";
		
		
		return data;
	}
	
}
