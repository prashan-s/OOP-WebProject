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

		switch (action) {

		case "submit":
			showTVSeriesDetailsIdForm = false;
			showDetails = true;
			showEditForm = false;
			showUpdateStatus = false;

			jspPage = "TVSeriesDetails.jsp";
			tvSeriesDetailsId = Integer.parseInt(this.request.getParameter("tvSeriesDetailsId"));
			this.selectTVSeriesDetails(tvSeriesDetailsId);

			Cookie cookie = new Cookie("tvSeriesDetailsId", Integer.toString(tvSeriesDetailsId));
			this.response.addCookie(cookie);
			break;

		case "edit":

			jspPage = "TVSeriesDetails.jsp";
			showTVSeriesDetailsIdForm = false;
			showDetails = false;
			showEditForm = true;
			showUpdateStatus = false;

			tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");

			this.selectTVSeriesDetails(tvSeriesDetailsId);

			break;
			
		case "update":
			
			jspPage = "TVSeriesDetails.jsp";
			showTVSeriesDetailsIdForm = false;
			showDetails = false;
			showEditForm = false;
			showUpdateStatus = true;
			
			TVSeriesDetails tvSD = new TVSeriesDetails();
			
			tvSeriesDetailsId = getValueForId("tvSeriesDetailsId");
			
			tvSD.setTvsDetailId(tvSeriesDetailsId);
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
			String message = "Updated Successfully!";
			System.out.println(message);
			
			if (updateStatus == false) {
				message = "Update Failed!, Retry....";
				System.out.println("Edit Form Show:" + showEditForm);
			}
			
			request.setAttribute("xmessage", message);
			System.out.println("Updated   " + updateStatus);
		}
		
		System.out.println("Watiting to Dispatch");
		try {

			System.out.println("showUpdateStatus " + showUpdateStatus);
			
			request.setAttribute("showTVSeriesDetailsIdForm", showTVSeriesDetailsIdForm);
			request.setAttribute("showDetails", showDetails);
			request.setAttribute("showEditForm", showEditForm);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			
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
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		return deleteStatus;
	}
}
