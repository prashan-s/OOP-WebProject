package com.bs.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.MovieDAO;
import com.bs.model.Movie;
public class MovieController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public MovieController() {
		
	}
	
	public MovieController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther =  request.getRequestDispatcher("MovieDetails.jsp");
		
	}
	
	public void selectMovie(int movieId) {
		
		try {
		List<Movie> cusDetails = new MovieDAO().selectMovie(movieId);
		request.setAttribute("cusDetails", cusDetails);//attribute name, objectName
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
