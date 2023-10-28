package com.bs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.controller.UserRatingsController;

@WebServlet(name = "UserRatingsServlet", urlPatterns = {"/UserRatingsServlet"})
public class UserRatingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserRatingsController controller;

    public UserRatingsServlet() {
    }

	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all ratings.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		this.controller = new UserRatingsController(request, response);
		
		//Handling the null Exception
		try {
	    	String a = request.getParameter("action");
	        controller.doAction(a);
		}catch(Exception e) {
			e.printStackTrace();
		}     

	}
	
	
	//Handles HTTP PUT requests. 
	//Initializes the MovieController, retrieves the action parameter, and performs the corresponding action.
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.controller = new UserRatingsController(request, response);
    	
		//Handling the null Exception
		try {
	    	String a = request.getParameter("action");
	        controller.doAction(a);
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    
    //Handles HTTP DELETE requests.
    //Initializes the MovieController, retrieves the action parameter, and performs the corresponding action.
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	this.controller = new UserRatingsController(request, response);
    	
		//Handling the null Exception
		try {
	    	String a = request.getParameter("action");
	        controller.doAction(a);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
