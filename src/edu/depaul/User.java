package edu.depaul;

import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private ArrayList<Product> savedCart;
	private boolean admin;

	public User(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.savedCart = new ArrayList<Product>();
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Product> getCart() {
		return savedCart;
	}
	
	public void setCart(ArrayList<Product> cart) {
		this.savedCart = cart;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public void saveCart() {
		ShoppingCart cart = ShoppingCart.getInstance();
		savedCart = new ArrayList<Product>(cart.getCartProducts());
	}
	
	public void loadCart() {
		ShoppingCart cart = ShoppingCart.getInstance();
		cart.setCartProducts(new ArrayList<Product>(savedCart));
	}

	public String toString() {
		return "Username: " + this.getUsername() +
				"\nAdmin: " + this.isAdmin(); 
	}

}
