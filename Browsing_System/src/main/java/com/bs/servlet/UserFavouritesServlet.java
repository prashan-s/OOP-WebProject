package com.bs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.controller.MovieController;
import com.bs.controller.UserFavouritesController;

@WebServlet(name = "UserFavouritesServlet", urlPatterns = {"/UserFavouritesServlet"})
public class UserFavouritesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserFavouritesController controller;

    public UserFavouritesServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Perform any additional logic for doGet if needed
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.controller = new UserFavouritesController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
    	
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.controller = new UserFavouritesController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
    }
    
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	this.controller = new UserFavouritesController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
	}
}
