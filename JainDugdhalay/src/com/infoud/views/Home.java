package com.infoud.views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.infoud.constants.StringConstants;
import com.infoud.controller.MainController;
import com.infoud.model.OrderInfo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;
	private static int TOTAL_ORDER_INFO_COUNT = 10;
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
		setBounds(100, 100, 960, 600);
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
		mainOrderPanel.setLayout(new GridLayout(TOTAL_ORDER_INFO_COUNT, 1, 10,
				10));
		mainOrderPanel.setPreferredSize(new Dimension(550,
				TOTAL_ORDER_INFO_COUNT * 100));

		int i = 0;
		OrderInfoPanel order = null;
		while (i < TOTAL_ORDER_INFO_COUNT) {
			
			OrderInfo orderInfo = (OrderInfo) orders.get(i);

			order = new OrderInfoPanel();
			order.setCustomerName(orderInfo.getCustomerName());
			order.setOrderAmount(orderInfo.getAmount() + " Rs.");
			order.setBorderTitle(orderInfo.getDateAndTimeOfDelivery()+"");
			mainOrderPanel.add(order);

			i++;
		}

	}

}
