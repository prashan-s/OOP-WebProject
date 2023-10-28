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
	
	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all payments.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.controller = new PaymentController(request, response);
		
		
	}

}
