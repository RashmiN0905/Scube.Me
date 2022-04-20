package genericUtility;
/***
 * 
 * @author Rashmi
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String ExcelPath = "./src/test/resources/v_Tiger_data.xlsx";
	public File file = new File(ExcelPath);
	public Workbook workbook = null;
	
	
/**
 * 
 * @param sheetName 
 * @param rowNumber
 * @param cellNumber
 * @return
 */
	public double readNumberDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
		
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
	}
	
	public String readStringDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
		
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	} 
	
	public boolean readBooleanDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
		
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getBooleanCellValue();
	}

	public String[][] readMultipleDataFromExcel(String sheetName) {
		
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		int rowNumber = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		int cellNumber = workbook.getSheet(sheetName).getRow(rowNumber).getPhysicalNumberOfCells();
		
		String[][] data = new String[rowNumber][cellNumber];
		for(int i=0; i<rowNumber; i++) {
			for(int j=0; j<cellNumber; j++) {
				data[i][j]= workbook.getSheet(sheetName).getRow(i).getCell(j).toString();
			}
		}
		return  data;
	
	}
}
