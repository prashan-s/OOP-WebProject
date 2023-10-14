package com.bs.controller;

import java.util.List;

import com.bs.dao.MovieDAO;
import com.bs.dao.UserWatchHistoryDAO;
import com.bs.model.Movie;
import com.bs.model.UserWatchHistory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserWatchHistoryController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserWatchHistoryController() {
		
	}
	
	public UserWatchHistoryController(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.dispacther =  request.getRequestDispatcher("UserWatchHistory.jsp");
		
	}
	
	public void selectHistory(int userId) {
		
		try {
		List<UserWatchHistory> history = new UserWatchHistoryDAO().selectHistory(userId);
		request.setAttribute("history", history);//attribute name, objectName
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
