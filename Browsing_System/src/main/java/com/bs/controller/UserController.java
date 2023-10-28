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
	RequestDispatcher dispatcher;
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
		boolean showAdminIdForm = false;
		boolean showUserList = false;
		boolean showEditUserForm = false;
		boolean showUpdateUserStatus = false;
		boolean showDeleteUserStatus = false;
		boolean deleteStatus = false;
		String deletionMessage;

		User userSignUp = new User();
		String SignUpMessage = "";
		boolean insertStatus = false;
		SimpleDateFormat dateFormatSignup = new SimpleDateFormat("yyyy-MM-dd");
		
		switch (action) {
		case "Add":
			jspPage = "./pages/admin-portal.jsp";
			showSignInForm = false;
			showSignUpForm = false;
			showSignUpStatus = true;
			showSignInStatus = false;

			userSignUp.setName(request.getParameter("userName"));
			userSignUp.setEmail(request.getParameter("email"));
			userSignUp.setMobileNo(request.getParameter("mobile"));
			
			try {
				dob = dateFormatSignup.parse(request.getParameter("dob"));
				java.sql.Date dobSignUp = new java.sql.Date(dob.getTime());
				userSignUp.setDob(dobSignUp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			userSignUp.setPassword("Test123");
			userSignUp.setPremiumUser(false);
			userSignUp.setCreatedAdminName("Admin");
			insertStatus = insertUser(userSignUp);
			
			System.out.println("insert sts " + insertStatus);

			if (insertStatus == false) {
				SignUpMessage = "Sign Up Failed!, Retry....";
			} else {
				SignUpMessage = "Sign Up Successfull..";
			}
			
			request.setAttribute("SignUpMessage", SignUpMessage);

			break;
			
		case "Update":
			jspPage = "./pages/admin-portal.jsp";
			showSignInForm = false;
			showSignUpForm = false;
			showSignUpStatus = true;
			showSignInStatus = false;

			userSignUp.setName(request.getParameter("userId"));
			userSignUp.setName(request.getParameter("userName"));
			userSignUp.setEmail(request.getParameter("email"));
			userSignUp.setMobileNo(request.getParameter("mobile"));
			userSignUp.setIsActive(true);
			String activeStr = request.getParameter("status");
			userSignUp.setIsActive(true);
			
			try {
				if (activeStr.equals("0")){
					userSignUp.setIsActive(true);
				}
				dob = dateFormatSignup.parse(request.getParameter("dob"));
				java.sql.Date dobSignUp = new java.sql.Date(dob.getTime());
				userSignUp.setDob(dobSignUp);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			userSignUp.setPassword("Test123");
			userSignUp.setPremiumUser(false);
			userSignUp.setCreatedAdminName("Admin");
			insertStatus = insertUser(userSignUp);
			
			System.out.println("insert sts " + insertStatus);

			if (insertStatus == false) {
				SignUpMessage = "Sign Up Failed!, Retry....";
			} else {
				SignUpMessage = "Sign Up Successfull..";
			}
			
			request.setAttribute("SignUpMessage", SignUpMessage);

			break;
			
		case "Delete":
			
			jspPage = "./pages/admin-portal.jsp";
			showUserIdForm = false;
			showPwEditForm = false;
			showPwChangeStatus = false;
			showDeleteForm = false;
			showDeleteStatus = true;
			deleteStatus = false;
			deletionMessage = "";
			userId = getValueForId("userId");

			deleteStatus = deleteUser(userId);
			if (deleteStatus == false) {
				deletionMessage = "Deletion Failed!, Retry....";
			} else {
				deletionMessage = "Deletion Successfull....";
			}
			request.setAttribute("deletionMessage", deletionMessage);
			break;
			
		case "Sign In":
			showDetails = true;

			jspPage = "${pageContext.request.contextPath}/index.jsp";
			showSignInForm = false;
			showSignUpForm = false;
			showSignUpStatus = false;
			showSignInStatus = true;
			String loginMessage = "";
			String userName = this.request.getParameter("userName");
			String enteredPassword = this.request.getParameter("password");
			// system.out.println("do action up " +enteredPassword);
			String userPassword = this.loginUser(userName);
			// System.out.println("do action up " +userPassword);
			boolean signInStatus = false;
			if (userPassword.equals(enteredPassword)) {
				loginMessage = "Login Success..";
				signInStatus = true;
			} else {
				loginMessage = "Login Failed..";
			}
			request.setAttribute("signInStatus", signInStatus);
			request.setAttribute("loginMessage", loginMessage);
			break;
			
		case "submit":
			showDetails = true;

			jspPage = "UserProfileEdit.jsp";
			userId = Integer.parseInt(this.request.getParameter("userId"));
			request.setAttribute("user", this.selectUser(userId));

			Cookie cookie1 = new Cookie("userId", Integer.toString(userId));
			this.response.addCookie(cookie1);
			break;

		case "edit":

			jspPage = "UserProfileEdit.jsp";
			showEditForm = true;

			userId = getValueForId("userId");

			request.setAttribute("user", this.selectUser(userId));

			break;

		case "update":

			jspPage = "UserProfileEdit.jsp";
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
							}

			request.setAttribute("xmessage", message);
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

					if (pwStatus == false) {
						pwChangeMessage = pwChangeMessage + "Password Change Failed!, Retry....";
					} else {
						pwChangeMessage = "Password Successfully Updated..";
					}

				}

			}
			request.setAttribute("pwChangeMessage", pwChangeMessage);

			break;

		case "deleteAccount":
			jspPage = "UserPrivacy&Security.jsp";
			showUserIdForm = false;
			showPwEditForm = false;
			showPwChangeStatus = false;
			showDeleteForm = false;
			showDeleteStatus = true;
			deleteStatus = false;
			deletionMessage = "";
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
			// system.out.println("do action up " +enteredPassword);
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

			

			userSignUp.setName(request.getParameter("userName"));
			userSignUp.setEmail(request.getParameter("email"));
			userSignUp.setMobileNo(request.getParameter("mobile"));
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

		case "submit Admin Name":
			jspPage = "AdminManageUser.jsp";
			showUserList = true;
			String adminName = request.getParameter("adminName");
			
			request.setAttribute("user", this.selectUserList());
			Cookie cookieAdmin = new Cookie("cookieAdmin", adminName);
			this.response.addCookie(cookieAdmin);
			break;

		case "editUser":

			jspPage = "AdminManageUser.jsp";
			showEditUserForm = true;

			userId = Integer.parseInt(this.request.getParameter("userId"));
			request.setAttribute("user", this.selectUser(userId));

			Cookie cookieUerId = new Cookie("userId", Integer.toString(userId));
			this.response.addCookie(cookieUerId);

			break;

		case "updateUser":
			jspPage = "AdminManageUser.jsp";
			showUpdateUserStatus = true;

			String editUserMessage = "";
			User updateUser = new User();

			userId = getValueForId("userId");
			adminName = getValueAdminName("adminName");

			updateUser.setUserId(userId);
			updateUser.setName(request.getParameter("name"));
			updateUser.setEmail(request.getParameter("email"));
			updateUser.setMobileNo(request.getParameter("mobileNo"));
			updateUser.setCreatedAdminName(adminName);
			SimpleDateFormat dateFormatUpdateUser = new SimpleDateFormat("yyyy-MM-dd");

			try {
				dob = dateFormatUpdateUser.parse(request.getParameter("dob"));
				java.sql.Date dobUpdateUser = new java.sql.Date(dob.getTime());
				updateUser.setDob(dobUpdateUser);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			updateUser.setPremiumUser(Boolean.parseBoolean("premium"));
			boolean updateUserStatus = this.updateUserByAdmin(updateUser);

			if (updateUserStatus == false) {
				editUserMessage = "Update Failed!, Retry....";
			} else {
				editUserMessage = "Successfully updated..";
			}

			request.setAttribute("editUserMessage", editUserMessage);
			break;

		case "deleteUser":
			jspPage = "AdminManageUser.jsp";
			showDeleteUserStatus = true;
			boolean deleteUserStatus = false;
			String deleteUserMessage = "";
			
			deleteUserStatus = this.deleteUser(Integer.parseInt(request.getParameter("userId")));
			if (deleteUserStatus == false) {
				deleteUserMessage = "Deletion Failed!, Retry....";
			} else {
				deleteUserMessage = "Deletion Successfull....";
			}
			request.setAttribute("deleteUserMessage", deleteUserMessage);
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
			request.setAttribute("showAdminIdForm", showAdminIdForm);
			request.setAttribute("showUserList", showUserList);
			request.setAttribute("showEditUserForm", showEditUserForm);
			request.setAttribute("showUpdateUserStatus", showUpdateUserStatus);
			request.setAttribute("showDeleteUserStatus", showDeleteUserStatus);

			this.dispatcher = request.getRequestDispatcher(jspPage);
			dispatcher.forward(request, response);

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

	private String getValueAdminName(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		String adminName = "";
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					adminName = (ck.getValue());
					System.out.println("Cookie adminName:" + adminName);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (adminName.equals("")) {
			try {
				adminName = request.getParameter("adminName");
			} catch (Exception ex) {
				System.out.println("Error with User ID");
			}
		}
		return adminName;
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
	
	public void selectAllUserList() {
		List<User> users = null;
		try {
			users = this.dao.selectAllUserList();
			request.setAttribute("users", users);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			
			this.dispatcher =  request.getRequestDispatcher("./pages/admin-portal.jsp");
			this.dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<User> selectUserList() {
		List<User> users = null;
		try {
			users = this.dao.selectUserList();
			request.setAttribute("users", users);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return users;

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

	public boolean updateUserByAdmin(User user) {
		boolean updateStatus = false;
		try {
			updateStatus = dao.updateUserByAdmin(user);
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