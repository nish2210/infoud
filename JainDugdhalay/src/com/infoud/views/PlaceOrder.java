package com.infoud.views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlaceOrder extends JPanel {

	private JLabel date = new JLabel("Date : ");
	private JLabel time = new JLabel("Time : ");
	private JLabel place = new JLabel("Place : ");

	JTextField idate = new JTextField();
	JTextField itime = new JTextField();
	JTextField iplace = new JTextField();

	public PlaceOrder() {
		setLayout(null);

		date.setBounds(10, 20, 50, 20);

		idate.setBounds(65, 20, 100, 20);

		time.setBounds(220, 20, 50, 20);

		itime.setBounds(285, 20, 100, 20);

		place.setBounds(10, 60, 60, 20);

		iplace.setBounds(80, 60, 305, 20);

		add(date);
		add(idate);
		add(time);
		add(itime);
		add(place);
		add(iplace);
	}

}
