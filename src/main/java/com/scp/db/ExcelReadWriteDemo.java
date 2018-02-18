package com.scp.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWriteDemo {
	static Object[][] data = new Object[4][3];

	public static Object[][] getTestData(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\demo.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("UserData");
		Iterator<Row> rows = sheet.iterator();
		int cnt=0;
		int index=0;
		int record=0;

		while(rows.hasNext()){
			
			if(0==cnt){
				rows.next();
				cnt++;
				continue;
			}
			Row row = rows.next();
			
			Iterator<Cell> cells = row.cellIterator();
					
			while(cells.hasNext()){
				Cell cell = cells.next();
				if(index==0){
					data[record][index]= cell.getStringCellValue(); //uname
					index++;
				}else if (index ==1){
					data[record][index]= cell.getStringCellValue();//password
					index++;
				}else {
					data[record][index]= cell.getStringCellValue();//ex
					index=0;
					record++;
				}
				
			}
		}
		
		
		Arrays.toString(data);
		return data;
	}
	
	
	public static void main(String[] args) throws IOException {
		getTestData();
	}
	
}
