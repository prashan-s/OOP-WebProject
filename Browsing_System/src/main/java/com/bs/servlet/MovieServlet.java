package com.bs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.controller.MovieController;
import com.bs.dao.MovieDAO;
import com.bs.model.Movie;


/**
 * Servlet implementation class MovieController
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private MovieController controller;
	
	public MovieServlet() {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : movieServlet");
		this.controller = new MovieController(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost : movieServlet");
		this.controller = new MovieController(request, response);
		this.controller.selectMovie(1);
		
	}

}
