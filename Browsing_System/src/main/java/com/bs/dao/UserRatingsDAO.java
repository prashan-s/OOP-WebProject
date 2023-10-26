package com.bs.dao;

import com.bs.interfaces.IUserRatingsDAO;
import com.bs.model.UserRatings;
import com.bs.utility.DBConnectionMSSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class UserRatingsDAO implements IUserRatingsDAO {

    private static final String SELECT_USER_RATINGS_BY_RATE_ID = "SELECT rate_id, user_id, type, tvs_id, movie_Id, rating, row_created_datetime " +
            "FROM user_rating " +
            "WHERE user_id = ?";

    private static final String INSERT_USER_RATING = "INSERT INTO user_rating (user_id, type, tvs_id, movie_Id, rating) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String DELETE_USER_RATING = "DELETE FROM user_rating WHERE rate_id = ?";
    
    private static final String SELECT_USER_RATINGSCOUNT_BY_MOVIE_ID = "";

    @Override
    public List<UserRatings> selectUserRatings(int rateId) {
        ArrayList<UserRatings> userRatingsList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_USER_RATINGS_BY_RATE_ID);
            stmt.setInt(1, rateId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int returnedRateId = rs.getInt("rate_id");
                int userId = rs.getInt("user_id");
                String type = rs.getString("type");
                int tvsId = rs.getInt("tvs_id");
                int movieId = rs.getInt("movie_Id");
                int rating = rs.getInt("rating");
                Date rowCreatedDatetime = rs.getDate("row_created_datetime");

                UserRatings userRating = new UserRatings(returnedRateId, userId, type, tvsId, movieId, rating, rowCreatedDatetime);
                userRatingsList.add(userRating);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userRatingsList;
    }

    @Override
    public void insertUserRating(UserRatings userRating) {
        System.out.println(INSERT_USER_RATING);

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_USER_RATING);

            stmt.setInt(1, userRating.getUserId());
            stmt.setNString(2, userRating.getType());
            stmt.setInt(3, userRating.getTvsId());
            stmt.setInt(4, userRating.getMovieId());
            stmt.setInt(5, userRating.getRating());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteUserRating(int rateId) {
        boolean rowDelete = false;

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_USER_RATING);

            stmt.setInt(1, rateId);
            rowDelete = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowDelete;
    }

	public List<UserRatings> selectMovieRatings(int movieId,int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
