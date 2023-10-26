package com.bs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.controller.MovieController;
import com.bs.controller.UserRatingsController;



@WebServlet(name = "MovieServlet", urlPatterns = {"/MovieServlet"})
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private MovieController controller;


	private UserRatingsController rateController;
	
	public MovieServlet() {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new MovieController(request, response);
		this.controller.selectAllMovies();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		this.controller = new MovieController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
        
        this.rateController = new UserRatingsController(request,response);
        int movie_Id = Integer.parseInt(request.getParameter("movieId"));
        this.rateController.selectMovieRatings(movie_Id);

	}
	
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.controller = new MovieController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
    }
    
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	this.controller = new MovieController(request, response);
    	String a = request.getParameter("action");
        controller.doAction(a);
	}

}
