package edu.depaul;

import java.util.Scanner;

public class InputHandlers {

	public static User inputSignInUser(Scanner reader, UserDirectory users) {
		System.out.println("Enter your username: ");
		String inputUsername = reader.next();
		
		System.out.println("Enter your password: ");
		String inputPassword = reader.next();
		
		User newUser= users.signIn(inputUsername, inputPassword);
		return newUser;
	}
	
	public static User inputCreateNewUser(Scanner reader, UserDirectory users, boolean inputAdmin) {
		System.out.println("Enter new username: ");
		String inputUsername = reader.next();
		
		System.out.println("Enter new password: ");
		String inputPassword = reader.next();
		
		User newUser= new User(inputUsername, inputPassword, inputAdmin);
		users.addUser(newUser);

		return newUser;
	}

	public static void inputRemoveUser(Scanner reader, UserDirectory users, String currentUsername) {
		System.out.println("Enter username for user to be deleted: ");
		String inputUsername = reader.next();
		
		if (inputUsername.equalsIgnoreCase(currentUsername)) {
			System.out.println("Cannot delete account of current user.");
			return;
		}
		users.removeUser(inputUsername);
	}
	
	public static void inputCreateProduct(Scanner reader, ProductCatalog catalog) {
		System.out.println("Enter type for new product: ");
		String inputType = reader.next();

		System.out.println("Enter name for new product: ");
		String inputName = reader.next();

		System.out.println("Enter price for new product: ");
		double inputPrice = reader.nextDouble();

		Product newProduct =ProductFactory.getProduct(inputType, inputName, inputPrice);
		catalog.addProduct(newProduct);
	}
	
	public static void inputRemoveProduct(Scanner reader, ProductCatalog catalog) {
		System.out.println("Enter name of product to be removed: ");
		String inputName = reader.next();

		catalog.removeProduct(inputName);
	}
	
	public static Product inputGetProduct(Scanner reader, ProductCatalog catalog) {
		System.out.println("Enter product name: ");
		String inputName = reader.next();
		
		return catalog.getProduct(inputName);
	}
	
}
