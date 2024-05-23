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
						currentUser = InputHandlers.createNewUser(reader, users, false);
					}
					if (currentUser == null) {
						throw new InputMismatchException();
					}
					System.out.println("Signed in as " + currentUser.getUsername() + ".");
				}

				System.out.println("\nSelect from the following options: "
						+ "\n1) View product catalog"
						+ "\n2) View shopping cart"
						+ "\n3) Add a product to shopping cart"
						+ "\n4) Remove a product from shopping cart"
						+ "\n5) Check out"
						+ "\n6) Sign out"
						);
				if (currentUser.isAdmin()) {
					System.out.println("\nAdmin options: "
							+ "\n7) Add a product to product catalog"
							+ "\n8) Remove a product from product catalog"
							+ "\n9) Create a new admin user"
							+ "\n10) Delete a user"
							);
				}
				int selection = reader.nextInt();
				
				if (selection == 1) {
					System.out.println("TODO: print product catalog");
				}
				else if (selection == 2) {
					System.out.println("TODO: print shopping cart");
				}
				else if (selection == 3) {
					System.out.println("TODO: add product to shopping cart");
				}
				else if (selection == 4) {
					System.out.println("TODO: remove product from shopping cart");
				}
				else if (selection == 5) {
					System.out.println("TODO: check out");
				}
				else if (selection == 6) {
					currentUser = null;
				}

				// admin only
				else if (currentUser.isAdmin()) {
					if (selection == 7) {
						System.out.println("TODO: add product to catalog");
					}
					else if (selection == 8) {
						System.out.println("TODO: remove product from catalog");
					}
					else if (selection == 9) {
						InputHandlers.createNewUser(reader, users, true);
					}
					else if (selection == 10) {
						InputHandlers.adminRemoveUser(reader, users, currentUser.getUsername());
					}
				}
			} catch (InputMismatchException e) {
	            System.out.println("Invalid input.");
	            System.out.println("\n");
	            reader.nextLine(); // clear scanner buffer
	        }
		}
	}

}
