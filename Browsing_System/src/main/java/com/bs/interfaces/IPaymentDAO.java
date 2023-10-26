package com.bs.interfaces;

import java.util.List;

import com.bs.model.Payment;

public interface IPaymentDAO {

	List<Payment>selectPayment(int paymentId);
	public boolean insertPayment(Payment payment);
}
