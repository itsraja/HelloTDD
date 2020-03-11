package com.kata.test;

import java.util.Vector;

public class KataUserFollow {
	
	String m_userName;
	Vector<KataUser> m_userFollowers = new Vector<KataUser>();
	
	KataUserFollow() {
		
	}

	KataUserFollow(String strUserID) {
		m_userName = strUserID;
	}
	
	public void followUser(KataUser objUser) {
		m_userFollowers.addElement(objUser);
	}
	
	public Vector<KataUser> getFollowedUsers() {
		return m_userFollowers;
	}
}
