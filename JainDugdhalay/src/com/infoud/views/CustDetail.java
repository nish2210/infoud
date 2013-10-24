package com.infoud.views;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.infoud.constants.StringConstants;

@SuppressWarnings("serial")
public class CustDetail extends JFrame {

	private JPanel contentPane;

	public CustDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 630);
		setResizable(false);
		setTitle(StringConstants.CLIENT_HEADER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setHeader();
		createBody();
	}

	public void setHeader() {

		String detail[] = { "NISHANT JETHWA", "9234567890", "50000" };
		JLabel clientNameTitle = new JLabel(detail[0]);
		JLabel custContact = new JLabel("Contact No: " + detail[1]);
		JLabel openingBal = new JLabel("Opening Bal : " + detail[2] + "/-");

		clientNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clientNameTitle.setFont(new Font("Arial", Font.BOLD, 22));
		clientNameTitle.setBounds(10, 5, 944, 40);

		custContact.setHorizontalAlignment(SwingConstants.RIGHT);
		custContact.setBounds(734, 5, 210, 20);

		openingBal.setHorizontalAlignment(SwingConstants.RIGHT);
		openingBal.setBounds(734, 25, 210, 20);

		contentPane.add(clientNameTitle);
		contentPane.add(custContact);
		contentPane.add(openingBal);

		JLabel nextScreen = new JLabel("<<");
		nextScreen.setBounds(10, 10, 30, 20);
		contentPane.add(nextScreen);
		nextScreen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				Home frameobj = new Home();
				frameobj.setVisible(true);

			}
		});
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 934, 10);
		contentPane.add(separator);
	}

	public void createBody() {

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 65, 930, 520);
		PlaceOrder orderPanel = new PlaceOrder();
		JPanel paymentPanel = new JPanel();

		tabbedPane.addTab("PLACE ORDER", null, orderPanel, "Place New Order");
		tabbedPane.addTab("PAYMENT DETAIL", null, paymentPanel,
				"Payment Detail Structure");
		contentPane.add(tabbedPane);

	}

}
