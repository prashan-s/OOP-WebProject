package com.bs.controller;

import java.util.List;
import com.bs.dao.UserDAO;
import com.bs.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserController(){
		
	}
	
	public UserController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dispacther = request.getRequestDispatcher("userProfileEdit");
	}
	
	public void selectUser(int userId){
		
		try {
			List<User> users = new UserDAO().selectUser(userId);
			System.out.println("user : " + users.getFirst().getName());
			request.setAttribute("Users", users);//attribute name, objectName
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		try {
			dispacther.forward(request, response);
			
		} catch (Exception e2){
			e2.printStackTrace();
		}
	}	
}