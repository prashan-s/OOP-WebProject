package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	java.util.Date dob = new java.util.Date();

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
		boolean showUserIdForm = false;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;
		boolean showPwEditForm = false;
		boolean showPwChangeStatus = false;
		boolean showDeleteForm = false;
		boolean showDeleteStatus = false;
		boolean showSignInForm = false;
		boolean showSignUpForm = false;
		boolean showSignUpStatus = false;
		boolean showSignInStatus = false;

		switch (action) {

		case "submit":
			showUserIdForm = false;
			showDetails = true;
			showEditForm = false;
			showUpdateStatus = false;

			jspPage = "UserProfileEdit.jsp";
			userId = Integer.parseInt(this.request.getParameter("userId"));
			request.setAttribute("user", this.selectUser(userId));

			Cookie cookie = new Cookie("userId", Integer.toString(userId));
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

			userId = getValueForId("userId");

			user.setUserId(userId);
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setMobileNo(request.getParameter("mobileNo"));

			SimpleDateFormat dateFormatUpdate = new SimpleDateFormat("yyyy-MM-dd");

			try {
				dob = dateFormatUpdate.parse(request.getParameter("dob"));
				java.sql.Date dobUpdate = new java.sql.Date(dob.getTime());
				user.setDob(dobUpdate);
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

			jspPage = "UserPrivacy&Security.jsp";
			showUserIdForm = false;
			showPwEditForm = true;
			showPwChangeStatus = false;
			showDeleteForm = true;
			showDeleteStatus = false;
			userId = Integer.parseInt(this.request.getParameter("userId"));

			Cookie pwCookie = new Cookie("userId", Integer.toString(userId));
			this.response.addCookie(pwCookie);
			break;

		case "changePassword":

			jspPage = "UserPrivacy&Security.jsp";
			showUserIdForm = false;
			showPwEditForm = false;
			showPwChangeStatus = true;
			showDeleteForm = false;
			showDeleteStatus = false;
			boolean pwStatus = false;
			String pwChangeMessage = "";

			userId = getValueForId("userId");
			User userChangePw = this.selectUser(userId);
			User newUserChangePw = new User();

			String userCurrentPw = userChangePw.getPassword();
			String enterdCurrentPw = request.getParameter("currentPw");
			String newPw = request.getParameter("newPw");
			String confirmPw = request.getParameter("confirmPw");

			newUserChangePw.setUserId(userId);

			System.out.println(userCurrentPw);
			System.out.println(enterdCurrentPw);
			System.out.println(newPw);
			System.out.println(confirmPw);

			if (!(userCurrentPw.equals(enterdCurrentPw))) {
				pwChangeMessage = "Incorrect Password...";
			} else {
				if (!(newPw.equals(confirmPw))) {
					pwChangeMessage = "New Password and Confirm Password does not match...";

				} else if (newPw.equals(confirmPw)) {

					newUserChangePw.setPassword(confirmPw);
					pwStatus = changePassword(newUserChangePw);
					System.out.println("pw status " + pwStatus);
					if (pwStatus == false) {
						pwChangeMessage = pwChangeMessage + "Password Change Failed!, Retry....";
					} else {
						pwChangeMessage = "Password Successfully Updated..";
					}

				}

			}
			request.setAttribute("pwChangeMessage", pwChangeMessage);
			System.out.println("pwChangeMessage :   " + pwChangeMessage);

			break;

		case "deleteAccount":
			jspPage = "UserPrivacy&Security.jsp";
			showUserIdForm = false;
			showPwEditForm = false;
			showPwChangeStatus = false;
			showDeleteForm = false;
			showDeleteStatus = true;
			boolean deleteStatus = false;
			String deletionMessage = "";
			userId = getValueForId("userId");

			deleteStatus = deleteUser(userId);
			if (deleteStatus == false) {
				deletionMessage = "Deletion Failed!, Retry....";
			} else {
				deletionMessage = "Deletion Successfull....";
			}
			request.setAttribute("deletionMessage", deletionMessage);
			break;

		case "signIn":
			jspPage = "Home.jsp";
			showSignInForm = false;
			showSignUpForm = false;
			showSignUpStatus = false;
			showSignInStatus = true;
			String loginMessage = "";
			String userName = this.request.getParameter("userName");
			String enteredPassword = this.request.getParameter("password");
			// ystem.out.println("do action ep " +enteredPassword);
			String userPassword = this.loginUser(userName);
			// System.out.println("do action up " +userPassword);
			if (userPassword.equals(enteredPassword)) {
				loginMessage = "Login Success..";
			} else {
				loginMessage = "Login Failed..";
			}
			request.setAttribute("loginMessage", loginMessage);
			break;

		case "signUp":
			jspPage = "Home.jsp";
			showSignInForm = false;
			showSignUpForm = true;
			showSignUpStatus = false;
			showSignInStatus = false;

			break;

		case "register":
			jspPage = "Home.jsp";
			showSignInForm = false;
			showSignUpForm = false;
			showSignUpStatus = true;
			showSignInStatus = false;

			User userSignUp = new User();
			String SignUpMessage = "";
			boolean insertStatus = false;

			userSignUp.setName(request.getParameter("userName"));
			userSignUp.setEmail(request.getParameter("email"));
			userSignUp.setMobileNo(request.getParameter("mobile"));
			SimpleDateFormat dateFormatSignup = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dob = dateFormatSignup.parse(request.getParameter("dob"));
				java.sql.Date dobSignUp = new java.sql.Date(dob.getTime());
				userSignUp.setDob(dobSignUp);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String pwSignUp = request.getParameter("password");
			String confirmPwSignUp = request.getParameter("confirmPassword");
			System.out.println(pwSignUp);
			System.out.println(confirmPwSignUp);

			if (pwSignUp.equals(confirmPwSignUp)) {
				userSignUp.setPassword(confirmPwSignUp);

				insertStatus = insertUser(userSignUp);
				System.out.println("insert sts " + insertStatus);
				if (insertStatus == false) {
					SignUpMessage = "Sign Up Failed!, Retry....";
				} else {
					SignUpMessage = "Sign Up Successfull..";
				}
			} else {
				SignUpMessage = "New Password and Confirm Password does not match...";
			}
			request.setAttribute("SignUpMessage", SignUpMessage);

			break;

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
			request.setAttribute("showDeleteForm", showDeleteForm);
			request.setAttribute("showDeleteStatus", showDeleteStatus);
			request.setAttribute("showSignInForm", showSignInForm);
			request.setAttribute("showSignUpForm", showSignUpForm);
			request.setAttribute("showSignInStatus", showSignInStatus);
			request.setAttribute("showSignUpStatus", showSignUpStatus);
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

	public User selectUser(int userId) {
		User user = null;
		try {
			user = dao.selectUser(userId);
			// System.out.println("user : " + users.getFirst().getName());
			request.setAttribute("users", user);// attribute name, objectName

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user;

	}

	public String loginUser(String userName) {
		String password = null;
		try {
			password = dao.loginUser(userName);
			request.setAttribute("password", password);
			System.out.println("cntrl " + password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;

	}

	public boolean updateUserByUser(User user) {
		boolean updateStatus = false;
		try {
			updateStatus = dao.updateUserByUser(user);
			request.setAttribute("isSuccessUpdate", updateStatus);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateStatus;

	}

	public boolean upgradeToPremium(int userId) {
		boolean premiumStatus = false;
		try {
			premiumStatus = dao.upgradeToPremium(userId);
			request.setAttribute("premiumStatus", premiumStatus);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return premiumStatus;

	}

	public boolean changePassword(User user) {
		boolean passwordStatus = false;
		try {
			passwordStatus = dao.changePassword(user);
			request.setAttribute("isSuccessPasswordChange", passwordStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passwordStatus;

	}

	public boolean insertUser(User user) {

		boolean successInsert = false;
		try {
			successInsert = dao.insertUser(user);
			request.setAttribute("isSuccessInsert", successInsert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successInsert;

	}

	public boolean deleteUser(int userId) {
		boolean deleteStatus = false;
		try {
			deleteStatus = dao.deleteUser(userId);
			request.setAttribute("isSuccesDeletion", deleteStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}