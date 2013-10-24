package com.infoud.views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.infoud.constants.StringConstants;
import com.infoud.controller.MainController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.util.List;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;
	private static int TOTAL_ORDER_INFO_COUNT = 7;
	private MainController controller = new MainController();
	private List<Object> orders;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 960, 600);
		setResizable(false);
		setTitle(StringConstants.CLIENT_HEADER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setHeader();

		createLeftPanel();
	}

	public void setHeader() {
		JLabel clientNameTitle = new JLabel(StringConstants.CLIENT_HEADER);
		clientNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clientNameTitle.setFont(new Font("Arial", Font.BOLD, 22));
		clientNameTitle.setBounds(10, 5, 944, 40);
		contentPane.add(clientNameTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 934, 10);
		contentPane.add(separator);
	}

	public void createLeftPanel() {
		JScrollPane leftScrollPane = new JScrollPane();
		leftScrollPane.setBounds(10, 65, 600, 500);
		contentPane.add(leftScrollPane);

		// Fetching Orders
		orders = controller.fetchAllOrdersInfo();
		if (null != orders)
			TOTAL_ORDER_INFO_COUNT = orders.size();

		JPanel mainOrderPanel = new JPanel();
		mainOrderPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		leftScrollPane.setViewportView(mainOrderPanel);
		mainOrderPanel.setLayout(null);

		int i = 0;
		OrderInfoPanel order = null;
		while (i < TOTAL_ORDER_INFO_COUNT) {

			/* OrderInfo orderInfo = (OrderInfo) orders.get(i); */

			order = new OrderInfoPanel();
			order.setCustomerName("Mr. Nayan Gohil " + (i + 1));
			order.setOrderAmount((i + 1) * 10000 + " Rs.");
			order.setBorderTitle("24/10 " + (i + 1) + ":00 PM");
			order.setBounds(10, i * 150 + 10, 560, 140);
			mainOrderPanel.add(order);

			i++;
		}

		mainOrderPanel.setPreferredSize(new Dimension(550,
				TOTAL_ORDER_INFO_COUNT * 150 + 20));

	}

}
