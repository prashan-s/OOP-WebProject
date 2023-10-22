package com.bs.dao;

import com.bs.interfaces.IUserFavouriteDAO;
import com.bs.model.UserFavourites;
import com.bs.utility.DBConnectionMSSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class UserFavouritesDAO implements IUserFavouriteDAO {

    private static final String SELECT_USER_FAVOURITES_BY_USER_ID = "SELECT fav_id, user_id, type, tvs_id, movie_Id, row_created_datetime " +
            "FROM user_favourite " +
            "WHERE user_id = ?";

    private static final String INSERT_USER_FAVOURITE = "INSERT INTO user_favourite (user_id, type, tvs_id, movie_Id) " +
            "VALUES (?, ?, ?, ?)";

    private static final String DELETE_USER_FAVOURITE = "DELETE FROM user_favourite WHERE fav_id = ?";

    @Override
    public List<UserFavourites> selectUserFavourites(int favId) {
        ArrayList<UserFavourites> userFavouritesList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_USER_FAVOURITES_BY_USER_ID);
            stmt.setInt(1, favId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int returnFavId = rs.getInt("fav_id");
                int returnedUserId = rs.getInt("user_id");
                String type = rs.getString("type");
                int tvsId = rs.getInt("tvs_id");
                int movieId = rs.getInt("movie_Id");
                Date rowCreatedDatetime = rs.getDate("row_created_datetime");

                UserFavourites userFavourites = new UserFavourites(returnFavId, returnedUserId, type, tvsId, movieId, rowCreatedDatetime);
                userFavouritesList.add(userFavourites);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userFavouritesList;
    }

    @Override
    public void insertUserFavourite(UserFavourites userFavourite) {
        System.out.println(INSERT_USER_FAVOURITE);

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_USER_FAVOURITE);

            stmt.setInt(1, userFavourite.getUserId());
            stmt.setString(2, userFavourite.getType());
            stmt.setInt(3, userFavourite.getTvsId());
            stmt.setInt(4, userFavourite.getMovieId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteUserFavourite(int favId) {
        boolean rowDelete = false;

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_USER_FAVOURITE);

            stmt.setInt(1, favId);
            rowDelete = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowDelete;
    }
}
