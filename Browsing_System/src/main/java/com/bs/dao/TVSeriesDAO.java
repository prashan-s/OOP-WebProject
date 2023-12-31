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

	private static final String SELECT_ALL_SERIES = "SELECT tvs_id, title, tvs_img_url, action_category, "
			+ "adventure_category, comedy_category, scify_category, horror_category, romance_category, "
			+ "science_category, crime_category, thriller_category, is_active, row_created_datetime "
			+ "FROM tv_series";

	private static final String SELECT_SERIES_BY_ID = "SELECT tvs_id, title, tvs_img_url, action_category, "
			+ "adventure_category, comedy_category, scify_category, horror_category, romance_category, "
			+ "science_category, crime_category, thriller_category, is_active, row_created_datetime "
			+ "FROM tv_series WHERE tvs_id = ?";

	private static final String INSERT_SERIES = "INSERT INTO tv_series (title, tvs_img_url, action_category, "
			+ "adventure_category, comedy_category, scify_category, horror_category, romance_category, "
			+ "science_category, crime_category, thriller_category) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_SERIES = "UPDATE tv_series SET title=?, tvs_img_url=?, action_category=?, "
			+ "adventure_category=?, comedy_category=?, scify_category=?, horror_category=?, romance_category=?, "
			+ "science_category=?, crime_category=?, thriller_category=?" + "WHERE tvs_id = ?";

	private static final String DELETE_SERIES = "DELETE FROM tv_series WHERE tvs_id = ?";

	// Select all TV series 
	public List<TVSeries> selectAllTVSeries() {
		ArrayList<TVSeries> seriesList = new ArrayList<>();

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_SERIES);
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
				String strIsActive = (isActive) ? "Active" : "InActive";

				Date rowCreatedDatetime = rs.getDate("row_created_datetime");

				TVSeries series = new TVSeries(returnedSeriesId, title, tvsImgUrl, actionCategory, adventureCategory,
						comedyCategory, scifyCategory, horrorCategory, romanceCategory, scienceCategory, crimeCategory,
						thrillerCategory, isActive, rowCreatedDatetime);
				series.setActiveStatus(strIsActive);

				seriesList.add(series);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return seriesList;
	}

	// Select TV series details by id
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

				TVSeries series = new TVSeries(returnedSeriesId, title, tvsImgUrl, actionCategory, adventureCategory,
						comedyCategory, scifyCategory, horrorCategory, romanceCategory, scienceCategory, crimeCategory,
						thrillerCategory, isActive, rowCreatedDatetime);

				seriesList.add(series);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return seriesList;
	}

	// Insert a new TV series
	public boolean insertTVSeries(TVSeries series) {
		System.out.println(INSERT_SERIES);
		boolean rowInserted = false;

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

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	// Update TV series
	public boolean updateTVSeries(TVSeries series) {
		boolean rowUpdate = false;
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

			stmt.setInt(12, series.getTvs_id());

			rowUpdate = (stmt.executeUpdate() > 0);

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
			System.out.println("DELETE TV" + seriesId);
			stmt.setInt(1, seriesId);
			rowDelete = stmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDelete;
	}
}
