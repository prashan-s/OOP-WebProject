package com.bs.controller;

import com.bs.dao.UserSubscriptionDAO;
import com.bs.model.UserSubscription;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserSubscriptionController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	UserSubscriptionDAO dao;


	public UserSubscriptionController() {
		
	}

	public UserSubscriptionController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new UserSubscriptionDAO();
	}
	
	public int insertSubReturnSubId(UserSubscription userSubscription) {
		 int subId = 0 ;
		try {
	//	 if (dao != null) {
			subId = this.dao.insertSubReturnSubId(userSubscription);
//			request.setAttribute("subId", subId);
//			 }else {
//				 System.out.println("usser sub dao null #####");
//
//			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subId;
	
	}
}