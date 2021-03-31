package Model;

public class Dessert extends Product {
	public Dessert(String name, double purchase, double sell, double cost) {
		super(name,purchase,sell,cost);
	}
	
	public double calculateExpense() {
		return super.getPurchasePrice()+super.getUtilityCost();
		
	}
	

}
