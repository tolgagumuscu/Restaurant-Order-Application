package Model;

import java.util.ArrayList;

public class Order {
	private ArrayList<Product> products;

	public Order() {
		this.products = new ArrayList<Product>();

	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void listOrder() {

		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
	}

	public ArrayList<Product> getOrderedProducts() {
		return this.products;
	}

	public double calculateTotalPrice() {
		double total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getSellingPrice();
		}
		return total;
	}

}
