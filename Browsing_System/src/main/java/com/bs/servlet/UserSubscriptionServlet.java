package com.bs.servlet;

import java.io.IOException;

import com.bs.controller.UserSubscriptionController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UserSubscriptionServlet", urlPatterns = {"/UserSubscriptionServlet"})
public class UserSubscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserSubscriptionController controller;
   
    public UserSubscriptionServlet() {
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = new UserSubscriptionController(request, response);
		
	}

}
