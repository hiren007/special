package com.test.excelreader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelFileReader() throws IOException {
		fis = new FileInputStream("C:\\Users\\Hiren Gajera\\eclipse-workspace\\SiteWon1\\Resource\\Book1.xlsx");
		workbook = new XSSFWorkbook(fis);
	}

	public String getCellData(int worksheet, int rowNum, int cellNum) {
		sheet = workbook.getSheetAt(worksheet);
		DataFormatter formatter = new DataFormatter();
		Cell cell = sheet.getRow(rowNum).getCell(cellNum);
		String cellValue = formatter.formatCellValue(cell);
		return cellValue;
	}
}