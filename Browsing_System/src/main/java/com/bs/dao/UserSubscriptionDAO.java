package com.bs.dao;

import com.bs.utility.DBConnection;
import com.bs.model.Movie;
import com.bs.model.UserSubscription;
import com.bs.interfaces.IUserSubscriptionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;

public class UserSubscriptionDAO implements IUserSubscriptionDAO {
	
    private static final String SELECT_SUBSCRIPTION_BY_ID = "SELECT sub_id, user_id, plan_id, subscribe_date, next_renewal_date, is_active, "
    													  + "row_created_datetime "
    													  + "FROM user_subscription "
    													  + "WHERE sub_id = ?";
    
    
    private static final String INSERT_SUBSCRIPTION = "INSERT INTO user_subscription (user_id, plan_id, subscribe_date, next_renewal_date) "
    												+ "VALUES(?, ?, ?, ?);";
    
    private static final String UPDATE_SUBSCRIPTION = "UPDATE user_subscription SET user_id=?, plan_id=?, subscribe_date=?, next_renewal_date=?, "
    												+ "is_active=? "
    												+ "WHERE sub_id = ?";
    
    private static final String DELETE_SUBSCRIPTION = "DELETE FROM user_subscription "
    												+ "WHERE sub_id = ?";

    public List<UserSubscription> selectSubscription(int sub_id) {
    	ArrayList<UserSubscription> userSubscriptions = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_SUBSCRIPTION_BY_ID);
            stmt.setInt(1, sub_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int returnedSubId = rs.getInt("sub_id");
                int userId = rs.getInt("user_id");
                int planId = rs.getInt("plan_id");
                Date subscribeDate = rs.getDate("subscribe_date");
                Date nextRenewalDate = rs.getDate("next_renewal_date");
                boolean isActive = rs.getBoolean("is_active");
                Timestamp rowCreatedDatetime = rs.getTimestamp("row_created_datetime");

                UserSubscription userSubscription = new UserSubscription(returnedSubId, userId, subscribeDate, nextRenewalDate, planId, isActive, rowCreatedDatetime);
                userSubscriptions.add(userSubscription);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userSubscriptions;
    }

    public void insertSubscription(UserSubscription userSubscription) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_SUBSCRIPTION);

            stmt.setInt(1, userSubscription.getUserId());
            stmt.setInt(2, userSubscription.getPlanId());
            stmt.setDate(3, (Date) userSubscription.getSubscribeDate());
            stmt.setDate(4, (Date) userSubscription.getNextRenewalDate());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateSubscription(UserSubscription userSubscription) {
       
    	boolean rowUpdate = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_SUBSCRIPTION);

            stmt.setInt(1, userSubscription.getUserId());
            stmt.setInt(2, userSubscription.getPlanId());
            stmt.setDate(3,(Date) userSubscription.getSubscribeDate());
            stmt.setDate(4, (Date)userSubscription.getNextRenewalDate());
            stmt.setBoolean(5, userSubscription.isActive());
            stmt.setInt(6, userSubscription.getSubId());

            rowUpdate = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    public boolean deleteSubscription(int sub_id) {
        boolean rowDelete = false;

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_SUBSCRIPTION);

            stmt.setInt(1, sub_id);
            rowDelete = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
