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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.controller = new TVSeriesController(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = new TVSeriesController(request, response);
		String a = request.getParameter("action");
		controller.doAction(a);
       
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.controller = new TVSeriesController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
    }
    
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
