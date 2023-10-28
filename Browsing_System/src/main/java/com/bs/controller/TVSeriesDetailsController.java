package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.TVSeriesDetailsDAO;
import com.bs.model.TVSeriesDetails;

public class TVSeriesDetailsController {

	RequestDispatcher dispatcher;
	HttpServletRequest request;
	HttpServletResponse response;
	TVSeriesDetailsDAO dao;

	public TVSeriesDetailsController() {

	}

	public TVSeriesDetailsController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dispatcher = request.getRequestDispatcher("TVSeriesDetails.jsp");
		this.dao = new TVSeriesDetailsDAO();
	}

	public void doAction(String action) {
		String jspPage = "TVSeriesDetails.jsp";
		int tvSeriesDetailsId = -1;
		boolean showTVSeriesDetailsIdForm = true;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;
		boolean showAddForm = false;
		boolean showInsertStatus = false;
		boolean showDeleteStatus = false;
		String message;

		switch (action) {

			case "submit":
				showTVSeriesDetailsIdForm = false;
				showDetails = true;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				
				tvSeriesDetailsId = Integer.parseInt(this.request.getParameter("tvSeriesDetailsId"));
				this.selectTVSeriesDetails(tvSeriesDetailsId);

				Cookie cookie = new Cookie("tvSeriesDetailsId", Integer.toString(tvSeriesDetailsId));
				this.response.addCookie(cookie);
				break;

			case "edit":

				
				showTVSeriesDetailsIdForm = false;
				showDetails = false;
				showEditForm = true;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");

				this.selectTVSeriesDetails(tvSeriesDetailsId);

				break;

			case "delete":
				
				showTVSeriesDetailsIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = true;

				tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");

				boolean deleteStatus = deleteTVSeriesDetailsByAdmin(tvSeriesDetailsId);

				if (deleteStatus) {
					message = "Deleted Successfully!";
				} else {
					message = "Delete Failed!";
				}

				request.setAttribute("xmessage", message);
				break;

			case "add":

				
				showTVSeriesDetailsIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = true;
				showInsertStatus = false;
				showDeleteStatus = false;

				tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");

				this.selectTVSeriesDetails(tvSeriesDetailsId);

				break;

			case "insert":

				
				showTVSeriesDetailsIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = true;
				showDeleteStatus = false;

				tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");

				TVSeriesDetails tvSD2 = new TVSeriesDetails();

				tvSD2.setTvsDetailId(tvSeriesDetailsId);
				tvSD2.setTvsId(Integer.parseInt(request.getParameter("tvSid_i")));
				tvSD2.setSeason(Integer.parseInt(request.getParameter("season_i")));
				tvSD2.setEpisode(Integer.parseInt(request.getParameter("episode_i")));
				tvSD2.setDescription(request.getParameter("description_i"));
				tvSD2.setYear(Integer.parseInt(request.getParameter("year_i")));
				tvSD2.setDuration(Integer.parseInt(request.getParameter("duration_i")));
				tvSD2.setQuality(request.getParameter("quality_i"));
				tvSD2.setWatchCount(Integer.parseInt(request.getParameter("watchCount_i")));
				tvSD2.setTvsStreamUrl(request.getParameter("streamUrl_i"));
				tvSD2.setCreatedAdminName(request.getParameter("adminName_i"));

				boolean insertStatus = insertTVSeriesDetailsByAdmin(tvSD2);

				System.out.println(insertStatus);
				message = "Inserted Successfully!";
				System.out.println(message);

				if (insertStatus == false) {
					message = "Insert Failed!, Retry....";
					System.out.println("Edit Form Show:" + showAddForm);
				}

				request.setAttribute("xmessage", message);
				System.out.println("Inserted   " + insertStatus);

				break;

			case "update":

				
				showTVSeriesDetailsIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = true;
				showDeleteStatus = false;

				TVSeriesDetails tvSD = new TVSeriesDetails();

				tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");

				tvSD.setTvsDetailId(tvSeriesDetailsId);
				tvSD.setTvsId(Integer.parseInt(request.getParameter("tvSid")));
				tvSD.setSeason(Integer.parseInt(request.getParameter("season")));
				tvSD.setEpisode(Integer.parseInt(request.getParameter("episode")));
				tvSD.setDescription(request.getParameter("description"));
				tvSD.setYear(Integer.parseInt(request.getParameter("year")));
				tvSD.setDuration(Integer.parseInt(request.getParameter("duration")));
				tvSD.setQuality(request.getParameter("quality"));
				tvSD.setWatchCount(Integer.parseInt(request.getParameter("watchCount")));
				tvSD.setTvsStreamUrl(request.getParameter("streamUrl"));
				tvSD.setCreatedAdminName(request.getParameter("adminName"));

				boolean updateStatus = updateTVSeriesDetailsByAdmin(tvSD);

				System.out.println(updateStatus);
				message = "Updated Successfully!";
				System.out.println(message);

				if (updateStatus == false) {
					message = "Update Failed!, Retry....";
					System.out.println("Edit Form Show:" + showEditForm);
				}

				request.setAttribute("xmessage", message);
				System.out.println("Updated   " + updateStatus);

				break;
		}

		System.out.println("Watiting to Dispatch");
		try {

			System.out.println("showUpdateStatus " + showUpdateStatus);

			request.setAttribute("showTVSeriesDetailsIdForm", showTVSeriesDetailsIdForm);
			request.setAttribute("showDetails", showDetails);
			request.setAttribute("showEditForm", showEditForm);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			request.setAttribute("showAddForm", showAddForm);
			request.setAttribute("showInsertStatus", showInsertStatus);
			request.setAttribute("showDeleteStatus", showDeleteStatus);
			this.dispatcher = request.getRequestDispatcher(jspPage);
			dispatcher.forward(request, response);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private int getValueForId(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int tvSeriesDetailsId = -1;
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					tvSeriesDetailsId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie tvSeriesDetailsId:" + tvSeriesDetailsId);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (tvSeriesDetailsId < 0) {
			try {
				tvSeriesDetailsId = Integer.parseInt(this.request.getParameter("tvSeriesDetailsId"));
			} catch (Exception ex) {
				System.out.println("Error with tvSeriesDetails ID");
			}
		}
		return tvSeriesDetailsId;
	}

	public void selectAllTVSeriesEpisodesDetails() {

		try {
			List<TVSeriesDetails> allTVSeriesEpisodesList = new TVSeriesDetailsDAO().selectAllTVSeriesEpisodesDetails();
			request.setAttribute("allTVSeriesEpisodesList", allTVSeriesEpisodesList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.dispatcher = request.getRequestDispatcher("./pages/admin-portal.jsp");
			this.dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectTVSeriesDetails(int tvsDetailId) {

		try {
			List<TVSeriesDetails> seriesDetailsList = new TVSeriesDetailsDAO().selectTVSeriesDetails(tvsDetailId);
			request.setAttribute("seriesDetailsList", seriesDetailsList);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean updateTVSeriesDetailsByAdmin(TVSeriesDetails tvSeriesDetails) {
		boolean updateStatus = true;
		try {
			updateStatus = dao.updateTVSeriesDetails(tvSeriesDetails);
			request.setAttribute("isSuccessUpdate", updateStatus);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return updateStatus;

	}

	public boolean insertTVSeriesDetailsByAdmin(TVSeriesDetails tvSeriesDetails) {
		boolean insertStatus = false;
		try {
			insertStatus = dao.insertTVSeriesDetails(tvSeriesDetails);
			request.setAttribute("isSuccessInsert", insertStatus);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return insertStatus;
	}

	public boolean deleteTVSeriesDetailsByAdmin(int tvSeiesId) {
		boolean deleteStatus = false;
		try {

			deleteStatus = dao.deleteTVSeriesDetails(tvSeiesId);
			request.setAttribute("isSuccessDelete", deleteStatus);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return deleteStatus;
	}
}
