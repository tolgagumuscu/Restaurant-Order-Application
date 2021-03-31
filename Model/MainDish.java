package Model;

public class MainDish extends Product{
	public MainDish(String name, double purchase, double sell, double cost) {
		super(name,purchase,sell,cost);
	}
	public double calculateExpense() {
		return super.getPurchasePrice()+super.getUtilityCost();
		
	}
}
	

