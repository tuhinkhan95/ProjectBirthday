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
		int rowCount=0;


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
				int cellCount=0;
				System.out.println("Row Count is "+rowCount);
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if(rowCount>=1) {
					Friends friend=new Friends(); 
					while (cellIterator.hasNext()) 
					{ 
						System.out.println("Cell Count is "+cellCount);
						Cell cell = cellIterator.next();
						//Check the cell type and format accordingly

						//  String name=null;
						//	   String email=null;
						//	   String dob=null; 
						//todo read excel values and add to friends object. then add that object to friends list
						if(cell.getStringCellValue()!=null && cell.getStringCellValue().length()>0) {
							if(cellCount==0) {
								friend.setName(cell.getStringCellValue());
								//		 name=cell.getStringCellValue();
							}else if (cellCount==1 ) {
								friend.setEmail(cell.getStringCellValue());
								//		 email=cell.getStringCellValue();
							}else {
								friend.setDob(cell.getStringCellValue());
								//		 dob=cell.getStringCellValue();
							}
						}
						System.out.println(cell.getStringCellValue() + " "+cell.getStringCellValue().length() +" ******* ");

						//		Friends friends=new Friends(name,email,dob);
						//		allFriendsList.add(friends);
						cellCount++;
					}
					if(friend.getName()!=null && friend.getEmail()!=null && friend.getDob()!=null  ) {
						allFriendsList.add(friend);
					}
				}
				System.out.println("");
				rowCount++;
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
