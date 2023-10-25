package com.bs.controller;

import java.util.List;

import com.bs.dao.SubscriptionPlanDAO;
import com.bs.model.SubscriptionPlan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SubscriptionPlanController {

	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	SubscriptionPlanDAO dao;

	public SubscriptionPlanController() {

	}

	public SubscriptionPlanController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new SubscriptionPlanDAO();

	}

	public void doAction(String action) {
		System.out.println("in do act");
		String jspPage = "SubscriptionPlans.jsp";
		int userId = -1;
		boolean showUserIdForm = false;
		boolean showPlansToUser = false;
		boolean showPlansToAdmin = false;
		boolean editPlansByAdmin = false;
		boolean showUpdateStatus = false;
		boolean showDeleteStatus = false;
		boolean insertPlansByAdmin = false;
		boolean showInsertedStatus = false;
		
		switch (action) {

		case "submit":

			jspPage = "SubscriptionPlans.jsp";
			System.out.println("in submit");
			String role = this.request.getParameter("role");

			if (role.equals("user")) {
				showPlansToUser = true;
				request.setAttribute("subscriptionPlans", this.selectSubscriptionPlan());
			} else if (role.equals("admin")) {
				showPlansToAdmin = true;
				request.setAttribute("subscriptionPlans", this.selectSubscriptionPlan());
			}
			
		//	userId = Integer.parseInt(this.request.getParameter("userId"));
			
		//	Cookie cookieUser = new Cookie("userId", Integer.toString(userId));
		///	this.response.addCookie(cookieUser);
			break;

		case "edit":
			jspPage = "SubscriptionPlans.jsp";
			editPlansByAdmin = true;

			int planId = Integer.parseInt(this.request.getParameter("planId"));

			Cookie cookiePlan = new Cookie("planId", Integer.toString(planId));
			this.response.addCookie(cookiePlan);
			break;

		case "update":

			jspPage = "SubscriptionPlans.jsp";
			showUpdateStatus = true;

			boolean updateStatus = false;
			String UpdateMessage = "";
			SubscriptionPlan plan = new SubscriptionPlan();
			planId = getValueForPlanId("planId");
			plan.setPlanId(planId);
			plan.setDescription(request.getParameter("description"));
			plan.setDuration(Integer.parseInt(request.getParameter("duration")));
			plan.setAmount(Float.parseFloat(request.getParameter("amount")));
			plan.setActive(Boolean.getBoolean(request.getParameter("active")));

			updateStatus = updateSubscriptionPlan(plan);

			if (updateStatus == false) {
				UpdateMessage = "Update Failed!, Retry....";
			} else {
				UpdateMessage = "Successfully Updated ..";
			}

			request.setAttribute("UpdateMessage", UpdateMessage);

			break;

		case "remove":
			jspPage = "SubscriptionPlans.jsp";
			showDeleteStatus = true;
			boolean deleteStatus = false;
			String deleteMessage = null;
			planId = getValueForPlanId("planId");

			deleteStatus = this.deleteSubscriptionPlan(planId);
			if (deleteStatus == false) {
				deleteMessage = "failed to remove";
			} else {
				deleteMessage = "removed from history";
			}
			request.setAttribute("deleteMessage", deleteMessage);
			break;
		
		case "add":
			jspPage = "SubscriptionPlans.jsp";
			insertPlansByAdmin = true;
			break;
		
		case "insert":
			jspPage = "SubscriptionPlans.jsp";
			showInsertedStatus = true;

			boolean insertStatus = false;
			String insertMessage = "";
			SubscriptionPlan planNew = new SubscriptionPlan();

			planNew.setDescription(request.getParameter("description"));
			planNew.setDuration(Integer.parseInt(request.getParameter("duration")));
			planNew.setAmount(Float.parseFloat(request.getParameter("amount")));
			planNew.setActive(Boolean.getBoolean(request.getParameter("active")));

			insertStatus = updateSubscriptionPlan(planNew);

			if (insertStatus == false) {
				insertMessage = "Insert Failed!, Retry....";
			} else {
				insertMessage = "Successfully added..";
			}

			request.setAttribute("UpdateMessage", insertMessage);
			break;
		
		}
		try {
			request.setAttribute("showUserIdForm", showUserIdForm);
			request.setAttribute("showPlansToUser", showPlansToUser);
			request.setAttribute("showPlansToAdmin", showPlansToAdmin);
			request.setAttribute("editPlansByAdmin", editPlansByAdmin);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			request.setAttribute("showDeleteStatus", showDeleteStatus);
			request.setAttribute("insertPlansByAdmin", insertPlansByAdmin);
			request.setAttribute("showInsertedStatus", showInsertedStatus);

			
			this.dispacther = request.getRequestDispatcher(jspPage);
			dispacther.forward(request, response);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}

	public List<SubscriptionPlan> selectSubscriptionPlan() {
		List<SubscriptionPlan> subscriptionPlans = null;
		try {
			subscriptionPlans = new SubscriptionPlanDAO().selectSubscriptionPlan();
			request.setAttribute("subscriptionPlans", subscriptionPlans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscriptionPlans;
	}

	public boolean updateSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		boolean UpdateStatus = false;
		try {
			UpdateStatus = dao.updateSubscriptionPlan(subscriptionPlan);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return UpdateStatus;
	}

	public boolean deleteSubscriptionPlan(int planId) {
		boolean deleteStatus = false;
		try {
			deleteStatus = dao.deleteSubscriptionPlan(planId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}

	public boolean insertSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		boolean insertStatus = false;
		try {
			insertStatus = dao.insertSubscriptionPlan(subscriptionPlan);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertStatus;
	}

	private int getValueForId(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int userId = -1;
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					userId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie UserID:" + userId);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (userId < 0) {
			try {
				userId = Integer.parseInt(this.request.getParameter("userId"));
			} catch (Exception ex) {
				System.out.println("Error with User ID");
			}
		}
		return userId;
	}

	private int getValueForPlanId(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int planId = -1;
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					planId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie plan Id:" + planId);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (planId < 0) {
			try {
				planId = Integer.parseInt(this.request.getParameter("planId"));
			} catch (Exception ex) {
				System.out.println("Error with plan ID");
			}
		}
		return planId;
	}

}
