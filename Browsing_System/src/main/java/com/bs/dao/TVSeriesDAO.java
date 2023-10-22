package com.bs.dao;

import com.bs.interfaces.ITVSeriesDAO;
import com.bs.model.TVSeries;
import com.bs.utility.DBConnectionMSSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TVSeriesDAO implements ITVSeriesDAO {

    private static final String SELECT_SERIES_BY_ID = "SELECT tvs_id, title, tvs_img_url, action_category, " +
            "adventure_category, comedy_category, scify_category, horror_category, romance_category, " +
            "science_category, crime_category, thriller_category, is_active, row_created_datetime " +
            "FROM tv_series WHERE tvs_id = ?";

    private static final String INSERT_SERIES = "INSERT INTO tv_series (title, tvs_img_url, action_category, " +
            "adventure_category, comedy_category, scify_category, horror_category, romance_category, " +
            "science_category, crime_category, thriller_category, is_active) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_SERIES = "UPDATE tv_series SET title=?, tvs_img_url=?, action_category=?, " +
            "adventure_category=?, comedy_category=?, scify_category=?, horror_category=?, romance_category=?, " +
            "science_category=?, crime_category=?, thriller_category=?, is_active=?, row_created_datetime=? " +
            "WHERE tvs_id = ?";

    private static final String DELETE_SERIES = "UPDATE tv_series SET is_active=0 WHERE tvs_id = ?";

    // Select TV series details
    public List<TVSeries> selectTVSeries(int series_Id) {
        ArrayList<TVSeries> seriesList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_SERIES_BY_ID);
            stmt.setInt(1, series_Id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int returnedSeriesId = rs.getInt("tvs_id");
                String title = rs.getString("title");
                String tvsImgUrl = rs.getString("tvs_img_url");
                boolean actionCategory = rs.getBoolean("action_category");
                boolean adventureCategory = rs.getBoolean("adventure_category");
                boolean comedyCategory = rs.getBoolean("comedy_category");
                boolean scifyCategory = rs.getBoolean("scify_category");
                boolean horrorCategory = rs.getBoolean("horror_category");
                boolean romanceCategory = rs.getBoolean("romance_category");
                boolean scienceCategory = rs.getBoolean("science_category");
                boolean crimeCategory = rs.getBoolean("crime_category");
                boolean thrillerCategory = rs.getBoolean("thriller_category");
                boolean isActive = rs.getBoolean("is_active");
                Date rowCreatedDatetime = rs.getDate("row_created_datetime");

                TVSeries series = new TVSeries(returnedSeriesId, title, tvsImgUrl, actionCategory,
                        adventureCategory, comedyCategory, scifyCategory, horrorCategory,
                        romanceCategory, scienceCategory, crimeCategory, thrillerCategory,
                        isActive, rowCreatedDatetime);

                seriesList.add(series);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return seriesList;
    }

    // Insert a new TV series
    public void insertTVSeries(TVSeries series) {
        System.out.println(INSERT_SERIES);

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_SERIES);

            stmt.setString(1, series.getTitle());
            stmt.setString(2, series.getTvs_img_url());
            stmt.setBoolean(3, series.isAction_category());
            stmt.setBoolean(4, series.isAdventure_category());
            stmt.setBoolean(5, series.isComedy_category());
            stmt.setBoolean(6, series.isScify_category());
            stmt.setBoolean(7, series.isHorror_category());
            stmt.setBoolean(8, series.isRomance_category());
            stmt.setBoolean(9, series.isScience_category());
            stmt.setBoolean(10, series.isCrime_category());
            stmt.setBoolean(11, series.isThriller_category());
            stmt.setBoolean(12, series.isActive());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update TV series
    public boolean updateTVSeries(TVSeries series) {
        boolean rowUpdate = true;
        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_SERIES);

            stmt.setString(1, series.getTitle());
            stmt.setString(2, series.getTvs_img_url());
            stmt.setBoolean(3, series.isAction_category());
            stmt.setBoolean(4, series.isAdventure_category());
            stmt.setBoolean(5, series.isComedy_category());
            stmt.setBoolean(6, series.isScify_category());
            stmt.setBoolean(7, series.isHorror_category());
            stmt.setBoolean(8, series.isRomance_category());
            stmt.setBoolean(9, series.isScience_category());
            stmt.setBoolean(10, series.isCrime_category());
            stmt.setBoolean(11, series.isThriller_category());
            stmt.setBoolean(12, series.isActive());
            stmt.setDate(13, new java.sql.Date(series.getRow_created_datetime().getTime()));

            stmt.setInt(14, series.getTvs_id());

            rowUpdate = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    // Delete TV series
    public boolean deleteTVSeries(int seriesId) {
        boolean rowDelete = false;

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_SERIES);

            stmt.setInt(1, seriesId);
            rowDelete = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
