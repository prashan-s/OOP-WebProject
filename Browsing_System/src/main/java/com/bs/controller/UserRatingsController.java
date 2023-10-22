package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.UserRatingsDAO;
import com.bs.model.UserRatings;

public class UserRatingsController {

    private RequestDispatcher dispatcher;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserRatingsController() {

    }

    public UserRatingsController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.dispatcher = request.getRequestDispatcher("UserRatings.jsp");
    }

    public void selectUserRatings(int rateId) {

        try {
            List<UserRatings> userRatingsList = new UserRatingsDAO().selectUserRatings(rateId);
            System.out.println("User Ratings: " + userRatingsList.get(0).getRateId());
            request.setAttribute("userRatingsList", userRatingsList);
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
