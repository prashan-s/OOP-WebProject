package com.bs.model;

import java.util.Date;

public class Payment {

	private int paymentId;
	private int userId;
	private int subId;
	private float amount;
	private Date rowCreatedDatetime;

	public Payment() {

	}

	public Payment(int paymentId, int userId, int subId, float amount, int paymentMethodId, Date rowCreatedDatetime) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.subId = subId;
		this.amount = amount;
		this.rowCreatedDatetime = rowCreatedDatetime;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setRowCreatedDatetime(Date rowCreatedDatetime) {
		this.rowCreatedDatetime = rowCreatedDatetime;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public int getUserId() {
		return userId;
	}

	public int getSubId() {
		return subId;
	}

	public float getAmount() {
		return amount;
	}

	public Date getRowCreatedDatetime() {
		return rowCreatedDatetime;
	}
}
