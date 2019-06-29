package com.syntax.practice;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	@Test
	public void writeExcelfile() throws IOException {
		String filePath = "src/test/resources/testData/OrangeHrmData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		// open workbook & sheet
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("EmployeeDetails");

		// write some values
		sheet.getRow(0).createCell(4).setCellValue("Result");
		sheet.getRow(1).createCell(4).setCellValue("pass");
		sheet.getRow(1).getCell(4).setCellValue("fail");
		sheet.createRow(11).createCell(0).setCellValue("gamze");

		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
		workbook.close();
		fis.close();

	}
}
