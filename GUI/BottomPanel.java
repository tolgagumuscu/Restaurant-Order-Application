package GUI;

import Model.Product;
import Model.Restaurant;
import Model.Order;
import Model.Waiter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BottomPanel extends JPanel {
	private Restaurant restaurant;
	private JButton finalButton;
	private DefaultTableModel tableModel;
	Waiter assignedWaiter;
	private Order currentOrder;

	public BottomPanel(OrderPanel fatih, Restaurant restaurant, Waiter waiter) {
		this.restaurant = restaurant;
		this.assignedWaiter = waiter;
		this.currentOrder = new Order();
		this.setLayout(new BorderLayout(5, 5));
		this.setBorder(BorderFactory.createTitledBorder("Current Order"));

		Object[] columnNames = { "Product Name", "Count", "Price" };
		this.tableModel = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(this.tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);

		JPanel enAlt = new JPanel();

		finalButton = new JButton("Finalize");
		finalButton.setEnabled(false);
		enAlt.setLayout(new BorderLayout());
		enAlt.add(finalButton, "East");
		this.add(enAlt, "South");

		finalButton.addActionListener(e -> {
			this.assignedWaiter.createOrder(this.currentOrder);
			JOptionPane.showMessageDialog(fatih, "Your order is completed!\n" + "Total price is: "
					+ String.valueOf(this.currentOrder.calculateTotalPrice()));

			fatih.temizleme();
		});

	}

	public void addProduct(Product product, int count) {

		for (int i = 0; i < count; i++) {
			this.currentOrder.addProduct(product);
		}

		this.finalButton.setEnabled(true);
		Object[] rows = { product.getName(), new StringBuilder(String.valueOf(count)),
				new StringBuilder(String.valueOf(count * product.getSellingPrice())) };
		this.tableModel.addRow(rows);

	}

}
