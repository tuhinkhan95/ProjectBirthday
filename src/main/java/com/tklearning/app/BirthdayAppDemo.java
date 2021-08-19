package com.tklearning.app;

import java.util.List;

import com.tklearning.model.Friends;
import com.tklearning.service.ExcelService;

public class BirthdayAppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Read from Excel and get all friend list
		ExcelService excelService = new ExcelService();
		List<Friends> allFreindList = excelService.getAllFriendList();
		
		//Get friends with birthday in the current data
		//TODO
		
		//Send mail from mailService
	}

}
