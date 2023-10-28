package com.bs.controller;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
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

    public void doAction(String action) {
        String jspPage = "UserFavourites.jsp";
        Integer favId = -1;
        boolean showUserFavIdForm = true;
        boolean showDetails = false;
        boolean showEditForm = false;
        boolean showUpdateStatus = false;
        boolean showAddForm = false;
        boolean showInsertStatus = false;
        boolean showDeleteStatus = false;
        String message;

        switch (action) {

            case "submit":
                showUserFavIdForm = false;
                showDetails = true;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = false;
                showDeleteStatus = false;

                favId = Integer.parseInt(this.request.getParameter("favId"));
                this.selectUserFavourites(favId);

                Cookie cookie = new Cookie("favId", Integer.toString(favId));
                this.response.addCookie(cookie);
                break;

            case "edit":

                showUserFavIdForm = false;
                showDetails = false;
                showEditForm = true;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = false;
                showDeleteStatus = false;

                favId = getValueForId("favId");

                this.selectUserFavourites(favId);
                break;

            case "delete":

                showUserFavIdForm = false;
                showDetails = false;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = false;
                showDeleteStatus = true;

                favId = getValueForId("favId");

                boolean deleteStatus = deleteFavouritesByUser(favId);

                if (deleteStatus) {
                    message = "Deleted Successfully!";
                } else {
                    message = "Delete Failed!";
                }

                request.setAttribute("xmessage", message);
                break;

            case "add":

                showUserFavIdForm = false;
                showDetails = false;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = true;
                showInsertStatus = false;
                showDeleteStatus = false;
                break;

            case "insert":

                showUserFavIdForm = false;
                showDetails = false;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = true; // Keep the "Add User Favourite" form visible
                showInsertStatus = true;
                showDeleteStatus = false;

                // Retrieve the data from the request
                int userId = Integer.parseInt(this.request.getParameter("userId"));
                String type = this.request.getParameter("type");
                int tvsId = Integer.parseInt(this.request.getParameter("tvsId"));
                int movieId = Integer.parseInt(this.request.getParameter("movieId"));

                // Create a UserFavourites object
                UserFavourites userFavourite = new UserFavourites(-1, userId, type, tvsId, movieId, null);

                // Insert the new UserFavourite
                boolean insertStatus = insertUserFavourite(userFavourite);

                if (insertStatus) {
                    message = "User Favourite added successfully!";
                } else {
                    message = "Failed to add User Favourite!";
                }

                request.setAttribute("xmessage", message);
                break;

        }

        System.out.println("Waiting to Dispatch");
        try {
            request.setAttribute("showUserFavIdForm", showUserFavIdForm);
            request.setAttribute("showDetails", showDetails);
            request.setAttribute("showEditForm", showEditForm);
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

    public void selectUserFavourites(int favId) {
        try {
            List<UserFavourites> userFavouritesList = new UserFavouritesDAO().selectUserFavourites(favId);
            request.setAttribute("userFavouritesList", userFavouritesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getValueForId(String key) {
        Cookie[] cookies = request.getCookies();
        int favId = -1;
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(key)) {
                    favId = Integer.parseInt(ck.getValue());
                    System.out.println("Cookie favId: " + favId);
                    break;
                }
            }
        } else {
            System.out.println("No cookies found!");
        }

        if (favId < 0) {
            try {
                favId = Integer.parseInt(this.request.getParameter("favId"));
            } catch (Exception ex) {
                System.out.println("Error with UserFavourites ID");
            }
        }
        return favId;
    }

    public boolean deleteFavouritesByUser(int favId) {
        boolean deleteStatus = false;
        try {
            deleteStatus = new UserFavouritesDAO().deleteUserFavourite(favId);
            request.setAttribute("isSuccessDelete", deleteStatus);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return deleteStatus;
    }

    public boolean insertUserFavourite(UserFavourites userFavourite) {
        boolean insertStatus = false;
        try {
            insertStatus = new UserFavouritesDAO().insertUserFavourite(userFavourite);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertStatus;
    }
}
