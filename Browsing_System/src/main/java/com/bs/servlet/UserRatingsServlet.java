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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		this.controller = new UserRatingsController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
       

	}
	
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.controller = new UserRatingsController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
    }
    
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	this.controller = new UserRatingsController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
	}



}
