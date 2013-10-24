package com.infoud.views;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class OrderInfoPanel extends JPanel {

	private JLabel customerName = new JLabel("Mr. Nishant Jethwa");
	/* Start changes by Nishant J. */
	private JLabel itemName[] = new JLabel[7];
	private int ilabelSpace = 90, xbound = 10, ybound = 46, c = 0;
	/* End changes by Nishant J. */
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

	/* Start changes by Nishant J. */

	public void setItemName(String[] itemName, String[] itemQuntity) {
		for (int j = 0; j < this.itemName.length; j++) {
			this.itemName[j]
					.setText(itemName[j] + " - " + itemQuntity[j] + ";");
		}
	}

	/* End changes by Nishant J. */
	public OrderInfoPanel() {

		setLayout(null);

		// Position for customer name
		customerName.setBounds(10, 21, 160, 20);
		add(customerName);

		/* Start changes by Nishant J. */
		for (int j = 0; j < itemName.length; j++) {
			itemName[j] = new JLabel("Item ");
			if ((j + 1) % 6 != 0) {
				xbound = 10 + (ilabelSpace * c);
			} else {
				c = 0;
				xbound = 10 + (ilabelSpace * c);
				ybound = ybound + 20;
			}
			// Position for Item List
			itemName[j].setBounds(xbound, ybound, 95, 20);

			add(itemName[j]);
			c++;
		}
		/* End changes by Nishant J. */

		orderAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		// Position for order amount
		orderAmount.setBounds(465, 21, 85, 20);
		add(orderAmount);

	}

}
