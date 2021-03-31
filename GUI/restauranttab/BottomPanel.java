package GUI.restauranttab;

import java.util.List;
import Model.Cook;
import Model.Employee;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.awt.BorderLayout;
import Model.Restaurant;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class BottomPanel extends JPanel {
	private Restaurant restaurant;

	public BottomPanel(Restaurant restaurant) {
		this.restaurant = restaurant;
		this.setLayout(new BorderLayout());
	}

	public void listEmployee() {
		List<Employee> isciler = this.restaurant.getEmployees();
		JPanel panel = new JPanel(new GridLayout(isciler.size() + 1, 3));
		JLabel id = new JLabel("ID");
		id.setForeground(Color.red);
		panel.add(id);
		JLabel isim = new JLabel("Name");
		isim.setForeground(Color.red);
		panel.add(isim);
		JLabel is = new JLabel("Job");
		is.setForeground(Color.red);
		panel.add(is);
		for (Employee employee : isciler) {
			panel.add(new JLabel(new StringBuilder(String.valueOf(employee.getId())).toString()));
			panel.add(new JLabel(employee.getName()));
			panel.add(new JLabel((employee instanceof Cook) ? "Cook" : "Waiter"));
		}

		this.removeAll();
		this.add(panel, "North");
		this.revalidate();
		this.repaint();
	}

	public void addCook() {
		JPanel panel = new JPanel(new GridLayout(9, 2));
		JLabel isim = new JLabel("Name: ");
		panel.add(isim);
		JTextField isimYaz = new JTextField();

		panel.add(isimYaz);
		JLabel maas = new JLabel("Salary: ");
		panel.add(maas);
		JFormattedTextField maasGir = new JFormattedTextField(NumberFormat.getNumberInstance());
		int zero = 0;
		String sifir = Integer.toString(zero);
		maasGir.setText(sifir);

		panel.add(maasGir);
		panel.add(Box.createGlue());
		JButton addButton = new JButton("Add Cook");
		panel.add(addButton);
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());

		addButton.addActionListener(e -> {

			String asciYaz = isimYaz.getText();
			String salary = maasGir.getText();
			double salary2 = Double.parseDouble(salary);

			if (asciYaz == null || asciYaz.isEmpty()) {
				JOptionPane.showMessageDialog(panel, "Error: Enter a name!!", "NAME ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (salary2 == 0 || salary == null) {
				JOptionPane.showMessageDialog(panel, "Error: Enter a salary!!", "SALARY ERROR",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				restaurant.addCook(asciYaz, salary2);
				JOptionPane.showMessageDialog(panel, "Cook added successfully!!");
			}

			isimYaz.setText("");
			maasGir.setText("0");

		});
		this.removeAll();
		this.add(panel);
		this.revalidate();
		this.repaint();

	}

	public void addWaiter() {
		JPanel panel = new JPanel(new GridLayout(7, 2));
		JLabel isim = new JLabel("Name: ");
		panel.add(isim);
		JTextField isimYaz = new JTextField();
		panel.add(isimYaz);
		panel.add(Box.createGlue());
		JButton addButton = new JButton("Add Waiter");
		panel.add(addButton);
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());
		panel.add(Box.createGlue());

		addButton.addActionListener(e -> {
			String garsonAdi = isimYaz.getText();
			restaurant.addWaiter(garsonAdi);
			JOptionPane.showMessageDialog(panel, "Waiter added successfully!!");
			isimYaz.setText("");
		});

		this.removeAll();
		this.add(panel);
		this.revalidate();
		this.repaint();
	}

	double bunlatopla = 0;

	public void calculateExpenses() {
		JPanel panel = new JPanel(new GridLayout(3, 2));
		JLabel profit = new JLabel("Profit: ");
		JLabel revenue = new JLabel("Revenue: ");
		JLabel cost = new JLabel("Cost: ");
		String maaliyet = Double.toString(restaurant.calculateExpenses());
		String curo = Double.toString(restaurant.calculateRevenue());
		double kar1 = restaurant.calculateRevenue() - restaurant.calculateExpenses();
		String kar2 = Double.toString(kar1);
		JLabel costEquals = new JLabel(maaliyet);
		JLabel revenueEquals = new JLabel(curo);
		JLabel profitEquals = new JLabel(kar2);
		panel.add(revenue);
		panel.add(revenueEquals);
		panel.add(cost);
		panel.add(costEquals);
		panel.add(profit);
		panel.add(profitEquals);

		this.removeAll();
		this.add(panel, "North");
		this.revalidate();
		this.repaint();

	}
}