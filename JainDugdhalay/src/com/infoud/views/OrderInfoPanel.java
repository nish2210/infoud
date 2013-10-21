package com.infoud.views;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class OrderInfoPanel extends JPanel {

	private JLabel customerName = new JLabel("Mr. Nayan Gohil");
	private JLabel orderAmount = new JLabel("20,000 Rs.");

	public void setCustomerName(String customerName) {
		this.customerName.setText(customerName);
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount.setText(orderAmount);
	}

	public void setBorderTitle(String title) {
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
	}

	public OrderInfoPanel() {

		setLayout(null);

		// Position for customer name
		customerName.setBounds(10, 21, 150, 20);
		add(customerName);
		orderAmount.setHorizontalAlignment(SwingConstants.RIGHT);

		// Position for order amount
		orderAmount.setBounds(465, 21, 75, 20);
		add(orderAmount);

	}

}
