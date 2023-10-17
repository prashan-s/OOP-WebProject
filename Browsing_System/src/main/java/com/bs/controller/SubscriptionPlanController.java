package com.bs.controller;

import java.util.List;

import com.bs.dao.SubscriptionPlanDAO;
import com.bs.model.SubscriptionPlan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SubscriptionPlanController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public SubscriptionPlanController() {
		
	}
	
	public SubscriptionPlanController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther =  request.getRequestDispatcher("SubscriptionPlan.jsp");
		
	}
	
	public void selectSubscriptionPlan(int subId) {
		
		try {
		List<SubscriptionPlan> subscriptionPlans = new SubscriptionPlanDAO().selectSubscriptionPlan(subId);
		System.out.println("subscription plan : " + subscriptionPlans);
		request.setAttribute("subscription plan", subscriptionPlans);//attribute name, objectName
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
