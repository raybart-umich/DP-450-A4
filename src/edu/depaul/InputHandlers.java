package edu.depaul;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandlers {

	public static User inputSignInUser(Scanner reader, UserDirectory users) {
		System.out.print("Enter your username: ");
		String inputUsername = reader.nextLine();
		
		System.out.print("Enter your password: ");
		String inputPassword = reader.nextLine();
		
		User newUser= users.signIn(inputUsername, inputPassword);
		
		Logger.log("User " + newUser.getUsername() + " signed in.");
		return newUser;
	}
	
	public static User inputCreateNewUser(Scanner reader, UserDirectory users, boolean inputAdmin) {
		System.out.print("Enter new username: ");
		String inputUsername = reader.nextLine();
		
		System.out.print("Enter new password: ");
		String inputPassword = reader.nextLine();
		
		User newUser= new User(inputUsername, inputPassword, inputAdmin);
		users.addUser(newUser);

		Logger.log("User " + newUser.getUsername() + " created.");
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
		Logger.log("User " + inputUsername + " removed.");
	}
	
	public static Product inputCreateProduct(Scanner reader, ProductCatalog catalog) {
		System.out.print("Enter type for new product: ");
		String inputType = reader.nextLine();

		System.out.print("Enter name for new product: ");
		String inputName = reader.nextLine();

		System.out.print("Enter price for new product: ");
		double inputPrice = Double.parseDouble(reader.nextLine());

		Product newProduct = ProductFactory.getProduct(inputType, inputName, inputPrice);
		if (newProduct == null) {
			throw new InputMismatchException("Invalid product type.");
		}
		catalog.addProduct(newProduct);
		
		Logger.log("Product " + newProduct.getName() + " added to catalog.");
		return newProduct;
	}
	
	public static Product inputRemoveProduct(Scanner reader, ProductCatalog catalog) {
		System.out.print("Enter name of product to be removed: ");
		String inputName = reader.nextLine();

		Logger.log("Product " + inputName + " added to catalog.");
		return catalog.removeProduct(inputName);
	}
	
	public static Product inputGetProduct(Scanner reader, ProductCatalog catalog) {
		System.out.print("Enter product name: ");
		String inputName = reader.nextLine();
		
		return catalog.getProduct(inputName);
	}
	
	public static void inputCheckout(Scanner reader, User currentUser, ShoppingCart cart) {
		System.out.println("Checking out. Cart contents:");
		cart.printCart();
		
		System.out.print("\nTotal cost: $" + cart.getTotal() + "\n");

		System.out.print("Enter credit card number: ");
		String inputCreditCard = reader.nextLine();
		if (!inputCreditCard.matches("\\d{16}")) {
			throw new InputMismatchException("Invalid credit card number.");
        }
		
		System.out.print("Enter expiration date (MM/YY): ");
		String inputExpirationDate = reader.nextLine();
		if (!inputExpirationDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
			throw new InputMismatchException("Invalid expiration date.");
        }
		
		System.out.print("Enter 4 digit PIN: ");
		String inputPin = reader.nextLine();
		if (!inputPin.matches("\\d{4}")) {
			throw new InputMismatchException("Invalid PIN.");
        }
		
		cart.clearCart();
		currentUser.saveCart();
		
		Logger.log("User " + currentUser.getUsername() + " checked out their cart.");
		System.out.println("Payment successful. Your order has been placed.");
	}
}
