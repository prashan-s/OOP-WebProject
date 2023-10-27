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
    
    private static final String SELECT_USER_FAVOURITE_COUNT_BY_MOVIE_ID = "SELECT COUNT(DISTINCT(user_id)) " +
            "FROM user_favourite " +
            "WHERE movie_Id = ?";

    private static final String SELECT_USER_WATCH_COUNT_BY_MOVIE_ID = "SELECT COUNT(DISTINCT(user_id)) " +
            "FROM user_watch_history " +
            "WHERE movie_Id = ?";
    
    private static final String SELECT_USER_FAVOURITE_COUNT_BY_TVSeries_ID = "SELECT COUNT(DISTINCT(user_id)) " +
            "FROM user_favourite " +
            "WHERE tvs_Id = ?";

    private static final String SELECT_USER_WATCH_COUNT_BY_TVSeries_ID = "SELECT COUNT(DISTINCT(user_id)) " +
            "FROM user_watch_history " +
            "WHERE tvs_Id = ?";


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

    public List<UserRatings> selectMovieRatings(int movieId) {
        List<UserRatings> movieRatingsList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt1 = con.prepareStatement(SELECT_USER_FAVOURITE_COUNT_BY_MOVIE_ID);
            PreparedStatement stmt2 = con.prepareStatement(SELECT_USER_WATCH_COUNT_BY_MOVIE_ID);
            stmt1.setInt(1, movieId);
            stmt2.setInt(1, movieId);
            
            ResultSet rs1 = stmt1.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();

            // Initialize variables to store the counts
            int favoriteCount = 0;
            int watchCount = 0;

            // Retrieve the counts from the result sets
            if (rs1.next()) {
                favoriteCount = rs1.getInt(1); // Assuming the count is in the first column
            }

            if (rs2.next()) {
                watchCount = rs2.getInt(1); // Assuming the count is in the first column
            }

            // Calculate the ratio and store it in a variable
            double ratio = (watchCount != 0) ? (double) favoriteCount / watchCount : 0.0;

            // You can use this ratio for further processing or return it in some way
            System.out.println("Favorite Count: " + favoriteCount);
            System.out.println("Watch Count: " + watchCount);
            System.out.println("Ratio: " + ratio);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieRatingsList;
    }
    
    public List<UserRatings> selectTVSeriesRatings(int tvsId) {
        List<UserRatings> movieRatingsList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt1 = con.prepareStatement(SELECT_USER_FAVOURITE_COUNT_BY_TVSeries_ID);
            PreparedStatement stmt2 = con.prepareStatement(SELECT_USER_WATCH_COUNT_BY_TVSeries_ID);
            stmt1.setInt(1, tvsId);
            stmt2.setInt(1, tvsId);
            
            ResultSet rs1 = stmt1.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();

            // Initialize variables to store the counts
            int favoriteCount = 0;
            int watchCount = 0;

            // Retrieve the counts from the result sets
            if (rs1.next()) {
                favoriteCount = rs1.getInt(1); // Assuming the count is in the first column
            }

            if (rs2.next()) {
                watchCount = rs2.getInt(1); // Assuming the count is in the first column
            }

            // Calculate the ratio and store it in a variable
            double ratio = (watchCount != 0) ? (double) favoriteCount / watchCount : 0.0;

            // You can use this ratio for further processing or return it in some way
            System.out.println("Favorite Count: " + favoriteCount);
            System.out.println("Watch Count: " + watchCount);
            System.out.println("Ratio: " + ratio);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieRatingsList;
    }



}
