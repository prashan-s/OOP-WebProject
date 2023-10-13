package com.bs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import com.bs.dao.UserPaymentMethodDAO;
import com.bs.model.UserPaymentMethod;
public class UserPaymentMethodController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserPaymentMethodController() {
		
	}
	public UserPaymentMethodController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dispacther = request.getRequestDispatcher("UserPaymentMethod.jsp");
	}
	
	public void selectPaymentMethod(int userId) {
		try {
			List<UserPaymentMethod> methods = new UserPaymentMethodDAO().selectUserPaymentMethod(userId);
			request.setAttribute("methods", methods);
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		try {
			dispacther.forward(request, response);
		}catch (Exception e2){
			e2.printStackTrace();
		}
	}
}
