package edu.depaul;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product book = ProductFactory.getProduct("book", "temp", 20.5);
		
		book.addToCart();
	}

}
