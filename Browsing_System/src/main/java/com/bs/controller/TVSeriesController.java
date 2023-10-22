package com.bs.controller;

import com.bs.dao.TVSeriesDAO;
import com.bs.model.TVSeries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.util.List;

public class TVSeriesController {

    private RequestDispatcher dispatcher;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public TVSeriesController() {

    }

    public TVSeriesController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.dispatcher = request.getRequestDispatcher("TVSeries.jsp");
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
    
    String buttonType;
    	
    	public void addTVSeries() {
        	try {
        		    		
        		TVSeries tvs = new TVSeries();
        		
        		String title = request.getParameter("tvSeriesTitle");
        		String imageUrl = request.getParameter("tvSeriesUrl");
        		boolean action = Boolean.parseBoolean(request.getParameter("action_category"));
        		boolean adventure = Boolean.parseBoolean(request.getParameter("adventure_category"));
        		boolean comedy = Boolean.parseBoolean(request.getParameter("action_category"));
        		boolean scify = Boolean.parseBoolean(request.getParameter("scify_category"));
        		boolean horror = Boolean.parseBoolean(request.getParameter("horror_category"));
        		boolean romance = Boolean.parseBoolean(request.getParameter("romance_category"));
        		boolean science = Boolean.parseBoolean(request.getParameter("science_category"));
        		boolean crime = Boolean.parseBoolean(request.getParameter("crime_category"));
        		boolean thriller = Boolean.parseBoolean(request.getParameter("thriller_category"));
        		
        		
        		tvs.setTitle(title);
        		tvs.setTvs_img_url(imageUrl);
        		tvs.setAction_category(action);
        		tvs.setAdventure_category(adventure);
        		tvs.setComedy_category(comedy);
        		tvs.setScify_category(scify);
        		tvs.setHorror_category(horror);
        		tvs.setRomance_category(romance);
        		tvs.setScience_category(science);
        		tvs.setCrime_category(crime);
        		tvs.setThriller_category(thriller);
        		//isTrue = dao.insertTVSeries(title,imageUrl,action, adventure, comedy, scify, horror, romance,science,crime, thriller);
        		
//        		    		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	 try {
        		 dispatcher.forward(request, response);
        	 } catch (Exception e) {
        	     e.printStackTrace();
        	 } 
    
    
    	 
    }
}
