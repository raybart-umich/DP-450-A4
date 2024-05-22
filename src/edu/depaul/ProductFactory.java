package edu.depaul;

public class ProductFactory {

	public static Product getProduct(String type, String name, double price) {
		if (type.equalsIgnoreCase("book")) {
			return new Book(name, price);
		}
		return null;
	}
}
