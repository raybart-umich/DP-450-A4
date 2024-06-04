package edu.depaul;

import java.util.ArrayList;

public class ShoppingCart {
	private static ShoppingCart instance;
	private ArrayList<Product> cart;

	private ShoppingCart() {
		this.cart = new ArrayList<Product>();
	}

	public static ShoppingCart getInstance() {
		if (instance == null) {
			instance = new ShoppingCart();
		}
		return instance;
	}

	public void addProductToCart(Product product) {
		cart.add(product);
	}

	public void removeProductFromCart(Product product) {
		cart.remove(product);
	}

	public ArrayList<Product> getCartProducts() {
		return cart;
	}

	public void setCartProducts(ArrayList<Product> products) {
		this.cart = products;
	}

	public void printCart() {
		if (cart.size() == 0) {
			System.out.println("Your shopping cart is empty.");
		}
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i).getName() + ": $" + cart.get(i).getPrice());
		}
	}

	public double getTotal() {
		double total = 0;
		for (int i = 0; i < cart.size(); i++) {
			total += cart.get(i).getPrice();
		}
		return total;
	}

	public void clearCart() {
		cart.clear();
	}

}
