package edu.depaul;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainClass {

	public static void main(String[] args) {
		UserDirectory users = UserDirectory.getInstance();
		ProductFactory productFactory = new ProductFactory();
		User currentUser = null;

		Scanner reader = new Scanner(System.in);

		// Program
		while (true) {
			try {
				if (currentUser == null) {
					System.out.println("Select from the following options: "
							+ "\n1) Sign in to an existing account" 
							+ "\n2) Create a new account"
							);
					int selection = reader.nextInt();
					
					if (selection == 1) {
						currentUser = InputHandlers.signInUser(reader, users);
					}
					else if (selection == 2) {
						currentUser = InputHandlers.createNewUser(reader, users);
					}
					if (currentUser == null) {
						throw new InputMismatchException();
					}
					System.out.println("Signed in as " + currentUser.getUsername() + ".");
				}

				System.out.println("Select from the following options: "
						+ "\n1) Sign out"
						+ "\n2) View product catalog"
						);
				int selection = reader.nextInt();
				
				if (selection == 1) {
					currentUser = null;
				}
				else if (selection == 2) {
					
				}
			} catch (InputMismatchException e) {
	            System.out.println("Invalid input.");
	            System.out.println("\n");
	            reader.nextLine(); // clear scanner buffer
	        }
		}
	}

}
