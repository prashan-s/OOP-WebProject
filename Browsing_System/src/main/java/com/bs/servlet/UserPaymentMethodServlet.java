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
    
	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all user payments.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.controller = new UserPaymentMethodController(request, response);
		
		//Handling the null Exception
		try {
			String a = request.getParameter("action");
			controller.doAction(a);		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
