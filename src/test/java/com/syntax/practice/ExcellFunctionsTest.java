package com.syntax.practice;

import org.testng.annotations.Test;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;;
public class ExcellFunctionsTest {

	@Test
	public void excelTest() {
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.ORANGE_XL_FILEPATH, "EmployeeDetails");
		String value = obj.getCellData(2, 3);
		System.out.println(value);
	
		//retrieve all values from excel and store into Dataprovider
		int row=obj.getRowNum();
		int col=obj.getColNum(0);
		
		Object[][] excelData=new Object[row][col];
		
		for(int i=1;i<row;i++) {
			for(int j=0;j<col;j++) {
				//retrieve data from excell
				String data=obj.getCellData(i, j);
				//store value into row and cell inside two array
				excelData[i][j]=data;
			}
		}
		System.out.println(excelData.length);
	}
}
