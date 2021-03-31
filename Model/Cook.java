package Model;

public class Cook extends Employee {
	private double sallary;
	private double taxRate;

	public Cook(int id, String name, double sallary) {
		super(id, name);
		this.sallary = sallary;
		this.taxRate = 0.18;
	}

	public double getSalary() {
		return sallary;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public double calculateExpense() {
		return sallary * 1.18;
	}

}
