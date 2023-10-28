package com.bs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.controller.TVSeriesDetailsController;

@WebServlet(name = "TVSeriesDetailsServlet", urlPatterns = {"/TVSeriesDetailsServlet"})
public class TVSeriesDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TVSeriesDetailsController controller;

    public TVSeriesDetailsServlet() {
    }

	//Handles HTTP GET requests.
	//Initializes the MovieController and retrieves all TV series details.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.controller = new TVSeriesDetailsController(request, response);
        this.controller.selectAllTVSeriesEpisodesDetails();
        // Perform any additional logic for doGet if needed
    }


	//Handles HTTP POST requests.
	//Initialize the MovieController, retrieve the action parameter, and performs the corresponding action.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.controller = new TVSeriesDetailsController(request, response);
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
    	
    	this.controller = new TVSeriesDetailsController(request, response);
    	
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
		
    	this.controller = new TVSeriesDetailsController(request, response);
    	
		//Handling the null Exception
		try {
	    	String a = request.getParameter("action");
	        controller.doAction(a);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
