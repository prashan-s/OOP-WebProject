package com.bs.controller;

import com.bs.dao.MovieDAO;
import com.bs.dao.TVSeriesDAO;
import com.bs.model.Movie;
import com.bs.model.TVSeries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		this.dispatcher = request.getRequestDispatcher("TVSeries.jsp");
		this.dao = new TVSeriesDAO();
	}

	public void doAction(String action) {

		String jspPage = "TVSeries.jsp";
		Integer tvssId = -1;
		boolean showTVSeriesIdForm = true;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;
		boolean showAddForm = false;
		boolean showInsertStatus = false;
		boolean showDeleteStatus = false;
		String message;

		switch (action) {

			case "submit":
				showTVSeriesIdForm = false;
				showDetails = true;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				tvssId = Integer.parseInt(this.request.getParameter("tvsId"));
				this.selectTVSeries(tvssId);

				Cookie cookie = new Cookie("tvsId", Integer.toString(tvssId));
				this.response.addCookie(cookie);
				break;

			case "edit":

				showTVSeriesIdForm = false;
				showDetails = false;
				showEditForm = true;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				tvssId = getValueForId("tvsId");

				this.selectTVSeries(tvssId);

				break;

			case "delete":

				showTVSeriesIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = true;

				tvssId = getValueForId("tvsId");

				boolean deleteStatus = deleteTVSeriesByAdmin(tvssId);

				if (deleteStatus) {
					message = "Deleted Successfully!";
				} else {
					message = "Delete Failed!";
				}

				request.setAttribute("xmessage", message);
				break;

			case "add":

				showTVSeriesIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = true;
				showInsertStatus = false;
				showDeleteStatus = false;

				tvssId = getValueForId("tvsId");

				this.selectTVSeries(tvssId);

				break;

			case "insert":

				showTVSeriesIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = true;
				showDeleteStatus = false;

				tvssId = getValueForId("tvsId");

				TVSeries tvS2 = new TVSeries();

				tvS2.setTvs_id(tvssId);
				tvS2.setTitle(request.getParameter("tvSeriesTitle_i"));
				tvS2.setTvs_img_url(request.getParameter("tvSeriesUrl_i"));
				tvS2.setAction_category(Boolean.parseBoolean("action_category_i"));
				tvS2.setAdventure_category(Boolean.parseBoolean("adventure_category_i"));
				tvS2.setComedy_category(Boolean.parseBoolean("comedy_category_i"));
				;
				tvS2.setScify_category(Boolean.parseBoolean("scify_category_i"));
				tvS2.setHorror_category(Boolean.parseBoolean("horror_category_i"));
				tvS2.setRomance_category(Boolean.parseBoolean("romance_category_i"));
				tvS2.setScience_category(Boolean.parseBoolean("science_category_i"));
				tvS2.setCrime_category(Boolean.parseBoolean("crime_category_i"));
				tvS2.setThriller_category(Boolean.parseBoolean("thriller_category"));

				boolean insertStatus = insertTVSeriesByAdmin(tvS2);

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

				showTVSeriesIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = true;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

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

			System.out.println("showUpdateStatus" + showUpdateStatus);

			request.setAttribute("showTVSeriesIdForm", showTVSeriesIdForm);
			request.setAttribute("showDetails", showDetails);
			request.setAttribute("showEditForm", showEditForm);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
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
		int tvSeriesId = -1;
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					tvSeriesId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie  tvSeriesId:" + tvSeriesId);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (tvSeriesId < 0) {
			try {
				tvSeriesId = Integer.parseInt(this.request.getParameter("tvsId"));
			} catch (Exception ex) {
				System.out.println("Error with tv series ID");
			}
		}
		return tvSeriesId;
	}

	public void selectAllTvSeries() {

		try {
			List<TVSeries> seriesList = new TVSeriesDAO().selectAllTVSeries();
			System.out.println("TV Series: " + seriesList.getFirst().getTitle());
			request.setAttribute("seriesList", seriesList);

			try {

				this.dispatcher = request.getRequestDispatcher("./WebApp/pages/admin-portal.jsp");
				this.dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
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
			updateStatus = dao.updateTVSeries(tvseries);
			request.setAttribute("isSuccessUpdate", updateStatus);
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
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return deleteStatus;
	}

}
