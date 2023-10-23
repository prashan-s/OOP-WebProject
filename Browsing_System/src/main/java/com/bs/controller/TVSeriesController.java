package com.bs.controller;

import com.bs.dao.TVSeriesDAO;
import com.bs.model.TVSeries;
import com.bs.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class TVSeriesController {

	private RequestDispatcher dispatcher;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TVSeriesDAO dao;

	public TVSeriesController() {

	}

	public TVSeriesController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dispatcher = request.getRequestDispatcher("TVSeries.jsp");
		this.dao = new TVSeriesDAO();
	}

	public void selectTVSeries(int seriesId) {
		try {
			List<TVSeries> seriesList = new TVSeriesDAO().selectTVSeries(seriesId);
			System.out.println("TV Series: " + seriesList.getFirst().getTitle());
			request.setAttribute("seriesList", seriesList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doAction(String action) {
		
		String jspPage = "TVSeries.jsp";
		int tvsId = -1;
		boolean showTVSeriesIdForm = true;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;
		
		switch(action) {
		
		case "Click Here":
			showTVSeriesIdForm = false;
			showDetails = true;
			showEditForm = false;
			showUpdateStatus = false;
			
			jspPage = "tvSeries.jsp";
			tvsId = Integer.parseInt(this.request.getParameter("tvsId"));
			this.selectTVSeries(tvsId);
			
			Cookie cookie = new Cookie("tvsId",Integer.toString(tvsId) );
			this.response.addCookie(cookie);
			break;
		
		case "Add":
			jspPage = "tvSeries.jsp";
			showTVSeriesIdForm = false;
			showDetails = false;
			showEditForm = false;
			showUpdateStatus = true;			

			TVSeries tvs = new TVSeries();

			Integer tvSId = Integer.parseInt(request.getParameter("tvsId"));
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

			tvs.setTvs_id(tvSId);
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
			
			this.dao.insertTVSeries(tvs);			
			
			boolean insertedStatus = insertTVSeriesByAdmin(tvs);
			
			break;
			
			case "Edit":
				
				jspPage = "tvSeries.jsp";
				showTVSeriesIdForm = false;
				showDetails = false;
				showEditForm = true;
				showUpdateStatus = false;			

				TVSeries tvsEdit = new TVSeries();

				//Integer tvSIdEdit = Integer.parseInt(request.getParameter("tvsId"));
				String titleEdit = request.getParameter("tvSeriesTitle");
				String imageUrlEdit = request.getParameter("tvSeriesUrl");
				boolean actionCEdit = Boolean.parseBoolean(request.getParameter("action_category"));
				boolean adventureEdit = Boolean.parseBoolean(request.getParameter("adventure_category"));
				boolean comedyEdit = Boolean.parseBoolean(request.getParameter("action_category"));
				boolean scifyEdit = Boolean.parseBoolean(request.getParameter("scify_category"));
				boolean horrorEdit = Boolean.parseBoolean(request.getParameter("horror_category"));
				boolean romanceEdit = Boolean.parseBoolean(request.getParameter("romance_category"));
				boolean scienceEdit = Boolean.parseBoolean(request.getParameter("science_category"));
				boolean crimeEdit = Boolean.parseBoolean(request.getParameter("crime_category"));
				boolean thrillerEdit = Boolean.parseBoolean(request.getParameter("thriller_category"));

				//tvsEdit.setTvs_id(tvSIdEdit);
				tvsEdit.setTitle(titleEdit);
				tvsEdit.setTvs_img_url(imageUrlEdit);
				tvsEdit.setAction_category(actionCEdit);
				tvsEdit.setAdventure_category(adventureEdit);
				tvsEdit.setComedy_category(comedyEdit);
				tvsEdit.setScify_category(scifyEdit);
				tvsEdit.setHorror_category(horrorEdit);
				tvsEdit.setRomance_category(romanceEdit);
				tvsEdit.setScience_category(scienceEdit);
				tvsEdit.setCrime_category(crimeEdit);
				tvsEdit.setThriller_category(thrillerEdit);
				
				this.dao.updateTVSeries(tvsEdit);			
				
				boolean updateStatus = updateTVSeriesByAdmin(tvsEdit);
				
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

				System.out.println("showUpdateStatus" + showUpdateStatus);
				
				request.setAttribute("showUserIdForm", showTVSeriesIdForm);
				request.setAttribute("showDetails", showDetails);
				request.setAttribute("showEditForm", showEditForm);
				request.setAttribute("showUpdateStatus", showUpdateStatus);
				
				this.dispatcher = request.getRequestDispatcher(jspPage);
				dispatcher.forward(request, response);

			} catch (Exception e2) {
				e2.printStackTrace();
			}
				
				//break;		
				
		}			
			
	

	
	private int getValueForId(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int tvSeriesId = -1;
		if( cookies != null ) {
		    
		    for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					tvSeriesId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie UserID:"+ tvSeriesId);
					
					break;
				}
			}
		 } else {
			 System.out.println("No cookies found!");
		 }
		
		if (tvSeriesId < 0) {
			try {
				tvSeriesId = Integer.parseInt(this.request.getParameter("userId"));
			}catch( Exception ex){
				System.out.println("Error with User ID");
			}
		}
		return tvSeriesId;
	}
		
	public boolean insertTVSeriesByAdmin(TVSeries tvseries){
		try {
			boolean successInsert = dao.insertTVSeries(tvseries);
			request.setAttribute("isSuccessInsert", successInsert);
			return true;
		}catch(Exception e1) {
			e1.printStackTrace();
			return false;
		}
			
	}

	public boolean updateTVSeriesByAdmin(TVSeries tvseries) {
		try {
			boolean successUpdate = dao.updateTVSeries(tvseries);
			request.setAttribute("isSuccessUpdate", successUpdate);
			return true;
		}catch(Exception e1) {
			e1.printStackTrace();
			return false;
		}			
	}
}
