package com.bs.controller;

import java.util.List;

import com.bs.dao.SubscriptionPlanDAO;
import com.bs.dao.UserPaymentMethodDAO;
import com.bs.model.SubscriptionPlan;
import com.bs.model.UserPaymentMethod;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SubscriptionPlanController {

	RequestDispatcher dispatcher;
	HttpServletRequest request;
	HttpServletResponse response;
	SubscriptionPlanDAO dao;
	UserPaymentMethodDAO userPayMethodDao;

	public SubscriptionPlanController() {

	}

	public SubscriptionPlanController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new SubscriptionPlanDAO();
		this.userPayMethodDao = new UserPaymentMethodDAO();
	}

	public void doAction(String action) {
		System.out.println("in do act");
		String jspPage = "SubscriptionPlans.jsp";
		int userId = -1;
		boolean showUserIdForm = false;
		boolean showAdminIdForm = false;
		boolean showPlansToUser = false;
		boolean showPlansToAdmin = false;
		boolean editPlansByAdmin = false;
		boolean showUpdateStatus = false;
		boolean showDeleteStatus = false;
		boolean insertPlansByAdmin = false;
		boolean showInsertedStatus = false;
		boolean showSubscriptionPayDetails = false;
		boolean listPaymentMethod = true;
		boolean addPaymentMethod = true;
		System.out.println("SPlan" + action);
		switch (action) {

		case "submit user Id":

			jspPage = "SubscriptionPlans.jsp";
			showPlansToUser = true;
			request.setAttribute("subscriptionPlans", this.selectAllActiveSubscriptionPlans());
			
			
			userId = Integer.parseInt(this.request.getParameter("userId"));
			Cookie cookieUser = new Cookie("userId", Integer.toString(userId));
			this.response.addCookie(cookieUser);
			
			break;
			
		case "submit admin Id":

			jspPage = "AdminSubscriptionPlans.jsp";
			showPlansToAdmin = true;
			request.setAttribute("subscriptionPlans", this.selectAllActiveSubscriptionPlans());
			
			break;
		case "activate":
			
			jspPage = "UserPaymentMethod.jsp";
			showSubscriptionPayDetails =true;
			listPaymentMethod = true;
			addPaymentMethod = true;
			List<UserPaymentMethod> methods = null;
			
			userId = getValueForId("userId");
			int selectedPlanId = Integer.parseInt(this.request.getParameter("planId"));			
			
			methods = this.userPayMethodDao.selectUserPaymentMethod(userId);
			
			
			request.setAttribute("listPaymentMethod", userId);
			request.setAttribute("userIdCustomer", userId);
			request.setAttribute("userIdCustomer", userId);
			request.setAttribute("selectedSubPlan", this.selectSubscriptionPlanById(selectedPlanId));
			request.setAttribute("methods", methods);

			
			break;
			
		case "edit":
			jspPage = "AdminSubscriptionPlans.jsp";
			editPlansByAdmin = true;

			int planId = Integer.parseInt(this.request.getParameter("planId"));
			request.setAttribute("subPlan", this.selectSubscriptionPlanById(planId));
			
			Cookie cookiePlan = new Cookie("planId", Integer.toString(planId));
			this.response.addCookie(cookiePlan);
			break;

		case "Update":

			jspPage = "./pages/admin-portal.jsp";
			showUpdateStatus = true;
			
			boolean isActive = false;
			boolean updateStatus = false;
			String UpdateMessage = "";
			SubscriptionPlan plan = new SubscriptionPlan();
			planId = Integer.parseInt(request.getParameter("planId"));
			plan.setPlanId(planId);

			isActive= true;

			plan.setDescription(request.getParameter("description"));
			plan.setDuration(Integer.parseInt(request.getParameter("duration")));
			plan.setAmount(Float.parseFloat(request.getParameter("amount")));
			plan.setActive(isActive);

			updateStatus = updateSubscriptionPlan(plan);

			if (updateStatus == false) {
				UpdateMessage = "Update Failed!, Retry....";
			} else {
				UpdateMessage = "Successfully Updated ..";
			}

			request.setAttribute("UpdateMessage", UpdateMessage);

			break;

		case "Delete":
			jspPage = "./pages/admin-portal.jsp";
			showDeleteStatus = true;
			boolean deleteStatus = false;
			String deleteMessage = null;
			planId = Integer.parseInt(request.getParameter("planId"));

			deleteStatus = this.deleteSubscriptionPlan(planId);
			if (deleteStatus == false) {
				deleteMessage = "failed to remove";
			} else {
				deleteMessage = "removed from history";
			}
			request.setAttribute("deleteMessage", deleteMessage);
			break;
		
		case "addPlan":
			jspPage = "AdminSubscriptionPlans.jsp";
			insertPlansByAdmin = true;
			break;
		
		case "Add":
			jspPage = "./pages/admin-portal.jsp";
			showInsertedStatus = true;

			boolean insertStatus = false;
			boolean Active = false;
			String insertMessage = "";
			SubscriptionPlan planNew = new SubscriptionPlan();

			planNew.setDescription(request.getParameter("description"));
			planNew.setDuration(Integer.parseInt(request.getParameter("duration")));
			planNew.setAmount(Float.parseFloat(request.getParameter("amount")));
			planNew.setActive(true);

			insertStatus = insertSubscriptionPlan(planNew);

			if (insertStatus == false) {
				insertMessage = "Insert Failed!, Retry....";
			} else {
				insertMessage = "Successfully added..";
			}

			request.setAttribute("insertMessage", insertMessage);
			break;
		
		}

		try {
			request.setAttribute("showUserIdForm", showUserIdForm);
			request.setAttribute("showAdminIdForm", showAdminIdForm);
			request.setAttribute("showPlansToUser", showPlansToUser);
			request.setAttribute("showPlansToAdmin", showPlansToAdmin);
			request.setAttribute("editPlansByAdmin", editPlansByAdmin);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			request.setAttribute("showDeleteStatus", showDeleteStatus);
			request.setAttribute("insertPlansByAdmin", insertPlansByAdmin);
			request.setAttribute("showInsertedStatus", showInsertedStatus);
			request.setAttribute("showSubscriptionPayDetails", showSubscriptionPayDetails);
			request.setAttribute("listPaymentMethod", listPaymentMethod);
			request.setAttribute("addPaymentMethod", addPaymentMethod);

			
			this.dispatcher = request.getRequestDispatcher(jspPage);
			dispatcher.forward(request, response);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

	}
	public SubscriptionPlan selectSubscriptionPlanById(int planId) {
		SubscriptionPlan subscriptionPlan = null;
		try {
			subscriptionPlan = new SubscriptionPlanDAO().selectSubscriptionPlanById(planId);
			request.setAttribute("subscriptionPlans", subscriptionPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscriptionPlan;
	}

	public void selectAllSubscriptionPlans() {
		List<SubscriptionPlan> subscriptionPlans = null;
		try {
			subscriptionPlans = new SubscriptionPlanDAO().selectAllSubscriptionPlans();
			request.setAttribute("subscriptionPlans", subscriptionPlans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.dispatcher =  request.getRequestDispatcher("./pages/admin-portal.jsp");
			this.dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SubscriptionPlan> selectAllActiveSubscriptionPlans() {
		List<SubscriptionPlan> subscriptionPlans = null;
		try {
			subscriptionPlans = new SubscriptionPlanDAO().selectAllActiveSubscriptionPlans();
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
