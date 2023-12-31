package com.bs.servlet;

import java.io.IOException;

import com.bs.controller.UserWatchHistoryController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UserWatchHistoryServlet", urlPatterns = {"/UserWatchHistoryServlet"})
public class UserWatchHistoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserWatchHistoryController controller;
   
	public UserWatchHistoryServlet() {
      
    }

	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all movies.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new UserWatchHistoryController(request, response);
		
		//Handling the null Exception
		try {
			String a = request.getParameter("action");
			controller.doAction(a);
			System.out.println("in servlet "+ a);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
