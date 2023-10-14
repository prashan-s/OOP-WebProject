package com.bs.servlet;

import java.io.IOException;

import com.bs.controller.UserWatchHistoryController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserWatchHistoryServlet
 */
public class UserWatchHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserWatchHistoryController controller;
    public UserWatchHistoryServlet() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		this.controller = new UserWatchHistoryController(request, response);
		this.controller.selectHistory(userId);
	}

}
