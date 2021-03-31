package Model;

public class Beverage extends Product{
	public Beverage(String name, double purchase, double sell) {
		super(name,purchase,sell,0);
	}
	
	public double calculateExpense() {
		return super.getPurchasePrice();
	}

}
