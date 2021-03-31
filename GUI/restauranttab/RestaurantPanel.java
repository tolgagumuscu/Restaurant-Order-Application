package GUI.restauranttab;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import Model.Restaurant;
import javax.swing.JPanel;

public class RestaurantPanel extends JPanel {
	private Restaurant restaurant;
	private BottomPanel bottomPanel;

	public RestaurantPanel(final Restaurant restaurant) {
		this.restaurant = restaurant;
		this.setLayout(new BoxLayout(this, 1));
		final JButton listEmployeesButton = new JButton("List Employees");
		final JButton addCookButton = new JButton("Add Cook");
		final JButton addWaiterButton = new JButton("Add Waiter");
		final JButton calculateExpenses = new JButton("Calculate Expenses");
		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(listEmployeesButton);
		buttonsPanel.add(addCookButton);
		buttonsPanel.add(addWaiterButton);
		buttonsPanel.add(calculateExpenses);
		this.add(buttonsPanel);
		this.add(this.bottomPanel = new BottomPanel(restaurant));
		listEmployeesButton.addActionListener(e -> this.bottomPanel.listEmployee());
		addCookButton.addActionListener(e -> this.bottomPanel.addCook());
		addWaiterButton.addActionListener(e -> this.bottomPanel.addWaiter());
		calculateExpenses.addActionListener(e -> this.bottomPanel.calculateExpenses());
	}
}