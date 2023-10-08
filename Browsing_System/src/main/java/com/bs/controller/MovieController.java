package com.bs.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.dao.MovieDAO;
import com.bs.model.Movie;

public class MovieController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public MovieController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther =  request.getRequestDispatcher("useraccount.jsp");
		
	}
	
	private void validate() {

		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		try {
		List<Movie> cusDetails = MovieDAO.validate(username, password);
		request.setAttribute("cusDetails", cusDetails);//attribute name, objectName
		}catch(Exception e){
			e.printStackTrace();
		}
		
		dispacther.forward(request, response);
	}
	
	
}
