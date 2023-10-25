package com.bs.controller;

import com.bs.dao.TVSeriesDAO;
import com.bs.model.TVSeries;
import com.bs.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.util.List;

public class TVSeriesController {

	RequestDispatcher dispatcher;
	HttpServletRequest request;
	HttpServletResponse response;
	TVSeriesDAO dao;

	public TVSeriesController() {

	}

	public TVSeriesController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new TVSeriesDAO();
	}

	public void doAction(String action) {

		String jspPage = "TVSeries.jsp";
		int tvssId = -1;
		boolean showTVSeriesIdForm = true;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;

		switch (action) {

		case "submit":
			showTVSeriesIdForm = false;
			showDetails = true;
			showEditForm = false;
			showUpdateStatus = false;

			jspPage = "TVSeries.jsp";
			tvssId = Integer.parseInt(this.request.getParameter("tvsId"));
			this.selectTVSeries(tvssId);

			Cookie cookie = new Cookie("tvsId", Integer.toString(tvssId));
			this.response.addCookie(cookie);
			break;

		case "edit":
			jspPage = "TVSeries.jsp";
			showTVSeriesIdForm = false;
			showDetails = false;
			showEditForm = true;
			showUpdateStatus = false;

			tvssId = getValueForId("tvsId");

			this.selectTVSeries(tvssId);

			break;

		case "update":

			jspPage = "TVSeries.jsp";
			showTVSeriesIdForm = false;
			showDetails = false;
			showEditForm = false;
			showUpdateStatus = true;

			TVSeries tvs = new TVSeries();
			
			tvssId = getValueForId("tvsId");
			String title = request.getParameter("tvSeriesTitle");
			String imageUrl = request.getParameter("tvSeriesUrl");
			boolean actionC = Boolean.parseBoolean(request.getParameter("action_category"));
			boolean adventure = Boolean.parseBoolean(request.getParameter("adventure_category"));
			boolean comedy = Boolean.parseBoolean(request.getParameter("action_category"));
			boolean scify = Boolean.parseBoolean(request.getParameter("scify_category"));
			boolean horror = Boolean.parseBoolean(request.getParameter("horror_category"));
			boolean romance = Boolean.parseBoolean(request.getParameter("romance_category"));
			boolean science = Boolean.parseBoolean(request.getParameter("science_category"));
			boolean crime = Boolean.parseBoolean(request.getParameter("crime_category"));
			boolean thriller = Boolean.parseBoolean(request.getParameter("thriller_category"));

			tvs.setTvs_id(tvssId);
			tvs.setTitle(title);
			tvs.setTvs_img_url(imageUrl);
			tvs.setAction_category(actionC);
			tvs.setAdventure_category(adventure);
			tvs.setComedy_category(comedy);
			tvs.setScify_category(scify);
			tvs.setHorror_category(horror);
			tvs.setRomance_category(romance);
			tvs.setScience_category(science);
			tvs.setCrime_category(crime);
			tvs.setThriller_category(thriller);

			boolean updateStatus = updateTVSeriesByAdmin(tvs);

			System.out.println(updateStatus);
			String message = "Updated Successfully!";
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

			System.out.println("showUpdateStatus" + showUpdateStatus);

			request.setAttribute("showTVSeriesIdForm", showTVSeriesIdForm);
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
		int tvSeriesId = -1;
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					tvSeriesId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie UserID:" + tvSeriesId);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (tvSeriesId < 0) {
			try {
				tvSeriesId = Integer.parseInt(this.request.getParameter("userId"));
			} catch (Exception ex) {
				System.out.println("Error with tv series ID");
			}
		}
		return tvSeriesId;
	}

	public void selectTVSeries(int seriesId) {
		try {
			List<TVSeries> seriesList = new TVSeriesDAO().selectTVSeries(seriesId);
			System.out.println("TV Series: " + seriesList.getFirst().getTitle());
			request.setAttribute("seriesList", seriesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateTVSeriesByAdmin(TVSeries tvseries) {
		boolean updateStatus = false;
		try {
			updateStatus  = dao.updateTVSeries(tvseries);
			request.setAttribute("isSuccessUpdate", updateStatus );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return updateStatus;
	}

	public boolean insertTVSeriesByAdmin(TVSeries tvseries) {
		boolean insertStatus = false;
		try {
			insertStatus = dao.insertTVSeries(tvseries);
			request.setAttribute("isSuccessInsert", insertStatus);
		} catch (Exception e1) {
			e1.printStackTrace();			
		}

		return insertStatus;
	}
	
	public boolean deleteTVSeriesByAdmin(int tvSeiesId) {
		boolean deleteStatus = false;
		try {

			deleteStatus = dao.deleteTVSeries(tvSeiesId);
			request.setAttribute("isSuccessDelete", deleteStatus);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		return deleteStatus;
	}


}
