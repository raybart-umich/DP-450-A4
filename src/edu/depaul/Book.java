package edu.depaul;

public class Book implements Product {
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

}
