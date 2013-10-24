package com.infoud.views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AddCustomer extends JPanel {

	private JLabel customerName = new JLabel("Customer Name :");
	private JLabel customerContact = new JLabel("Contact No. :");
	private JLabel openingBal = new JLabel("Opening Bal :");

	JTextField iCustomerName = new JTextField();
	JTextField iCustomerContact = new JTextField();
	JTextField iOpeningBal = new JTextField();

	JButton addCustomer = new JButton("ADD CUSTOMER");

	public AddCustomer() {
		setLayout(null);
		// Position for customer name
		customerName.setBounds(10, 10, 130, 20);

		iCustomerName.setBounds(135, 10, 170, 20);

		customerContact.setBounds(10, 50, 130, 20);

		iCustomerContact.setBounds(135, 50, 170, 20);

		openingBal.setBounds(10, 90, 130, 20);

		iOpeningBal.setBounds(135, 90, 170, 20);

		addCustomer.setBounds(80, 130, 170, 25);

		add(customerName);
		add(iCustomerName);
		add(customerContact);
		add(iCustomerContact);
		add(openingBal);
		add(iOpeningBal);
		add(addCustomer);
	}

}
