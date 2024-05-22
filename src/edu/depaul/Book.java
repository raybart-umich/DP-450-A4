package edu.depaul;

public class Book implements Product {
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public void addToCart() {
		System.out.println(name + " has been added to cart.");
	}
	
	@Override
	public void removeFromCart() {
		System.out.println(name + " has been removed from cart.");
	}
}
