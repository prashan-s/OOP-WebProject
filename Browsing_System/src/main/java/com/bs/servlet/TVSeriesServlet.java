package com.bs.servlet;

import com.bs.controller.TVSeriesController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TVSeriesServlet", urlPatterns = {"/TVSeriesServlet"})
public class TVSeriesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TVSeriesController controller;

    public TVSeriesServlet() {
    }

	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all TVSeries.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.controller = new TVSeriesController(request, response);
    	this.controller.selectAllTvSeries();
    }

	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = new TVSeriesController(request, response);

		String a = request.getParameter("action");
		System.out.println("TV Series Action: " + a);
		controller.doAction(a);
		//Handling the null Exception
		try {

		}catch(Exception e) {
			e.printStackTrace();
		}
       
    }
    
	//Handles HTTP PUT requests. 
	//Initializes the MovieController, retrieves the action parameter, and performs the corresponding action.
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.controller = new TVSeriesController(request, response);
    	
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

    	this.controller = new TVSeriesController(request, response);
    	
		//Handling the null Exception
		try {
	    	String a = request.getParameter("action");
	        controller.doAction(a);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
