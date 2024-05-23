package edu.depaul;

import java.util.ArrayList;

public class UserDirectory {
	private static UserDirectory instance;
	private ArrayList<User> users;
 
	private UserDirectory() {
		users = new ArrayList<User>();
		users.add(new User("admin", "password123", true));
		users.add(new User("customer", "password123", false));
	}

	public static UserDirectory getInstance() {
		if (instance == null) {
			instance = new UserDirectory();
		}
		return instance;
	}

	public User signIn(String username, String password) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).getPassword().equalsIgnoreCase(password)) {
				return users.get(i);
			}
		}
		return null;
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
			System.out.println("No users are signed up.");
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
	}

}
