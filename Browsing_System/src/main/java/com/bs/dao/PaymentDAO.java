package com.bs.dao;

import java.util.Date;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.bs.interfaces.IPaymentDAO;
import com.bs.model.Payment;
import com.bs.utility.DBConnectionMSSQL;

public class PaymentDAO implements IPaymentDAO{
	
	private static final String SELECT_PAYMENT_BY_ID = "SELECT payment_id, user_id, sub_id, amount, row_created_datetime "
												 		+ "FROM payment "
												 		+ "WHERE payment_id = ?";
	
	private static final String INSERT_PAYMENT = "INSERT INTO payment (user_id, sub_id, amount) "
            											+ "VALUES (?, ?, ?);";


	//select paymentDetails
	public List<Payment> selectPayment(int paymentId){
		
		ArrayList<Payment> payments = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
		    con = DBConnectionMSSQL.getConnection();
		    stmt = con.prepareStatement(SELECT_PAYMENT_BY_ID);
		    stmt.setInt(1, paymentId);
		    rs = stmt.executeQuery();
		    
		    while(rs.next()) {
		    	int returnedPayment_id = rs.getInt("payment_id");
		    	int userId = rs.getInt("user_id");
		    	int subId = rs.getInt("sub_id");
		    	float amount = rs.getFloat("amount");
		    	Date rowCreatedDatetime = rs.getDate("row_created_datetime");
		    	
		    	Payment payment = new Payment(returnedPayment_id, userId, subId, amount, subId, rowCreatedDatetime);
		    	
		    	payments.add(payment);
		    }			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return payments;
	}


	//inserting a new payment
	public void insertPayment(Payment payment) {
		System.out.println(INSERT_PAYMENT);
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBConnectionMSSQL.getConnection();
			stmt = (PreparedStatement) con.prepareStatement(INSERT_PAYMENT);
			
			stmt.setInt(1, payment.getUserId());
			stmt.setInt(2, payment.getSubId());
			stmt.setFloat(3, payment.getAmount());
			
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
