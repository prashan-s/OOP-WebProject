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

	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all movies.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = new SubscriptionPlanController(request,response);
		this.controller.selectAllSubscriptionPlans();
	}

	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new SubscriptionPlanController(request, response);
		
		//Handling the null Exception
		try {
			String a = request.getParameter("action");
			controller.doAction(a);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
