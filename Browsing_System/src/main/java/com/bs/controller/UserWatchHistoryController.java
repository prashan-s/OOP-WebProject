package com.bs.controller;

import java.util.List;

import com.bs.dao.UserWatchHistoryDAO;
import com.bs.model.UserWatchHistory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserWatchHistoryController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	UserWatchHistoryDAO dao;

	public UserWatchHistoryController() {

	}

	public UserWatchHistoryController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new UserWatchHistoryDAO();

	}

	public void doAction(String action) {

		String jspPage = "UserWatchHistory.jsp";
		int userId = -1;
		boolean showUserIdForm = false;
		boolean showUserHistory = false;
		boolean showDeleteStatus = false;

		System.out.println(action + "in controlle do action");

		switch (action) {

		case "WatchHistory":

			jspPage = "UserWatchHistory.jsp";
			showUserIdForm = false;
			showUserHistory = true;
			showDeleteStatus = false;
			// System.out.println("in action tag" + showUserHistory);

			userId = Integer.parseInt(this.request.getParameter("userId"));
			request.setAttribute("user", this.selectHistory(userId));

			Cookie cookie = new Cookie("userId", Integer.toString(userId));
			this.response.addCookie(cookie);
			break;

		case "remove":
			jspPage = "UserWatchHistory.jsp";
			showUserIdForm = false;
			showUserHistory = false;
			showDeleteStatus = true;
			// System.out.println("came to remove tag");

			String deleteMessage = null;
			int watchId = Integer.parseInt(this.request.getParameter("watchId"));
			boolean deleteStatus = this.deleteHistory(watchId);

			if (deleteStatus == false) {
				deleteMessage = "failed to remove";
			} else {
				deleteMessage = "removed from history";
			}
			System.out.println(deleteMessage);
			request.setAttribute("deleteMessage", deleteMessage);
			break;

		}

		try {
			request.setAttribute("showUserIdForm", showUserIdForm);
			request.setAttribute("showUserHistory", showUserHistory);
			request.setAttribute("showDeleteStatus", showDeleteStatus);

			this.dispacther = request.getRequestDispatcher(jspPage);
			dispacther.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<UserWatchHistory> selectHistory(int userId) {

		try {
			List<UserWatchHistory> history = new UserWatchHistoryDAO().selectHistory(userId);
			request.setAttribute("history", history);// attribute name, objectName
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteHistory(int watchId) {
		boolean deleteStatus = false;
		try {
			deleteStatus = new UserWatchHistoryDAO().deleteHistory(watchId);
			request.setAttribute("deleteStatus", deleteStatus);// attribute name, objectName
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleteStatus;
	}

}
