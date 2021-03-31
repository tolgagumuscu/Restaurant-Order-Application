package Model;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

	private ArrayList<Employee> employees;
	private ArrayList<Product> products;

	public Restaurant() {
		this.employees = new ArrayList<Employee>();
		this.products = new ArrayList<Product>();

		initEmployees();
		initProducts();
	}

	private void initEmployees() {

		addCook("Monica", 100);
		addWaiter("Ross");
		addWaiter("Phobe");
		addWaiter("Rachel");
	}

	public void addCook(String name, double sallary) {
		int id = this.employees.size() + 1;
		this.employees.add(new Cook(id, name, sallary));
	}

	public void addWaiter(String name) {
		int id = this.employees.size() + 1;
		this.employees.add(new Waiter(id, name));
	}

	private void initProducts() {

		products.add(new MainDish("Pizza", 6, 2, 2));
		products.add(new MainDish("Burger", 5, 1.5, 2));

		products.add(new Beverage("Coke", 2.0, 0.5));
		products.add(new Beverage("Lemonade", 2.0, 0.3));

		products.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new Dessert("Cake", 3, 0.5, 1));
		products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));

		ArrayList<Product> HGproducts = new ArrayList<>();
		HGproducts.add(new MainDish("Pizza", 6, 2, 2));
		HGproducts.add(new Beverage("Coke", 2, 0.5));
		HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new MenuProduct("Hunger Games Menu", HGproducts));

		ArrayList<Product> Kidsproducts = new ArrayList<>();
		Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
		Kidsproducts.add(new Beverage("Lemonade", 2, 0.3));
		Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		products.add(new MenuProduct("Kids Menu", Kidsproducts));
	}

	public Waiter assignWaiter() {
		Random rand = new Random();
		int rast = rand.nextInt(employees.size());
		while (!(this.employees.get(rast) instanceof Waiter)) {
			rast = rand.nextInt(employees.size());
		}
		return (Waiter) this.employees.get(rast);

	}

	public double calculateExpenses() {
		double empCost = 0;
		double genCost = 0;

		for (Employee employee : employees) {
			empCost += employee.calculateExpense();

		}
		for (Employee employee : employees) {
			if (employee instanceof Waiter) {
				ArrayList<Order> orders = ((Waiter) employee).getOrdersReceived();
				for (Order siparis : orders) {
					ArrayList<Product> urun = siparis.getOrderedProducts();
					for (Product paralar : urun) {
						genCost += paralar.calculateExpense();
					}
				}
			}
		}
		return empCost + genCost;

	}

	public double calculateRevenue() {
		int revenue = 0;
		for (Employee employee : employees) {
			if (employee instanceof Waiter) {
				ArrayList<Order> orders = ((Waiter) employee).getOrdersReceived();
				for (Order order : orders) {
					revenue += order.calculateTotalPrice();
				}
			}
		}

		return revenue;
	}

	public void listEmployees() {

		System.out.println(employees);

	}

	public ArrayList<Product> getProducts() {

		return this.products;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

}
