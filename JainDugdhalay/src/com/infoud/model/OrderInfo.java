package com.infoud.model;

import java.util.Date;

public class OrderInfo {

	private int oId;
	private String customerName;
	private String placeOfDelivery;
	private Date dateAndTimeOfDelivery;
	private double amount;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPlaceOfDelivery() {
		return placeOfDelivery;
	}

	public void setPlaceOfDelivery(String placeOfDelivery) {
		this.placeOfDelivery = placeOfDelivery;
	}

	public Date getDateAndTimeOfDelivery() {
		return dateAndTimeOfDelivery;
	}

	public void setDateAndTimeOfDelivery(Date dateAndTimeOfDelivery) {
		this.dateAndTimeOfDelivery = dateAndTimeOfDelivery;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
