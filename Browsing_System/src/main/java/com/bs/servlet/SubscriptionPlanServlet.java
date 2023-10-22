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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet: SubscriptionPlanServlet");
		this.controller = new SubscriptionPlanController(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost: SubscriptionPlanServlet");
		System.out.println("Selected ID: " + request.getParameter("subId"));
		
		Integer subPlanId = Integer.parseInt(request.getParameter("subId"));
		
		this.controller = new SubscriptionPlanController(request, response);
        this.controller.selectSubscriptionPlan(subPlanId);
	}

}
