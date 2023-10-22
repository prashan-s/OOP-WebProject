package com.bs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.bs.controller.UserRatingsController;

@WebServlet(name = "UserRatingsServlet", urlPatterns = {"/UserRatingsServlet"})
public class UserRatingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserRatingsController controller;

    public UserRatingsServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet : UserRatingsServlet");
        this.controller = new UserRatingsController(request, response);

        // Perform any additional logic for doGet if needed
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost : UserRatingsServlet");

        Integer rateId = Integer.parseInt(request.getParameter("rateId"));

        this.controller = new UserRatingsController(request, response);
        this.controller.selectUserRatings(rateId);
    }
    	
}
