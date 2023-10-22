package com.bs.controller;



import java.util.List;
import com.bs.dao.PaymentDAO;
import com.bs.model.Payment;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class PaymentController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	PaymentDAO dao;
	
	public PaymentController() {
		
	}
	
	public PaymentController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther = request.getRequestDispatcher("Payment.jsp");
		this.dao = new PaymentDAO();
		
	}
	
	public void selectPayment(int paymentId) {
		
		try {
		List<Payment> payments = this.dao.selectPayment(paymentId);
		System.out.println("payments : " + payments.get(0).getAmount());
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