package edu.depaul;

public class ProductFactory {

	public static Product getProduct(String type, String name, double price) {
		if (type.equalsIgnoreCase("book")) {
			return new Book(name, price);
		}
		else if (type.equalsIgnoreCase("computer")) {
			return new Computer(name, price);
		}
		else if (type.equalsIgnoreCase("shirt")) {
			return new Shirt(name, price);
		}
		return null;
	}
}
