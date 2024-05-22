package edu.depaul;

import java.util.ArrayList;

public class UserDirectory {
	private static UserDirectory instance;
	private ArrayList<User> users;
 
	private UserDirectory() {
		users = new ArrayList<User>();
	}

	public static UserDirectory getInstance() {
		if (instance == null) {
			instance = new UserDirectory();
		}
		return instance;
	}
	
	public Boolean empty() {
		return users.size() == 0;
	}

	public void addUser(User user) {
		users.add(user);
		System.out.println("User " + user.getUsername() + " signed up.");
	}

	public void removeUser(User user) {
		users.remove(user);
		System.out.println("User " + user.getUsername() + " removed.");
	}

	public void printUsers() {
		if (users.size() == 0) {
			System.out.println("No usersare signed up.");
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
	}

}
