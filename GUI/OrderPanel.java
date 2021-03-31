package GUI;

import Model.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class OrderPanel extends JPanel {
	private Restaurant restaurant;
	private TopPanel toppanel;
	private BottomPanel bottompanel;
	private JButton NewOrderButton;

	public OrderPanel(Restaurant restaurant) {
		NewOrderButton = new JButton("New Order");
		this.restaurant = restaurant;
		this.add(this.NewOrderButton);
		this.NewOrderButton.addActionListener(e -> {
			this.removeAll();
			this.repaint();

			this.setLayout(new GridLayout(2, 1));

			toppanel = new TopPanel(this, this.restaurant);

			Waiter waiterModel = restaurant.assignWaiter();
			bottompanel = new BottomPanel(this, this.restaurant, waiterModel);

			this.add(toppanel);
			this.add(bottompanel);

			JFrame waiter = new JFrame();

			JOptionPane.showMessageDialog(waiter,
					"Hi, I am " + waiterModel.getName() + "." + "\n What would you like to order?");

		});

	}

	public void temizleme() {
		this.removeAll();
		this.setLayout(new FlowLayout());
		this.add(this.NewOrderButton);
		this.repaint();
	}

	public void addProduct(Product a, int c) {
		this.bottompanel.addProduct(a, c);

	}

}