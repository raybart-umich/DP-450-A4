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
	
	public static User createNewUser(Scanner reader, UserDirectory users) {
		System.out.println("Enter new username: ");
		String inputUsername = reader.next();
		
		System.out.println("Enter new password: ");
		String inputPassword = reader.next();
		
		System.out.println("Is the new user an admin account? ('true' or 'false'): ");
		boolean inputAdmin = reader.nextBoolean();
		
		User newUser= new User(inputUsername, inputPassword, inputAdmin);
		users.addUser(newUser);

		return newUser;
	}
}
	
