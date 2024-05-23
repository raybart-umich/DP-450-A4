package edu.depaul;

public interface Product {
	public String getName();
	public void setName(String name);
	public double getPrice();
	public void setPrice(double Price);

	public void addToCart();
	public void removeFromCart();
}
