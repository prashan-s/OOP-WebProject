package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.PaymentDAO;
import com.bs.model.Payment;
public class PaymentController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public PaymentController() {
		
	}
	
	public PaymentController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther =  request.getRequestDispatcher("Payment.jsp");
		
	}
	
	public void selectPayment(int paymentId) {
		
		try {
		List<Payment> payments = new PaymentDAO().selectPayment(paymentId);
		System.out.println("payments : " + ((Payment) payments).getAmount());
		request.setAttribute("payments", payments);//attribute name, objectName
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			dispacther.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}