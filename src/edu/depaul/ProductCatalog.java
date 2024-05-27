package edu.depaul;

import java.util.ArrayList;


public class ProductCatalog {
	private static ProductCatalog instance;
	private ArrayList<Product> catalog;
 
	private ProductCatalog() {
		catalog = new ArrayList<Product>();
	}

	public static ProductCatalog getInstance() {
		if (instance == null) {
			instance = new ProductCatalog();
		}
		return instance;
	}
	
	public void printProductCatalog() {
		if (catalog.size() == 0) {
			System.out.println("The product catalog is empty.");
			return;
		}

		for (int i = 0; i < catalog.size(); i++) {
			System.out.println(catalog.get(i).getName() + ": $" + catalog.get(i).getPrice());
		}
	}

	public Product getProduct(String inputProductName) {
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getName().equalsIgnoreCase(inputProductName)) {
				return catalog.get(i);
			}
		}
		System.out.println("Product not found.");
		return null;
	}
	
	public void addProduct(Product product) {
		catalog.add(product);
		System.out.println("Product " + product.getName() + " added to catalog.");
	}
	
	public Product removeProduct(String inputProductName) {
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getName().equalsIgnoreCase(inputProductName)) {
				Product temp = catalog.get(i);
				catalog.remove(i);
				System.out.println("Product " + inputProductName + " removed from catalog.");
				return temp;
			}
		}
		System.out.println("Product not found.");
		return null;
	}

}
