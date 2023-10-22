package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.bs.dao.UserDAO;
import com.bs.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController {
	RequestDispatcher dispacther;
	HttpServletRequest request;
	HttpServletResponse response;
	UserDAO dao;

	public UserController() {

	}

	public UserController(HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		this.dao = new UserDAO();

	}

	public void doAction(String action) {
		
		String jspPage = "UserProfileEdit.jsp";
		int userId = -1;
		boolean showUserIdForm = true;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;

		switch (action) {

		case "submit":
			showUserIdForm = false;
			showDetails = true;
			showEditForm = false;
			showUpdateStatus = false;

			jspPage = "UserProfileEdit.jsp";
			userId = Integer.parseInt(this.request.getParameter("userId"));
			this.selectUser(userId);
			
			Cookie cookie = new Cookie("userId",Integer.toString(userId) );
			this.response.addCookie(cookie);
			break;

		case "edit":
			
			jspPage = "UserProfileEdit.jsp";
			showUserIdForm = false;
			showDetails = false;
			showEditForm = true;
			showUpdateStatus = false;

			
			userId = getValueForId("userId");
			
		
			
			this.selectUser(userId);
			
			break;

		case "update":
			jspPage = "UserProfileEdit.jsp";
			showUserIdForm = false;
			showDetails = false;
			showEditForm = false;
			showUpdateStatus = true;

			User user = new User();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			userId = getValueForId("userId");
			
			user.setUserId(userId);
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setMobileNo(request.getParameter("mobileNo"));
			try {
				user.setDob(dateFormat.parse(request.getParameter("dob")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			boolean updateStatus = updateUserByUser(user);
			
			System.out.println(updateStatus);
			String message = "Updated Successfully!";
			System.out.println(message);
			
			if (updateStatus == false) {
				message = "Update Failed!, Retry....";
				System.out.println("Edit Form Show:" + showEditForm);
			}
			
			request.setAttribute("xmessage", message);
			System.out.println("Updated   " + updateStatus);

		}

		System.out.println("Watiting to Dispatch");
		try {

			System.out.println("showUpdateStatus" + showUpdateStatus);
			
			request.setAttribute("showUserIdForm", showUserIdForm);
			request.setAttribute("showDetails", showDetails);
			request.setAttribute("showEditForm", showEditForm);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			
			this.dispacther = request.getRequestDispatcher(jspPage);
			dispacther.forward(request, response);

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	private int getValueForId(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int userId = -1;
		if( cookies != null ) {
		    
		    for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					userId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie UserID:"+ userId);
					
					break;
				}
			}
		 } else {
			 System.out.println("No cookies found!");
		 }
		
		if (userId < 0) {
			try {
				userId = Integer.parseInt(this.request.getParameter("userId"));
			}catch( Exception ex){
				System.out.println("Error with User ID");
			}
		}
		return userId;
	}

	public void selectUser(int userId) {

		try {
			List<User> users = dao.selectUser(userId);
			// System.out.println("user : " + users.getFirst().getName());
			request.setAttribute("users", users);// attribute name, objectName

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public boolean updateUserByUser(User user) {
		boolean updateStatus = false;
		try {
			updateStatus = dao.updateUserByUser(user);
			request.setAttribute("isSuccessUpdate", updateStatus);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return updateStatus;

	}

	public boolean insertUser(User user) {
		try {
			boolean successInsert = dao.insertUser(user);
			request.setAttribute("isSuccessInsert", successInsert);
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}

	}
}