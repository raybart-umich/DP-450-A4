package edu.depaul;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

class TestCases {

	@Test
	void testProductCatalog() {
		ProductCatalog catalog = ProductCatalog.getInstance();
		
		// adding a product to catalog
		Product testProduct = ProductFactory.getProduct("book", "java", 15);
		catalog.addProduct(testProduct);
		assert(catalog.getProduct("java") != null);
		
		// adding a duplicate product
		assertThrows(InputMismatchException.class, () -> catalog.addProduct(testProduct));
		
		// removing a product from catalog
		assert(catalog.removeProduct("java") == testProduct);
	}

	@Test
	void testShoppingCart() {
		ProductCatalog catalog = ProductCatalog.getInstance();
		ShoppingCart testCart = ShoppingCart.getInstance();

		Product testProduct = ProductFactory.getProduct("book", "java", 15);
		Product testProduct2 = ProductFactory.getProduct("computer", "dell", 700);
		catalog.addProduct(testProduct);
		catalog.addProduct(testProduct2);

		testCart.addProductToCart(testProduct);
		testCart.addProductToCart(testProduct2);

		// get total
		assert(testCart.getTotal() == 715);

		// remove product
		testCart.removeProductFromCart(testProduct);
		assert(testCart.getTotal() == 700);

		// empty cart
		testCart.removeProductFromCart(testProduct2);
		assert(testCart.getTotal() == 0);
	}

	@Test
	void testOrderProcessingInvalidCreditCard() {
		String invalidCreditCard = "1234\n12/25\n1234\n";
        ByteArrayInputStream in = new ByteArrayInputStream(invalidCreditCard.getBytes());
        Scanner reader = new Scanner(in);

        User testUser = new User("testuser", "password", false);
        ShoppingCart testCart = ShoppingCart.getInstance();

        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> InputHandlers.inputCheckout(reader, testUser, testCart));
        assertEquals("Invalid credit card number.", thrown.getMessage());
	}

	@Test
	void testOrderProcessingInvalidExpirationDate() {
		String invalidExpirationDate = "1234123412341234\n12/2025\n1234\n";
        ByteArrayInputStream in = new ByteArrayInputStream(invalidExpirationDate.getBytes());
        Scanner reader = new Scanner(in);

        User testUser = new User("testuser", "password", false);
        ShoppingCart testCart = ShoppingCart.getInstance();

        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> InputHandlers.inputCheckout(reader, testUser, testCart));
        assertEquals("Invalid expiration date.", thrown.getMessage());
	}

	@Test
	void testOrderProcessingInvalidPin() {
		String invalidPin = "1234123412341234\n12/25\n12345\n";
        ByteArrayInputStream in = new ByteArrayInputStream(invalidPin.getBytes());
        Scanner reader = new Scanner(in);

        User testUser = new User("testuser", "password", false);
        ShoppingCart testCart = ShoppingCart.getInstance();

        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> InputHandlers.inputCheckout(reader, testUser, testCart));
        assertEquals("Invalid PIN.", thrown.getMessage());
	}

}
