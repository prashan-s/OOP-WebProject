package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.bs.dao.PaymentDAO;
import com.bs.dao.UserDAO;
import com.bs.dao.UserPaymentMethodDAO;
import com.bs.dao.UserSubscriptionDAO;
import com.bs.model.Payment;
import com.bs.model.UserPaymentMethod;
import com.bs.model.UserSubscription;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserPaymentMethodController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	UserPaymentMethodDAO dao;
	UserSubscriptionDAO userSubDao;
	PaymentDAO paymentDao;
	UserDAO userDao;
	java.util.Date exp = new java.util.Date();
	
	public UserPaymentMethodController() {
		
	}
	
	
	public UserPaymentMethodController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new UserPaymentMethodDAO();
		this.userSubDao = new UserSubscriptionDAO();
		this.paymentDao = new PaymentDAO();
		this.userDao = new UserDAO();
	}
	public void doAction(String action) {
		
		String jspPage = "UserPaymentMethod.jsp";
		int userId = -1;
		boolean showUserIdForm = false;
		boolean listPaymentMethod = false;
		boolean addPaymentMethod =  false;
		boolean showDeleteStatus=  false;
		boolean showInsertStatus = false;
		boolean showPaymentStatus = false;
		switch(action) {
	
	case "submit":
	
		listPaymentMethod = true;
		addPaymentMethod = true;
		
		jspPage = "UserPaymentMethod.jsp";
		userId = Integer.parseInt(this.request.getParameter("userId"));
		request.setAttribute("methods", this.selectPaymentMethod(userId));

		Cookie cookie = new Cookie("userId", Integer.toString(userId));
		this.response.addCookie(cookie);
		break;
		
	case "pay":
		jspPage = "UserPaymentMethod.jsp";
		showPaymentStatus = true;
		String paymentMessage = "";
		String premiumMessage = "";
		
		userId = Integer.parseInt(request.getParameter("userId"));
		UserSubscription userSub = new UserSubscription();
		userSub.setUserId(userId);
		userSub.setPlanId(Integer.parseInt(request.getParameter("planId")));
		int subId = userSubDao.insertSubReturnSubId(userSub);
		
		Payment payment = new Payment();
		payment.setUserId(userId);
		payment.setAmount(Float.parseFloat(request.getParameter("amount")));
		payment.setSubId(subId);
		Boolean paymentStatus = paymentDao.insertPayment(payment);
		
		System.out.println(paymentStatus+ "in pay tag");
		
		if(paymentStatus == false) {
			paymentMessage = "Payment failed..";
		}else {
			paymentMessage = "Payment Success..";
			boolean premiumStatus = userDao.upgradeToPremium(userId);
			if(premiumStatus == true) {
				premiumMessage = "You are now Premium Member";
			}else {
				premiumMessage = "Still not a Premium Member";
			}
		}
		request.setAttribute("paymentMessage", paymentMessage);
		request.setAttribute("premiumMessage", premiumMessage);
		break;
		
	case "remove":
		jspPage = "UserPaymentMethod.jsp";
		showDeleteStatus = true;
		boolean deleteStatus = false;
		String deleteMessage = null;

		int paymentMethodId = Integer.parseInt(this.request.getParameter("paymentMethodId"));

		deleteStatus = this.deletePaymentMethod(paymentMethodId);
		System.out.println(deleteStatus + "do action");
		if (deleteStatus == false) {
			deleteMessage = "failed to remove";
		} else {
			deleteMessage = "removed from Payment Methods";
		}
		request.setAttribute("deleteMessage", deleteMessage);
		break;
	
	case "add":
		jspPage = "UserPaymentMethod.jsp";
		showInsertStatus = true;
		boolean insertStatus = false;
		String insertMessage = null;
		
		UserPaymentMethod method = new UserPaymentMethod();
		SimpleDateFormat dateFormatPayMethod = new SimpleDateFormat("yyyy-MM-dd");
		
		method.setCardNumber(request.getParameter("cardNo"));
		try {
			exp = dateFormatPayMethod.parse(request.getParameter("expDate"));
			java.sql.Date expMethod = new java.sql.Date(exp.getTime());
				method.setCardExpiryDate(expMethod);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		method.setCvv(Integer.parseInt(request.getParameter("cvv")));
		method.setUserId(getValueForId("userId"));
		
		insertStatus = this.addUserPaymentMethod(method);
		System.out.println(insertStatus + "insert do action");

		if(insertStatus == false) {
			insertMessage = "Failed to add payment method..";
			
		}else {
			insertMessage =  "Successfully add payment Method..";
		}
		request.setAttribute("insertMessage", insertMessage);

		break;
		
		}
		try {
		request.setAttribute("showUserIdForm", showUserIdForm);
		request.setAttribute("listPaymentMethod", listPaymentMethod);
		request.setAttribute("addPaymentMethod", addPaymentMethod);
		request.setAttribute("showDeleteStatus", showDeleteStatus);
		request.setAttribute("showInsertStatus", showInsertStatus);
		request.setAttribute("showPaymentStatus", showPaymentStatus);
		
		this.dispacther = request.getRequestDispatcher(jspPage);
		dispacther.forward(request, response);

	} catch (Exception e2) {
		e2.printStackTrace();
	}
	}
	public List<UserPaymentMethod>  selectPaymentMethod(int userId) {
		
		List<UserPaymentMethod> methods = null;
		try {
			methods = this.dao.selectUserPaymentMethod(userId);
		//	request.setAttribute("methods", methods);
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		return methods;
	}
	
	public boolean  deletePaymentMethod(int paymentMethodId) {
		
		boolean deleteStatus = false;
		try {
			deleteStatus = dao.deleteUserPaymentMethod(paymentMethodId);
			System.out.println(deleteStatus + "ctrl method");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
	public boolean addUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
		boolean insertStatus = false;
		try {
			insertStatus = dao.insertUserPaymentMethod(userPaymentMethod);
			System.out.println(insertStatus + "insert ctrl metho");

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
}
