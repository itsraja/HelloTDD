package com.kata.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class KataUser {

	String m_strUsrName;
	HashMap<String,String> mapUserTimeLine;
	KataUserFollow m_followUsers;
	
	KataUser() {
		
	}
	
	KataUser(String strUserID) {
		m_strUsrName = strUserID;
		mapUserTimeLine = new HashMap<String,String>();
		m_followUsers =  new KataUserFollow(strUserID);
	}

	public void publishMessage(String strMessage) {
		
		LocalDateTime dateObj = LocalDateTime.now();
		DateTimeFormatter strformatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		
		String formattedDate = dateObj.format(strformatObj);
		
		mapUserTimeLine.put(formattedDate,strMessage);
		
	}

	public HashMap<String,String> getTimeLine() throws ParseException {

		HashMap<String,String> updatedTimeLine = new HashMap<String,String>();
		
		for (String i : mapUserTimeLine.keySet()) {
			
				LocalDateTime dateObj = LocalDateTime.now();
				DateTimeFormatter strformatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
				String formattedDatenow = dateObj.format(strformatObj);
				
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				
				Date dtNow = null;
				Date dtRecordTimestamp = null;
				
				dtNow = format.parse(formattedDatenow);
				dtRecordTimestamp = format.parse(i);
				
				long diff = dtNow.getTime() - dtRecordTimestamp.getTime();
				long diffSeconds = diff / 1000 % 60;
				
				String strTimeLine = "(" + diffSeconds+ " seconds ago)"; 
				
				updatedTimeLine.put( mapUserTimeLine.get(i), strTimeLine);
			
			}
		
		return updatedTimeLine;
	}

	public String getUserName() {
		return m_strUsrName;
	}

	public void followUser(KataUser objKataUser) {
		m_followUsers.followUser(objKataUser);
	}

	public Vector<KataUser> getFollowedUsers() {
		// TODO Auto-generated method stub
		return m_followUsers.getFollowedUsers();
	}
	
	
}
