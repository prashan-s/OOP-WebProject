package com.bs.interfaces;

import java.util.List;

import com.bs.model.Payment;

public interface IPayment {

	List<Payment>selectPayment(int paymentId);
	public void insertPayment(Payment payment);
}
