package com.tklearning.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tklearning.model.Friends;

public class ExcelService {
	
	public List<Friends> getAllFriendList(){
		
		List<Friends> allFriendsList = new ArrayList<Friends>();
		 try
	        {
			 	System.out.println("Reading excel data");
	            FileInputStream file = new FileInputStream(new File("D:\\java\\workspace\\ProjectBirthday\\FriendList.xlsx"));
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();       
	            //TODO use count to skip first row iteration to skip excel headers entering the friends list 
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                 
	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                    
	                    //todo read excel values and add to friends object. then add that object to friends list
	                    switch (cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + "t");
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                            System.out.print(cell.getStringCellValue() + "t");
	                            break;
	                    }
	                }
	                System.out.println("");
	            }
	            file.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    
		return allFriendsList;
	}

}
