package com.bs.servlet;

import java.io.IOException;

import com.bs.controller.UserPaymentMethodController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UserPaymentMethodServlet", urlPatterns = {"/UserPaymentMethodServlet"})
public class UserPaymentMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserPaymentMethodController controller;
  
   
    public UserPaymentMethodServlet() {
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.controller = new UserPaymentMethodController(request, response);
		String a = request.getParameter("action");
		controller.doAction(a);
	
	}

}
