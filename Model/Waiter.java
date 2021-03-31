package Model;

import java.util.ArrayList;

public class Waiter extends Employee {
	private double orderRate;
	private ArrayList<Order> orders;

	public Waiter(int id, String name) {
		super(id, name);
		this.orderRate = 0.10;
		this.orders = new ArrayList<Order>();
	}

	public void createOrder(Order order) {
		this.orders.add(order);
	}

	public double calculateExpense() {
		int waiterSallary = 0;
		for (int i = 0; i < orders.size(); i++) {
			waiterSallary += orders.get(i).calculateTotalPrice() * this.orderRate;
		}
		return waiterSallary;
	}

	public ArrayList<Order> getOrdersReceived() {
		return this.orders;
	}

}
