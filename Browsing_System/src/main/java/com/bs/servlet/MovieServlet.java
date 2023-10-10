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
		// TODO Auto-generated method stub
		System.out.println("DoGet: MovieServlet");
		resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Student Resistration Form Data</h1>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("<p> lastName :: " + firstName + "</p>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
		this.controller = MovieController(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = MovieController(request, response);
		
	}

}
