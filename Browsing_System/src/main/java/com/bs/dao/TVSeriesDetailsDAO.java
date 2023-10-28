package com.bs.dao;

import com.bs.interfaces.ITVSeriesDetailsDAO;
import com.bs.model.TVSeriesDetails;
import com.bs.utility.DBConnectionMSSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class TVSeriesDetailsDAO implements ITVSeriesDetailsDAO {

	private static final String SELECT_ALL_TV_SERIES_BY_ID = "SELECT tvs_detail_id, tvs_id, season, episode, description, year, duration, quality, " +
            "watch_count, tvs_stream_url, created_admin_name, is_active, row_created_datetime " +
            "FROM tv_series_details";
	
    private static final String SELECT_TV_SERIES_BY_ID = "SELECT tvs_detail_id, tvs_id, season, episode, description, year, duration, quality, " +
            "watch_count, tvs_stream_url, created_admin_name, is_active, row_created_datetime " +
            "FROM tv_series_details " +
            "WHERE tvs_detail_id = ?";

    private static final String INSERT_TV_SERIES = "INSERT INTO tv_series_details (tvs_id, season, episode, description, year, duration, quality, " +
            "watch_count, tvs_stream_url, created_admin_name) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_TV_SERIES = "UPDATE tv_series_details SET tvs_id=?, season=?, episode=?, description=?, year=?, " +
            "duration=?, quality=?, watch_count=?, tvs_stream_url=?, created_admin_name=? " +
            "WHERE tvs_detail_id=?";

    private static final String DELETE_TV_SERIES = "UPDATE tv_series_details SET is_active=0 WHERE tvs_detail_id=?";

    // Select All TV series details
    public List<TVSeriesDetails> selectAllTVSeriesEpisodesDetails() {
        ArrayList<TVSeriesDetails> seriesDetailsList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_TV_SERIES_BY_ID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int tvsDetailIdReturned = rs.getInt("tvs_detail_id");
                int tvsId = rs.getInt("tvs_id");
                int season = rs.getInt("season");
                int episode = rs.getInt("episode");
                String description = rs.getString("description");
                int year = rs.getInt("year");
                int duration = rs.getInt("duration");
                String quality = rs.getString("quality");
                int watchCount = rs.getInt("watch_count");
                String tvsStreamUrl = rs.getString("tvs_stream_url");
                String createdAdminName = rs.getString("created_admin_name");
                boolean isActive = rs.getBoolean("is_active");
                Date rowCreatedDatetime = rs.getDate("row_created_datetime");

                TVSeriesDetails seriesDetails = new TVSeriesDetails(tvsDetailIdReturned, tvsId, season, episode, description,
                        year, duration, quality, watchCount, tvsStreamUrl, createdAdminName, isActive, rowCreatedDatetime);

                seriesDetailsList.add(seriesDetails);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return seriesDetailsList;
    }
    
    // Select TV series details
    public List<TVSeriesDetails> selectTVSeriesDetails(int tvsDetailId) {
        ArrayList<TVSeriesDetails> seriesDetailsList = new ArrayList<>();

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_TV_SERIES_BY_ID);
            stmt.setInt(1, tvsDetailId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int tvsDetailIdReturned = rs.getInt("tvs_detail_id");
                int tvsId = rs.getInt("tvs_id");
                int season = rs.getInt("season");
                int episode = rs.getInt("episode");
                String description = rs.getString("description");
                int year = rs.getInt("year");
                int duration = rs.getInt("duration");
                String quality = rs.getString("quality");
                int watchCount = rs.getInt("watch_count");
                String tvsStreamUrl = rs.getString("tvs_stream_url");
                String createdAdminName = rs.getString("created_admin_name");
                boolean isActive = rs.getBoolean("is_active");
                Date rowCreatedDatetime = rs.getDate("row_created_datetime");

                TVSeriesDetails seriesDetails = new TVSeriesDetails(tvsDetailIdReturned, tvsId, season, episode, description,
                        year, duration, quality, watchCount, tvsStreamUrl, createdAdminName, isActive, rowCreatedDatetime);

                seriesDetailsList.add(seriesDetails);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return seriesDetailsList;
    }

    // Inserting a new TV series details
    public boolean insertTVSeriesDetails(TVSeriesDetails seriesDetails) {
        System.out.println(INSERT_TV_SERIES);
        boolean rowInserted = false;

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_TV_SERIES);

            stmt.setInt(1, seriesDetails.getTvsId());
            stmt.setInt(2, seriesDetails.getSeason());
            stmt.setInt(3, seriesDetails.getEpisode());
            stmt.setString(4, seriesDetails.getDescription());
            stmt.setInt(5, seriesDetails.getYear());
            stmt.setInt(6, seriesDetails.getDuration());
            stmt.setString(7, seriesDetails.getQuality());
            stmt.setInt(8, seriesDetails.getWatchCount());
            stmt.setString(9, seriesDetails.getTvsStreamUrl());
            stmt.setString(10, seriesDetails.getCreatedAdminName());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rowInserted;
    }

    // Update TV series details
    public boolean updateTVSeriesDetails(TVSeriesDetails seriesDetails) {

        boolean rowUpdate = false;
        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_TV_SERIES);

            stmt.setInt(1, seriesDetails.getTvsId());
            stmt.setInt(2, seriesDetails.getSeason());
            stmt.setInt(3, seriesDetails.getEpisode());
            stmt.setString(4, seriesDetails.getDescription());
            stmt.setInt(5, seriesDetails.getYear());
            stmt.setInt(6, seriesDetails.getDuration());
            stmt.setString(7, seriesDetails.getQuality());
            stmt.setInt(8, seriesDetails.getWatchCount());
            stmt.setString(9, seriesDetails.getTvsStreamUrl());
            stmt.setString(10, seriesDetails.getCreatedAdminName());

            stmt.setInt(11, seriesDetails.getTvsDetailId());

            rowUpdate = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdate;

    }

    // Delete TV series details
    public boolean deleteTVSeriesDetails(int tvsDetailId) {

        boolean rowDelete = false;

        try {
            Connection con = DBConnectionMSSQL.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_TV_SERIES);

            stmt.setInt(1, tvsDetailId);
            rowDelete = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
