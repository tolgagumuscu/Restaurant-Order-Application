package GUI;

import Model.Product;
import Model.Restaurant;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class TopPanel extends JPanel {

	public TopPanel(OrderPanel fatih, Restaurant restaurant) {

		Border border1 = BorderFactory.createTitledBorder("Add Product");
		this.setBorder(border1);
		this.setLayout(new GridLayout(5, 2));

		JLabel product = new JLabel("Product:");
		product.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.add(product);

		JComboBox<Product> comboBox = new JComboBox<Product>();
		comboBox.addItem(null);
		for (Product productList : restaurant.getProducts()) {
			comboBox.addItem(productList);
		}
		this.add(comboBox);
		SpinnerModel value = new SpinnerNumberModel(1, 1, 10, 1);

		JSpinner counts = new JSpinner(value);
		JFormattedTextField engel = ((JSpinner.DefaultEditor) counts.getEditor()).getTextField();
		engel.setEditable(false);

		JLabel shownPrice = new JLabel("0.00 TL");

		JButton addButton = new JButton("Add");
		addButton.setEnabled(false);

		comboBox.addActionListener(e -> {
			Product selectedItem = (Product) comboBox.getSelectedItem();
			counts.setValue(1);
			if (selectedItem != null) {
				double price = selectedItem.getSellingPrice();
				shownPrice.setText(Double.toString(price) + "0 TL");
				counts.setEnabled(true);
				addButton.setEnabled(true);
			} else {
				shownPrice.setText("0.00 TL");
				counts.setEnabled(false);
				addButton.setEnabled(false);
			}

		});

		JLabel count = new JLabel("Count:");
		count.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.add(count);

		if (comboBox != null) {
			counts.setEnabled(true);
		}

		this.add(counts);

		JLabel price = new JLabel("Price:");
		price.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.add(price);

		this.add(shownPrice);

		JLabel priceValueLabel = new JLabel();
		this.add(priceValueLabel);

		this.add(addButton);

		addButton.addActionListener(e -> {
			Product selectedItem3 = (Product) (comboBox.getSelectedItem());
			int counter = (int) counts.getValue();

			fatih.addProduct(selectedItem3, counter);

		});

	}

}
