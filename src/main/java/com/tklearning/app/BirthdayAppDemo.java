package com.tklearning.app;

import java.util.List;

import com.tklearning.model.Friends;
import com.tklearning.service.ExcelService;
import com.tklearning.service.FriendsService;

public class BirthdayAppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Read from Excel and get all friend list
		ExcelService excelService = new ExcelService();
		List<Friends> allFreindList = excelService.getAllFriendList();
		
		
		//Get friends with birthday in the current data
		//TODO
		for(Friends friend:allFreindList) {
			System.out.println(friend.getName()+" "+friend.getEmail()+" "+friend.getDob());
			
		}
		FriendsService friendsService=new FriendsService();
		List<Friends> allBday=friendsService.getAllBday( allFreindList);
		for(Friends friend:allBday) {
			System.out.println(friend.getName());
			System.out.println(friend.getEmail());
		}
		
		//Send mail from mailService
	}

}
