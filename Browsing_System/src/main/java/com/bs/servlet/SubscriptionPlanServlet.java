package com.bs.servlet;

import com.bs.controller.SubscriptionPlanController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SubscriptionPlanServlet", urlPatterns = {"/SubscriptionPlanServlet"})
public class SubscriptionPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SubscriptionPlanController controller;
    
    public SubscriptionPlanServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = new SubscriptionPlanController(request,response);
		this.controller.selectAllSubscriptionPlans();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new SubscriptionPlanController(request, response);
		String a = request.getParameter("action");
		controller.doAction(a);
	}

}
