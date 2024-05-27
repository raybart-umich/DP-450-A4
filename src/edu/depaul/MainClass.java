package edu.depaul;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainClass {

	public static void main(String[] args) {
		UserDirectory users = UserDirectory.getInstance();
		ProductCatalog catalog = ProductCatalog.getInstance();

		User currentUser = null;
		Scanner reader = new Scanner(System.in);

		// Program
		while (true) {
			try {
				if (currentUser == null) {
					System.out.println("----------------------------------------"
							+ "\nSelect from the following options: "
							+ "\n1) Sign in to an existing account" 
							+ "\n2) Create a new account"
							);
					int selection = Integer.parseInt(reader.nextLine());

					if (selection == 1) {
						currentUser = InputHandlers.inputSignInUser(reader, users);
					}
					else if (selection == 2) {
						currentUser = InputHandlers.inputCreateNewUser(reader, users, false);
					}
					if (currentUser == null) {
						throw new InputMismatchException();
					}
					System.out.println("Signed in as " + currentUser.getUsername() + ".");
				}

				ShoppingCart currentUserCart = ShoppingCart.getInstance();
				currentUserCart.setCartProducts(currentUser.getCart());

				System.out.println("\n----------------------------------------"
						+ "\nSelect from the following options: "
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
						+ "\n11) Clear log"
						);
				}
				int selection = Integer.parseInt(reader.nextLine());

				if (selection == 1) {
					catalog.printProductCatalog();
				}
				else if (selection == 2) {
					currentUserCart.printCart();
				}
				else if (selection == 3) {
					currentUserCart.addProductToCart(InputHandlers.inputGetProduct(reader, catalog));
				}
				else if (selection == 4) {
					currentUserCart.removeProductFromCart(InputHandlers.inputGetProduct(reader, catalog));
				}
				else if (selection == 5) {
					InputHandlers.inputCheckout(reader, currentUser, currentUserCart);
				}
				else if (selection == 6) {
					currentUser.saveCart();
					currentUserCart.clearCart();
					currentUser = null;
				}

				// admin only
				else if (currentUser.isAdmin()) {
					if (selection == 7) {
						InputHandlers.inputCreateProduct(reader, catalog);
					}
					else if (selection == 8) {
						InputHandlers.inputRemoveProduct(reader, catalog);
					}
					else if (selection == 9) {
						InputHandlers.inputCreateNewUser(reader, users, true);
					}
					else if (selection == 10) {
						InputHandlers.inputRemoveUser(reader, users, currentUser.getUsername());
					}
					else if (selection == 11) {
						Logger.clearLog();
					}
					else {
						System.out.println("Invalid input. Please try again.");
					}
				}

				else {
					System.out.println("Invalid input. Please try again.");
				}

			} catch (InputMismatchException e) {
	            System.out.println("Invalid input.");
	            System.out.println("\n");
	            reader.nextLine(); // clear scanner buffer
	        }
		}
	}

}
