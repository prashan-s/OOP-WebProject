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
}
