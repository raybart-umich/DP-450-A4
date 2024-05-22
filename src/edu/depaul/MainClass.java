package edu.depaul;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		UserDirectory users = UserDirectory.getInstance();
		ProductFactory productFactory = new ProductFactory();
		Scanner reader = new Scanner(System.in);

		Product book = ProductFactory.getProduct("book", "temp", 20.5);

		book.addToCart();
	}

}
