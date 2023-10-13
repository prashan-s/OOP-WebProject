package com.bs.dao;

import com.bs.utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.bs.model.UserWatchHistory;
import com.bs.interfaces.IUserWatchHistoryDAO;


public class UserWatchHistoryDAO implements IUserWatchHistoryDAO{
	
    private static final String SELECT_HISTORY_BY_USER_ID = "SELECT watch_id, user_id, type, tvs_id, movie_Id, row_created_datetime "
    												 	  + "FROM user_watch_history "
    												 	  + "WHERE watch_id = ? "
    												 	  + "ORDER BY row_created_datetime DESC ";
    
    private static final String INSERT_HISTORY = "INSERT INTO user_watch_history (user_id, type, tvs_id, movie_Id) "
    										   + "VALUES (?, ?, ?, ?);";
    
    private static final String DELETE_HISTORY = "DELETE FROM user_watch_history "
    										   + "WHERE watch_id = ?;";
    
    public List<UserWatchHistory> selectHistory(int userId) {
        ArrayList<UserWatchHistory> userWatchHistory = new ArrayList<>();
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_HISTORY_BY_USER_ID);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int watchId = rs.getInt("watch_id");
                int returnedUserId = rs.getInt("user_id");
                char type = rs.getString("type").charAt(0);
                int tvsId = rs.getInt("tvs_id");
                int movieId = rs.getInt("movie_Id");
                Date rowCreatedDatetime = rs.getDate("row_created_datetime");
                
                UserWatchHistory history = new UserWatchHistory(watchId, returnedUserId, type, tvsId, movieId, rowCreatedDatetime);
                
                userWatchHistory.add(history);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userWatchHistory;
    }
    
    public void insertHistory(UserWatchHistory history) {
        
    	try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_HISTORY);
            
            stmt.setInt(1, history.getUserId());
            stmt.setString(2, String.valueOf(history.getType()));
            stmt.setInt(3, history.getTvsId());
            stmt.setInt(4, history.getMovieId());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteHistory(int watchId) {
        boolean rowDelete = false;
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_HISTORY);
            stmt.setInt(1, watchId);
            rowDelete = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rowDelete;
    }
}
