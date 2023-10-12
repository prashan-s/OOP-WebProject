package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.dao.UserFavouritesDAO;
import com.bs.model.UserFavourites;

public class UserFavouritesController {

    private RequestDispatcher dispatcher;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserFavouritesController() {

    }

    public UserFavouritesController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.dispatcher = request.getRequestDispatcher("UserFavourites.jsp");
    }

    public void selectUserFavourites(int userId) {

        try {
            List<UserFavourites> userFavouritesList = new UserFavouritesDAO().selectUserFavourites(userId);
            System.out.println("User Favourites: " + userFavouritesList.size());
            request.setAttribute("userFavouritesList", userFavouritesList);
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
