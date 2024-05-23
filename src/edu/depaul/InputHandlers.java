package edu.depaul;

import java.util.Scanner;

public class InputHandlers {

	public static User signInUser(Scanner reader, UserDirectory users) {
		System.out.println("Enter your username: ");
		String inputUsername = reader.next();
		
		System.out.println("Enter your password: ");
		String inputPassword = reader.next();
		
		User newUser= users.signIn(inputUsername, inputPassword);
		return newUser;
	}
	
	public static User createNewUser(Scanner reader, UserDirectory users, boolean inputAdmin) {
		System.out.println("Enter new username: ");
		String inputUsername = reader.next();
		
		System.out.println("Enter new password: ");
		String inputPassword = reader.next();
		
		User newUser= new User(inputUsername, inputPassword, inputAdmin);
		users.addUser(newUser);

		return newUser;
	}

	public static void adminRemoveUser(Scanner reader, UserDirectory users, String currentUsername) {
		System.out.println("Enter username for user to be deleted: ");
		String inputUsername = reader.next();
		
		if (inputUsername.equalsIgnoreCase(currentUsername)) {
			System.out.println("Cannot delete account of current user.");
			return;
		}
		users.removeUser(inputUsername);
	}
}
