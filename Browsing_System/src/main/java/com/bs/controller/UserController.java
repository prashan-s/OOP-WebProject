package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.bs.dao.UserDAO;
import com.bs.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	String jspPage;
	
	public UserController() {

	}

	public UserController(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		
		
	}
	
	public void doAction(String action) {
		int userId = -1;
		
		switch(action) {
		
			case "submit" :
		 		jspPage =  "UserProfileEdit.jsp";
				userId = Integer.parseInt(this.request.getParameter("userId"));
		 		this.selectUser(userId , jspPage);
		 		boolean showDetails= true;
		 		boolean showEditForm= true;
		 		break;
		 		
		 	case "edit" :
		 		jspPage ="UserProfileEdit.jsp";
				this.selectUser(userId , jspPage);
		 		
				User user = new User();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				user.setUserId(Integer.parseInt(this.request.getParameter("userId")));
				user.setName( request.getParameter("name"));
				user.setEmail( request.getParameter("email"));
				user.setMobileNo( request.getParameter("mobileNo"));
				try {
				user.setDob(dateFormat.parse( request.getParameter("dob")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				this.updateUserByUser(user);
				boolean showUpdateStatus= true;
		 		break;
		 
		 	case "update" :
		 		jspPage = "UpdateResultPage.jsp";
		 		
		 }
		
	}
	
	public void selectUser(int userId , String jspPage) {

		try {
			List<User> users = new UserDAO().selectUser(userId);
			// System.out.println("user : " + users.getFirst().getName());
			request.setAttribute("users", users);// attribute name, objectName

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			this.dispacther = request.getRequestDispatcher(jspPage);
			dispacther.forward(request, response);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	

	public void updateUserByUser(User user) {
		try {
			boolean successUpdate = new UserDAO().updateUserByUser(user);
			request.setAttribute("isSuccessUpdate", successUpdate);
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			this.dispacther = request.getRequestDispatcher(jspPage);
			dispacther.forward(request, response);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	

	}
	
	public void insertUser(User user) {
		try {
			boolean successInsert = new UserDAO().insertUser(user);
			request.setAttribute("isSuccessUpdate", successInsert);
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			this.dispacther = request.getRequestDispatcher(jspPage);
			dispacther.forward(request, response);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}