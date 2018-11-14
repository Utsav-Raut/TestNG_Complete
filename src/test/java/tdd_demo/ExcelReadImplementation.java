package tdd_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadImplementation {
	
	public static File src; 
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static HSSFWorkbook hwb;
	public static HSSFSheet hsheet;
	
	public static Row row;
	public static Cell cell;
	
	public String[][] getCellData(String filePath, String fileName, int sheetNum) throws IOException{
		src = new File(filePath + "/" + fileName);
		fis = new FileInputStream(src);
		String data[][] = new String[2][2];
		String fileExtension = fileName.substring(fileName.indexOf("."));
		System.out.println("The extension is: " +fileExtension);
		if(fileExtension.equalsIgnoreCase(".xlsx")) {
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetNum);
			
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println("Total number of rows in the sheet is: " + (rowCount+1));
			
			for(int i=1; i<=rowCount; i++) {
				row = sheet.getRow(i);
				
				int cellNum = row.getLastCellNum();
				System.out.println("Number of columns in row " + i + " is = " + cellNum);
				
				for(int j=0; j<cellNum; j++) {
					System.out.println(row.getCell(j) + " || ");
//					if(row.getCell(j).getCell != CellType.STRING) {
//						continue;
//					} else {
						data[i-1][j] = row.getCell(j).toString();
//					}
				}
				System.out.println();
			}
			
		}
		
		else if(fileExtension.equalsIgnoreCase(".xls")) {
			
			hwb = new HSSFWorkbook(fis);
			hsheet = hwb.getSheetAt(sheetNum);
			
			int rowCount = hsheet.getLastRowNum() - hsheet.getFirstRowNum();
			System.out.println("The number of rows in the sheet are: " + (rowCount + 1));
			
			for(int i=1; i<=rowCount; i++) {
				row = hsheet.getRow(i);
				
				int cellNum = row.getLastCellNum();
				System.out.println("Number of columns in row " + i + " are= " +cellNum);
				
				for(int j=0; j<cellNum; j++) {
					System.out.println(row.getCell(j) + " || ");
//					if(row.getCell(j).getCellType() != CellType.STRING) {
//						continue;
//					} else {
						data[i-1][j] = row.getCell(j).toString();
//					}
				}
				System.out.println();
				
			}
		}
		
		return data;
		
	}

}
