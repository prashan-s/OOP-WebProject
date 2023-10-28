package com.bs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bs.interfaces.IUserDAO;
import com.bs.model.User;
import com.bs.utility.DBConnectionMSSQL;

public class UserDAO implements IUserDAO {

	private static final String SELECT_USER_BY_ID = "SELECT user_id, name, email, mobile_no, dob , premium_user, password , "
			+ "created_admin_name, is_active, row_created_datetime " + "FROM users " + "WHERE user_id = ? ";
	// admin select user list
	private static final String SELECT_USER_LIST = "SELECT user_id, name, email, mobile_no, dob , premium_user, password , "
			+ "created_admin_name, CASE WHEN is_active = 1 THEN 'Active' ELSE 'InActive' END AS is_active_status, is_active, row_created_datetime " + "FROM users "
			+ "ORDER BY row_created_datetime DESC ";
	// when login
	private static final String SELECT_PASSWORD_BY_USERNAME = "SELECT password " + "FROM users " + "WHERE name = ?  ";

	// when user sign up
	private static final String INSERT_USER = "INSERT INTO users (name, email, mobile_no , dob , password )"
			+ "VALUES (?, ? , ? , ? , ? )";
	// when user update details
	private static final String UPDATE_USER_BY_USER = "UPDATE users SET name = ? , email =  ? , mobile_no = ? , dob = ?  "
			+ "WHERE user_id = ?";
	// when admin update details
	private static final String UPDATE_USER_BY_ADMIN = "UPDATE users SET name = ? , email =  ? , mobile_no = ? , dob = ? , premium_user = ? "
			+ "WHERE user_id = ?";
	// when user upgrade to premium
	private static final String UPGRADE_TO_PREMIUM = "UPDATE users SET premium_user = 1 " + "WHERE user_id = ? ";
	// when user change password
	private static final String UPDATE_PASSWORD = "UPDATE users SET password = ? " + "WHERE user_id = ?";
	// when user or admin delete user
	private static final String DELETE_USER = "DELETE FROM users " + "WHERE user_id = ? ";

	public User selectUser(int userId) {

		User user = null;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_USER_BY_ID);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int returnedUserId = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobileNo = rs.getString("mobile_no");
				Date dob = rs.getDate("dob");
				String isPremiumUser = rs.getString("premium_user");
				boolean premium_user = rs.getBoolean("premium_user");
				String password = rs.getString("password");
				String created_admin_name = rs.getString("created_admin_name");
				String isActiveStatus = rs.getString("is_active_status");
				boolean is_active = rs.getBoolean("is_active");
				Date row_created_datetime = rs.getDate("row_created_datetime");

				user = new User(returnedUserId, name, email, mobileNo, dob, isPremiumUser, premium_user, password, created_admin_name, isActiveStatus,
						is_active, row_created_datetime);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
	
	// all user list
		public List<User> selectAllUserList() {

			List<User> users = new ArrayList<>();
			try {
				Connection con = DBConnectionMSSQL.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_USER_LIST);

				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					int returnedUserId = rs.getInt("user_id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String mobileNo = rs.getString("mobile_no");
					Date dob = rs.getDate("dob");
					String isPremiumUser = rs.getString("premium_user");
					boolean premium_user = rs.getBoolean("premium_user");
					String password = rs.getString("password");
					String created_admin_name = rs.getString("created_admin_name");
					String isActiveStatus = rs.getString("is_active_status");
					boolean is_active = rs.getBoolean("is_active");
					Date row_created_datetime = rs.getDate("row_created_datetime");

					User user = new User(returnedUserId, name, email, mobileNo, dob, isPremiumUser, premium_user, password, created_admin_name, isActiveStatus,
							is_active, row_created_datetime);
					users.add(user);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return users;

		}

	// all user list
	public List<User> selectUserList() {

		List<User> users = new ArrayList<>();
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_USER_LIST);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int returnedUserId = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobileNo = rs.getString("mobile_no");
				Date dob = rs.getDate("dob");
				String isPremiumUser = rs.getString("premium_user");
				boolean premium_user = rs.getBoolean("premium_user");
				String password = rs.getString("password");
				String created_admin_name = rs.getString("created_admin_name");
				String isActiveStatus = rs.getString("is_active_status");
				boolean is_active = rs.getBoolean("is_active");
				Date row_created_datetime = rs.getDate("row_created_datetime");

				User user = new User(returnedUserId, name, email, mobileNo, dob, isPremiumUser, premium_user, password, created_admin_name, isActiveStatus,
						is_active, row_created_datetime);
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;

	}

	// user login
	public String loginUser(String name) {
		String password = null;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_PASSWORD_BY_USERNAME);

			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				password = rs.getString("password");
				System.out.println("dao " + password);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;

	}

	// user signup
	public boolean insertUser(User user) {

		boolean rowInserted = false;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_USER);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getMobileNo());
			stmt.setDate(4, (java.sql.Date) user.getDob());
			stmt.setString(5, user.getPassword());

			rowInserted = (stmt.executeUpdate() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	// user edit
	public boolean updateUserByUser(User user) {

		boolean rowUpdated = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_USER_BY_USER);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getMobileNo());
			Date dob = new Date(user.getDob().getTime());
			stmt.setDate(4, dob);

			stmt.setInt(5, user.getUserId());

			rowUpdated = (stmt.executeUpdate() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowUpdated;
	}

	// admin edit
	public boolean updateUserByAdmin(User user) {

		boolean rowUpdated = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_USER_BY_ADMIN);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getMobileNo());
			Date dob = new Date(user.getDob().getTime());
			stmt.setDate(4, dob);
			stmt.setBoolean(5, user.premiumUser());

			stmt.setInt(6, user.getUserId());

			rowUpdated = (stmt.executeUpdate() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("user dao 119 " + rowUpdated);
		return rowUpdated;
	}

	// upgrade to premium
	public boolean upgradeToPremium(int userId) {

		boolean rowUpdated = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPGRADE_TO_PREMIUM);

			stmt.setInt(1, userId);

			rowUpdated = (stmt.executeUpdate() > 0);

			System.out.println(rowUpdated + "in user dao premium");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowUpdated;

	}

	// user change password
	public boolean changePassword(User user) {

		boolean rowUpdated = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_PASSWORD);

			stmt.setString(1, user.getPassword());
			stmt.setInt(2, user.getUserId());

			rowUpdated = (stmt.executeUpdate() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowUpdated;

	}

//delete user	
	public boolean deleteUser(int userID) {

		boolean rowDelete = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_USER);

			stmt.setInt(1, userID);
			rowDelete = (stmt.executeUpdate() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDelete;

	}

}
