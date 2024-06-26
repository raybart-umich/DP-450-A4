package edu.depaul;

import java.util.ArrayList;
import java.util.InputMismatchException;

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
		throw new InputMismatchException("Username or password incorrect.");
	}

	public void addUser(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equalsIgnoreCase(user.getUsername())) {
				throw new InputMismatchException("Username already taken.");
			}
		}
		users.add(user);
		System.out.println("User " + user.getUsername() + " signed up.");
	}

	public void removeUser(String username) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equalsIgnoreCase(username)) {
				users.remove(users.get(i));
				System.out.println("User " + username + " removed.");
				return;
			}
		}
		System.out.println("User " + username + " not found.");
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
