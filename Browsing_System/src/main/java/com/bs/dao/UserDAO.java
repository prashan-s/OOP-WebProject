package com.bs.dao;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bs.interfaces.IUserDAO;
import com.bs.model.User;
import com.bs.utility.DBConnection;
import com.bs.utility.DBConnectionMSSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO implements IUserDAO{
	
	private static final String SELECT_USER_BY_ID = "SELECT user_id, name, email, mobile_no, dob , premium_user, password , "
												  + "created_admin_name, is_active, row_created_datetime "
												  + "FROM users "
												  + "WHERE user_id = ? ";
	//when user sign up
	private static final String INSERT_USER = "INSERT INTO users (name, email, mobile_no , dob , password )"
											+ "VALUES (?, ? , ? , ? , ? )";
	//when user update details
	private	static final String UPDATE_USER_BY_USER = "UPDATE users SET name = ? , email =  ? , mobile_no = ? , dob = ?"
													+ "WHERE user_id = ?";
	//when user upgrade to premium
	private static final String UPGRADE_TO_PREMIUM = "UPDATE users SET premium_user = 1 "
												   + "WHERE user_id = ? ";
	//when user change password
	private static final String UPDATE_PASSWORD = "UPDATE users SET password = ? "
												+ "WHERE user_id = ?";
	
	private static final String DELETE_USER = "UPDATE  users SET is_active = 0 , "
											+ "WHERE user_id = ? ";	

	public List<User> selectUser(int userId) {
		
		ArrayList<User> users = new ArrayList<>();
		
		try {
		Connection con =  DBConnectionMSSQL.getConnection();
		PreparedStatement stmt = con.prepareStatement(SELECT_USER_BY_ID);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int returnedUserId = rs.getInt("user_id");
			String name =  rs.getString("name");
			String email =  rs.getString("email");
			String mobileNo =  rs.getString("mobile_no");
			Date dob = rs.getDate("dob");
			boolean premium_user = rs.getBoolean("premium_user");
			String password =  rs.getString("password");
			String created_admin_name =  rs.getString("created_admin_name");
			boolean is_active = rs.getBoolean("is_active");
			Date row_created_datetime = rs.getDate("row_created_datetime");
		
			User user = new User(returnedUserId , name , email , mobileNo , dob , premium_user ,
					password , created_admin_name ,is_active ,row_created_datetime);
			
			users.add(user);
		
		}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public void insertUser(User user) {
		
		try {
		Connection con = DBConnectionMSSQL.getConnection();
		PreparedStatement stmt = con.prepareStatement(INSERT_USER);
		
		stmt.setString(1, user.getName());		
		stmt.setString(2, user.getEmail());
		stmt.setString(3,user.getMobileNo());
		stmt.setDate(4, (java.sql.Date) user.getDob());
		stmt.setString(5, user.getPassword());
		
		stmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateUserByUser(User user){
		
		boolean rowUpdated = false;
		
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_USER_BY_USER);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3,user.getMobileNo());
			stmt.setDate(4, (java.sql.Date) user.getDob());
			
			stmt.setInt(5, user.getUserId());
				
			rowUpdated = (stmt.executeUpdate() > 0);
				
			}catch(Exception e) {
				e.printStackTrace();
		}
		
		return rowUpdated;
	}
	
	//upgrade to premium
	public boolean upgradeToPremium(int userId) {
		
		boolean rowUpdated = false;
		
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPGRADE_TO_PREMIUM);
					
			stmt.setInt(1, userId);
				
			rowUpdated = (stmt.executeUpdate() > 0);
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return rowUpdated;
		
	}
	//user change password
	public boolean changePassword(User user) {
		
		boolean rowUpdated = false;
		
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_PASSWORD);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				stmt.setString(1, user.getPassword());
				stmt.setInt(2,user.getUserId());
				
				rowUpdated = (stmt.executeUpdate() > 0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return rowUpdated;
		
	}
//delete user	
	public boolean deleteUser(int userID) {
		
		boolean rowDelete = false;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_USER);
			
			stmt.setInt(1, userID);
			rowDelete = (stmt.executeUpdate() > 0);
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return rowDelete;

	}
	
	
	
	

}