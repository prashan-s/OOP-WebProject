package com.bs.controller;

import java.util.List;
import com.bs.dao.MovieDAO;
import com.bs.model.Movie;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MovieController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public MovieController() {
		
	}
	
	public MovieController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther =  request.getRequestDispatcher("Movie.jsp");
		
	}
	
	public void selectMovie(int movieId) {
		
		try {
		List<Movie> movies = new MovieDAO().selectMovie(movieId);
		System.out.println("movies : " + movies.getFirst().getTitle());
		request.setAttribute("movies", movies);//attribute name, objectName
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			dispacther.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
