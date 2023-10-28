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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.controller = new TVSeriesDetailsController(request, response);
        this.controller.selectAllTVSeriesEpisodesDetails();
        // Perform any additional logic for doGet if needed
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
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
