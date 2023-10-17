package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.TVSeriesDetailsDAO;
import com.bs.model.TVSeriesDetails;

public class TVSeriesDetailsController {

    RequestDispatcher dispatcher;
    HttpServletRequest request;
    HttpServletResponse response;

    public TVSeriesDetailsController() {

    }

    public TVSeriesDetailsController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.dispatcher = request.getRequestDispatcher("TVSeriesDetails.jsp");
    }

    public void selectTVSeriesDetails(int tvsDetailId) {

        try {
            List<TVSeriesDetails> seriesDetailsList = new TVSeriesDetailsDAO().selectTVSeries(tvsDetailId);
            System.out.println("TV Series Details: "  + seriesDetailsList.get(1).getSeason() + seriesDetailsList.get(2).getEpisode()+ seriesDetailsList.get(3).getDescription() + seriesDetailsList.get(4).getYear()+ + seriesDetailsList.get(5).getDuration());
            request.setAttribute("seriesDetailsList", seriesDetailsList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

