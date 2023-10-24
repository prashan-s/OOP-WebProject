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
		boolean showPwEditForm =  false;
		boolean showPwChangeStatus =  false;

		
		
		switch (action) {

			case "submit":
				showUserIdForm = false;
				showDetails = true;
				showEditForm = false;
				showUpdateStatus = false;
	
				jspPage = "UserProfileEdit.jsp";
				userId = Integer.parseInt(this.request.getParameter("userId"));
				request.setAttribute("user", this.selectUser(userId));
				
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
				
				request.setAttribute("user", this.selectUser(userId));
				
				break;
	
			case "update":
				
				jspPage = "UserProfileEdit.jsp";
				showUserIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = true;
				
				String message = "Updated Successfully!";
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
				
				
				if (updateStatus == false) {
					message = "Update Failed!, Retry....";
					System.out.println("Edit Form Show: " + showEditForm);
				}
				
				request.setAttribute("xmessage", message);
				System.out.println("Updated   " + updateStatus);
				break;
				
			case "submitIdToChangePW":
				
				jspPage= "UserPrivacy&Security.jsp";
				showUserIdForm = false;
				showPwEditForm = true;
				showPwChangeStatus = false;	
				
				userId = Integer.parseInt(this.request.getParameter("userId"));
				
				Cookie pwCookie = new Cookie("userId",Integer.toString(userId) );
				this.response.addCookie(pwCookie);
				break;
			
			
			case "changePassword":
				
				jspPage= "UserPrivacy&Security.jsp";
				showUserIdForm = false;
				showPwEditForm = false;
				showPwChangeStatus = true;	
				boolean pwStatus = false;
				String pwChangeMessage = ""; 
				
				userId = getValueForId("userId");
				User userChangePw =  this.selectUser(userId);
				User newUserChangePw = new User();	
				
				String userCurrentPw = userChangePw.getPassword();	
				String enterdCurrentPw =request.getParameter("currentPw");
				String newPw =request.getParameter("newPw");
				String confirmPw =request.getParameter("ConfirmPw");
				 
				newUserChangePw.setUserId(userId);
		
				
				System.out.println(userCurrentPw);
				System.out.println(enterdCurrentPw);
				System.out.println(newPw);
				System.out.println(confirmPw);

				if(!(userCurrentPw.equals(enterdCurrentPw))){
					pwChangeMessage = "Incorrect Password...";
				}
				else {
					if(!(newPw.equals(confirmPw))){ 
						pwChangeMessage = "New Password and Confirm Password does not match...";
					
					}else if(newPw.equals(confirmPw)){ 
						
						newUserChangePw.setPassword(confirmPw);
						pwStatus = changePassword(newUserChangePw);
						System.out.println("pw status "+pwStatus);
						if (pwStatus == false) {
							pwChangeMessage = pwChangeMessage +"Password Change Failed!, Retry....";
						}else{
							pwChangeMessage = "Password Successfully Updated..";
						}
					
					request.setAttribute("pwChangeMessage", pwChangeMessage);
					System.out.println("pwChangeMessage :   " + pwChangeMessage);
					}
			
				}
			}
		System.out.println("Watiting to Dispatch");
		try {

			System.out.println("showUpdateStatus" + showUpdateStatus);
			
			request.setAttribute("showUserIdForm", showUserIdForm);
			request.setAttribute("showDetails", showDetails);
			request.setAttribute("showEditForm", showEditForm);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			request.setAttribute("showPwEditForm", showPwEditForm);
			request.setAttribute("showPwChangeStatus", showPwChangeStatus);
			
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

	public User selectUser(int userId) {
		User user = null ;
		try {
			user = dao.selectUser(userId);
			// System.out.println("user : " + users.getFirst().getName());
			request.setAttribute("users", user);// attribute name, objectName

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user;

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
	public boolean changePassword(User user) {
		boolean passwordStatus = false;
		try {
		passwordStatus = dao.changePassword(user);
		request.setAttribute("isSuccessPasswordChange", passwordStatus);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return passwordStatus;
		
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