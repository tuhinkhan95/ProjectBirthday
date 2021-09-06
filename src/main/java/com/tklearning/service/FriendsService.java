package com.tklearning.service;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.tklearning.model.Friends;

public class FriendsService {
	public List<Friends> getAllBday(List<Friends> allFreindList){
		List<Friends> allBDay=new ArrayList<Friends>();
		for(Friends friend: allFreindList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
			String friendDob=friend.getDob();
			LocalDate date = LocalDate.parse(friendDob, formatter);
			LocalDate currentLocalDate =LocalDate.now();
			if(date.compareTo(currentLocalDate)==0) {     
				allBDay.add(friend);
			}
		}
		return allBDay;
	}

}
