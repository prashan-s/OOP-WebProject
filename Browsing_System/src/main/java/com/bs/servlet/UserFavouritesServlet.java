package com.bs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bs.controller.UserFavouritesController;

@WebServlet(name = "UserFavouritesServlet", urlPatterns = {"/UserFavouritesServlet"})
public class UserFavouritesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserFavouritesController controller;

    public UserFavouritesServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet : UserFavouritesServlet");
        this.controller = new UserFavouritesController(request, response);

        // Perform any additional logic for doGet if needed
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost : UserFavouritesServlet");

        int userId = Integer.parseInt(request.getParameter("userId"));

        this.controller = new UserFavouritesController(request, response);
        this.controller.selectUserFavourites(userId);
    }
}
