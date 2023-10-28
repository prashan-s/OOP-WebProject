package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bs.interfaces.IUserPaymentMethodDAO;
import com.bs.model.UserPaymentMethod;
import com.bs.utility.DBConnectionMSSQL;

public class UserPaymentMethodDAO implements IUserPaymentMethodDAO{

	private static final String SELECT_USER_PAYEMENT_METHOD = "SELECT payment_method_id , card_number , card_expiry_date , "
															+ "cvv , user_id , is_active , row_created_datetime "
															+ "FROM user_payment_method "
															+ "WHERE user_id = ? "
															+ "ORDER BY row_created_datetime DESC ";
	
	private static final String INSERT_USER_PAYMENT_METHOD = "INSERT INTO user_payment_method (card_number , card_expiry_date , cvv , user_id )"
														   + "VALUES (? , ? , ? , ?)";
	
	private static final String DELETE_USER_PAYMENT_METHOD = "DELETE FROM user_payment_method "
														   + "WHERE payment_method_id = ? ";
 
	//select user payment method by user id
	public List<UserPaymentMethod> selectUserPaymentMethod(int userId){
		
		ArrayList<UserPaymentMethod>  methods = new ArrayList<>();
		
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_USER_PAYEMENT_METHOD);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int methodId = rs.getInt("payment_method_id");
				String cardNumber = rs.getString("card_number");
				Date expiry_date = rs.getDate("card_expiry_date");
				int cvv = rs.getInt("cvv");
				int returnedUserId = rs.getInt("user_id");
				boolean is_active = rs.getBoolean("is_active");
				Date row_created_datetime = rs.getDate("row_created_datetime");
			
				UserPaymentMethod method = new UserPaymentMethod(methodId , cardNumber , expiry_date , cvv , returnedUserId , is_active , row_created_datetime );
				
				methods.add(method);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return methods; 
	}
	
	//add new user payment method
	public boolean insertUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
		boolean insertStatus= false;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_USER_PAYMENT_METHOD);
			
			stmt.setString(1, userPaymentMethod.getCardNumber());
			stmt.setDate(2, (java.sql.Date) userPaymentMethod.getCardExpiryDate());
			stmt.setInt(3, userPaymentMethod.getCvv());
			stmt.setInt(4 , userPaymentMethod.getUserId());
			
			insertStatus = stmt.executeUpdate() > 0;
			System.out.println(insertStatus + "insert dao");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return insertStatus;
	}
	
	//delete user payment method
	public boolean deleteUserPaymentMethod(int paymentMethodId) {
		
		boolean rowDelete = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_USER_PAYMENT_METHOD);
			
			stmt.setInt(1, paymentMethodId);
			rowDelete = stmt.executeUpdate() > 0;
			System.out.println(rowDelete + "dao");
		}catch(Exception e) {
			e.printStackTrace();
			}
		return rowDelete;
	}
}

