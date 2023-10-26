package com.bs.controller;

import java.util.List;

import com.bs.dao.PaymentDAO;
import com.bs.model.Payment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class PaymentController {

	RequestDispatcher dispatcher;
	HttpServletRequest request;
	HttpServletResponse response;
	PaymentDAO dao;
	
	public PaymentController() {
		
	}
	
	public PaymentController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dao = new PaymentDAO();
		//this.dispatcher = request.getRequestDispatcher("Payment.jsp");
	}
	
	public void selectPayment(int paymentId) {
		
		try {
		List<Payment> payments = this.dao.selectPayment(paymentId);
		request.setAttribute("payments", payments);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean insertPayment(Payment payment) {
		
		boolean insertStatus = false;
		try {
//			 if (dao != null) {
			insertStatus = dao.insertPayment(payment);
//			 }else {	
//				 System.out.println("payment dao null #####");
//			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return insertStatus;
		}
	
	
}