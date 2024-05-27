package edu.depaul;

import java.util.Scanner;

public class InputHandlers {

	public static User inputSignInUser(Scanner reader, UserDirectory users) {
		System.out.print("Enter your username: ");
		String inputUsername = reader.nextLine();
		
		System.out.print("Enter your password: ");
		String inputPassword = reader.nextLine();
		
		User newUser= users.signIn(inputUsername, inputPassword);
		return newUser;
	}
	
	public static User inputCreateNewUser(Scanner reader, UserDirectory users, boolean inputAdmin) {
		System.out.print("Enter new username: ");
		String inputUsername = reader.nextLine();
		
		System.out.print("Enter new password: ");
		String inputPassword = reader.nextLine();
		
		User newUser= new User(inputUsername, inputPassword, inputAdmin);
		users.addUser(newUser);

		return newUser;
	}

	public static void inputRemoveUser(Scanner reader, UserDirectory users, String currentUsername) {
		System.out.print("Enter username for user to be deleted: ");
		String inputUsername = reader.nextLine();
		
		if (inputUsername.equalsIgnoreCase(currentUsername)) {
			System.out.println("Cannot delete account of current user.");
			return;
		}
		users.removeUser(inputUsername);
	}
	
	public static Product inputCreateProduct(Scanner reader, ProductCatalog catalog) {
		System.out.print("Enter type for new product: ");
		String inputType = reader.nextLine();

		System.out.print("Enter name for new product: ");
		String inputName = reader.nextLine();

		System.out.print("Enter price for new product: ");
		double inputPrice = Double.parseDouble(reader.nextLine());

		Product newProduct =ProductFactory.getProduct(inputType, inputName, inputPrice);
		catalog.addProduct(newProduct);
		
		return newProduct;
	}
	
	public static Product inputRemoveProduct(Scanner reader, ProductCatalog catalog) {
		System.out.print("Enter name of product to be removed: ");
		String inputName = reader.nextLine();

		return catalog.removeProduct(inputName);
	}
	
	public static Product inputGetProduct(Scanner reader, ProductCatalog catalog) {
		System.out.print("Enter product name: ");
		String inputName = reader.nextLine();
		
		return catalog.getProduct(inputName);
	}
	
	public static void inputCheckout(Scanner reader, User user, ShoppingCart cart) {
		System.out.println("Checking out. Cart contents:");
		cart.printCart();
		
		System.out.print("\nTotal cost: " + cart.getTotal() + "\n");

		System.out.print("Enter credit card number: ");
		int inputCreditCard = Integer.parseInt(reader.nextLine());
		
		System.out.print("Enter expiration date (MM/YY): ");
		String inputExpirationDate = reader.nextLine();
		
		System.out.print("Enter 4 digit PIN: ");
		int inputPin = Integer.parseInt(reader.nextLine());
		
		user.saveCart();
		cart.clearCart();
		System.out.println("Payment successful. Your order has been placed.");
	}
}
