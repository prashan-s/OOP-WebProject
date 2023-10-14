package com.bs.servlet;

import java.io.IOException;

import com.bs.controller.UserPaymentMethodController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPaymentMethodServlet
 */
public class UserPaymentMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserPaymentMethodController controller;
  
   
    public UserPaymentMethodServlet() {
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		this.controller = new UserPaymentMethodController(request, response);
		this.controller.selectPaymentMethod(userId);
		
		
		
    
	}

}
