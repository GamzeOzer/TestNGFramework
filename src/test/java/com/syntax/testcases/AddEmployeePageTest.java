package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddEmployeePageTest extends BaseClass {

	@Test(dataProvider = "employee details",groups="regression")
	public void addEmployee(String fName, String mName, String lName, String location) throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddEmployeePage addEmp = new AddEmployeePage();
		// login to the OrangeHRM
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		// navigate to add Employee
		CommonMethods.click(home.pim);
		CommonMethods.click(home.addEmployee);
		// enter employee details
		CommonMethods.sendText(addEmp.firstName, fName);
		CommonMethods.sendText(addEmp.middleName, mName);
		CommonMethods.sendText(addEmp.lastName, lName);
		CommonMethods.click(addEmp.location);
		CommonMethods.selectList(addEmp.locationList, location);
		CommonMethods.click(addEmp.saveBtn);
		// verify employee is added
		CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
		String verifText = addEmp.empCheck.getText();
		System.out.println(verifText);
		AssertJUnit.assertEquals(verifText, fName + " " + lName);
	}

	@DataProvider(name = "employee details")
	public Object[][] getData() {

		Object[][] data = new Object[3][4];
		// 1 set
		data[0][0] = "John";
		data[0][1] = "Snow";
		data[0][2] = "White";
		data[0][3] = "HQ";
		// 2 set
		data[1][0] = "Jane";
		data[1][1] = "Rain";
		data[1][2] = "Yellow";
		data[1][3] = "West Office";
		// 3 set
		data[2][0] = "Arya";
		data[2][1] = "Sunny";
		data[2][2] = "Blue";
		data[2][3] = "North Office";
		return data;
	}

	@DataProvider(name = "Employee Data")
	public Object[][] getEmpData() {
		ExcelUtility obj = new ExcelUtility();
		obj.openExcel(Constants.ORANGE_XL_FILEPATH, "EmployeeDetails");
		int rows = obj.getRowNum();
		int cols = obj.getColNum(0);
		//we did row-1 because we didint include the header
		Object[][] data = new Object[rows-1][cols];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				//burada i-1 dedik cunku 0,0 a assign ediyoruz
				data[i-1][j] = obj.getCellData(i, j);
			}
		}
		
		return data;
	}
}
