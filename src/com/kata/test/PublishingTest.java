package com.kata.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class PublishingTest {

		
	@Test
	public void singleUserSenarioTest() throws InterruptedException, ParseException {
		
		System.out.println();
		System.out.println("------------------Single user test----------------------");
		//create a user
		KataUser kataUserAlice = new KataUser("Alice");
		System.out.println("User created : " + kataUserAlice.getUserName());
		
		//publish message
		String userMsg = "I Love weather today.";
		kataUserAlice.publishMessage(userMsg);
		System.out.println(kataUserAlice.getUserName() + " published message 1 : " + userMsg);

		System.out.println("sleep for 5 seconds....");
		TimeUnit.SECONDS.sleep(5);
		
		String userMsg2 = "I Love weather today this afternoon.";
		System.out.println(kataUserAlice.getUserName() + " published message 2 : " + userMsg2);
		kataUserAlice.publishMessage(userMsg2);

		TimeUnit.SECONDS.sleep(5);
		
		System.out.println(kataUserAlice.getUserName() + " viewing her timeline after 10 seconds....");
		
		System.out.println("----------------------------------------------------------");
		System.out.println("Personal Timeline for : " + kataUserAlice.getUserName());
		//view time line
		HashMap<String, String> userTimeLine = kataUserAlice.getTimeLine();
		
		for (String i : userTimeLine.keySet()) {
			  System.out.println("	" + i + userTimeLine.get(i));
			}
		
		System.out.println("----------------------------------------------------------");
	}
	
	@Test
	public void singleUserFollowAnotherUser() throws InterruptedException, ParseException {
		System.out.println();
		System.out.println("------------------Single user follow another user----------------------");
		//users created
		KataUser kataUserAlice = new KataUser("Alice");
		System.out.println("User created : " + kataUserAlice.getUserName());
		
		KataUser kataUserBob = new KataUser("Bob");
		System.out.println("User created : " + kataUserBob.getUserName());
		
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Alice added Bob's Timeline as a follower....");
		kataUserAlice.followUser(kataUserBob);
		
		System.out.println("----------------------------------------------------------");
		
		//user Alice publish message
		String userMsg = "I Love weather today.";
		kataUserAlice.publishMessage(userMsg);
		System.out.println(kataUserAlice.getUserName() + " published message 1 : " + userMsg);
		
		
		//Alice follow user Bob
		String bobMessage1 = "Darn! We lost!";
		kataUserBob.publishMessage(bobMessage1);
		System.out.println(kataUserBob.getUserName() + " published message 1 : " + bobMessage1);
		
		System.out.println("sleep for 5 seconds....");
		TimeUnit.SECONDS.sleep(5);
		
		String bobMessage2 = "Good game though.";
		kataUserBob.publishMessage(bobMessage2);
		System.out.println(kataUserBob.getUserName() + " published message 2 : " + bobMessage2);
		
		TimeUnit.SECONDS.sleep(5);
		
		System.out.println("Alice viewing Bob's timeline afrer 5 seconds..");
		
		System.out.println("----------------------------------------------------------");
		Vector<KataUser> followedUsers = kataUserAlice.getFollowedUsers();
		Enumeration<KataUser> vEnum = followedUsers.elements();
		while(vEnum.hasMoreElements()) {

			KataUser userObj = (KataUser) vEnum.nextElement();			
			HashMap<String, String> userTimeLine = userObj.getTimeLine();
			for (String i : userTimeLine.keySet()) {
				  System.out.println("	" + i + userTimeLine.get(i));
				}
	   } 
				
	}
		
	@Test
	public void userfollowTwoUsersTest() throws InterruptedException, ParseException {
		
		System.out.println();
		System.out.println("------------------Single user follow 2 users----------------------");
		
		KataUser kataUserAlice = new KataUser("Alice");
		System.out.println("User created : " + kataUserAlice.getUserName());
		
		KataUser kataUserBob = new KataUser("Bob");
		System.out.println("User created : " + kataUserBob.getUserName());
		
		KataUser kataUserCharlie = new KataUser("Charlie");
		System.out.println("User created : " + kataUserCharlie.getUserName());
		
		System.out.println("----------------------------------------------------------");
		System.out.println("Charlie following Alice....");
		kataUserCharlie.followUser(kataUserAlice);
		
		System.out.println("Charlie following Bob....");
		kataUserCharlie.followUser(kataUserBob);
		
		System.out.println("----------------------------------------------------------");
		
		//user Alice publish message
		String userMsg = "I Love weather today.";
		kataUserAlice.publishMessage(userMsg);
		System.out.println(kataUserAlice.getUserName() + " published message : " + userMsg);
		TimeUnit.SECONDS.sleep(2);
		
		String bobMessage1 = "Darn! We lost!";
		kataUserBob.publishMessage(bobMessage1);
		System.out.println(kataUserBob.getUserName() + " published message : " + bobMessage1);
		TimeUnit.SECONDS.sleep(2);
		
		String bobMessage2 = "Good game though.";
		kataUserBob.publishMessage(bobMessage2);
		System.out.println(kataUserBob.getUserName() + " published message : " + bobMessage2);
		TimeUnit.SECONDS.sleep(2);
		
		String charlieMsg1 = "I'm in New York today! Anyone wants to have a coffee?";
		kataUserCharlie.publishMessage(charlieMsg1);
		System.out.println(kataUserCharlie.getUserName() + " published message : " + charlieMsg1);
		
		TimeUnit.SECONDS.sleep(2);
		
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Charlie viewing his wall...");
		
		HashMap<String, String> charlieTimeLine = kataUserCharlie.getTimeLine();
		for (String i : charlieTimeLine.keySet()) {
			  System.out.println("	" + kataUserCharlie.getUserName() + " - " + i + charlieTimeLine.get(i));
			}
		
		Vector<KataUser> followedUsers = kataUserCharlie.getFollowedUsers();
		Enumeration<KataUser> vEnum = followedUsers.elements();
		while(vEnum.hasMoreElements()) {
			KataUser userObj = (KataUser) vEnum.nextElement();			
			HashMap<String, String> userTimeLine = userObj.getTimeLine();
			for (String i : userTimeLine.keySet()) {
				  System.out.println("	" + userObj.getUserName() + " - " + i + userTimeLine.get(i));
				}
		} 
		
		System.out.println("----------------------------------------------------------");
		
		
	}

}
