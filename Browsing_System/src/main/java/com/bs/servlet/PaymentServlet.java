package com.bs.servlet;

import java.io.IOException;

import com.bs.controller.PaymentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private PaymentController controller;
	
	public PaymentServlet() {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : paymentServlet");
		this.controller = new PaymentController(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost : paymentServlet");
		System.out.println("Selected ID:" + request.getParameter("paymentId"));
		
		int paymentId = Integer.parseInt(request.getParameter("paymentId"));
		
		this.controller = new PaymentController(request, response);
		this.controller.selectPayment(paymentId);
		
	}

}
