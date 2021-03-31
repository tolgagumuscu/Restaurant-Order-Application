package Model;

import java.util.ArrayList;

public class MenuProduct extends Product {
	private ArrayList<Product> products = new ArrayList<>();

	public MenuProduct(String name, ArrayList<Product> products) {
		super(name);
		this.products = products;
		super.setSellingPrice(this.calculateSellingPrice());
	}

	public double calculateExpense() {

		double totPrice = 0.0;
		for (Product product : this.products) {
			totPrice += product.calculateExpense();
		}

		return totPrice;
	}

	public double calculateSellingPrice() {

		double price = 0.0;
		for (Product product : this.products) {
			if (product instanceof Dessert) {
				price += product.getSellingPrice() * 0.8;
			} else if (product instanceof MainDish) {
				price += product.getSellingPrice() * 0.9;
			} else {
				if (product instanceof Beverage) {
					price += product.getSellingPrice() * 0.5;
				}
			}

		}
		double isimver = Math.round(price * 100.0) / 100.0;

		return isimver;
	}
}
