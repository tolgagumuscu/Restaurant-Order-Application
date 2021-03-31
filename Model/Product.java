package Model;

public abstract class Product implements Expense {
	private String name;
	protected double purchasePrice;
	private double sellingPrice;
	protected double utilityCost;

	public Product(String name, double sell, double purchase, double cost) {
		this.name = name;
		this.purchasePrice = purchase;
		this.sellingPrice = sell;
		this.utilityCost = cost;
	}

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String isim) {
		this.name = isim;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sell) {
		this.sellingPrice = sell;
	}

	public double getUtilityCost() {
		return utilityCost;
	}

	public String toString() {
		return name;
	}

}
