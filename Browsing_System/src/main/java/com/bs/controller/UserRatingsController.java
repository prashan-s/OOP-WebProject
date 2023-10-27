package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.UserRatingsDAO;
import com.bs.model.UserRatings;

public class UserRatingsController {

    private RequestDispatcher dispatcher1;
    private RequestDispatcher dispatcher2;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserRatingsController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.dispatcher1 = request.getRequestDispatcher("UserRatings.jsp");
        this.dispatcher2 = request.getRequestDispatcher("Movie.jsp");
    }

    public void selectUserRatings(int rateId) {
        try {
            List<UserRatings> userRatingsList = new UserRatingsDAO().selectUserRatings(rateId);
            if (!userRatingsList.isEmpty()) {
                System.out.println("User Ratings: " + userRatingsList.get(0).getRateId());
            }
            request.setAttribute("userRatingsList", userRatingsList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dispatcher1.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectMovieRatings(int movieId) {
        try {
            List<UserRatings> movieRatingsList = new UserRatingsDAO().selectMovieRatings(movieId);
            if (!movieRatingsList.isEmpty()) {
                System.out.println("User Ratings: " + movieRatingsList.get(0).getRateId());
            }
            request.setAttribute("userRatingsList", movieRatingsList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dispatcher2.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
