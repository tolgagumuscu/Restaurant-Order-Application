package Model;

public abstract class Employee implements Expense{
	private int id;
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String toString() {
		return "Employee "+" "+this.id+":"+" "+this.name+"\n";
	}
	
}
