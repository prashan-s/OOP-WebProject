package com.bs.controller;

import java.util.List;
import com.bs.dao.UserRatingsDAO;
import com.bs.model.UserRatings;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserRatingsController {

    private RequestDispatcher dispatcher;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserRatingsController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.dispatcher = request.getRequestDispatcher("UserRatings.jsp");
    }

    public void doAction(String action) {
        String jspPage = "UserRatings.jsp";
        int rateId = -1;
        boolean showRateIdForm = true;
        boolean showDetails = false;
        boolean showEditForm = false;
        boolean showUpdateStatus = false;
        boolean showAddForm = false;
        boolean showInsertStatus = false;
        boolean showDeleteStatus = false;
        String message;

        switch (action) {
            case "submit":
                showRateIdForm = false;
                showDetails = true;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = false;
                showDeleteStatus = false;
                
                jspPage = "UserRatings.jsp";
                rateId = Integer.parseInt(request.getParameter("rateId"));
                this.selectUserRatings(rateId);
                break;
                
            case "edit":
                jspPage = "UserRatings.jsp";
                showRateIdForm = false;
                showDetails = false;
                showEditForm = true;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = false;
                showDeleteStatus = false;
                
                rateId = getValueForId("rateId");
                this.selectUserRatings(rateId);
                break;
                
            case "delete":
                jspPage = "UserRatings.jsp";
                showRateIdForm = false;
                showDetails = false;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = false;
                showDeleteStatus = true;
                
                rateId = getValueForId("rateId");
                boolean deleteStatus = deleteRating(rateId);
                
                if (deleteStatus) {
                    message = "Deleted Successfully!";
                } else {
                    message = "Delete Failed!";
                }
                
                request.setAttribute("xmessage", message);
                break;
                
            case "add":
                jspPage = "UserRatings.jsp";
                showRateIdForm = false;
                showDetails = false;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = true;
                showInsertStatus = false;
                showDeleteStatus = false;
                
                rateId = getValueForId("rateId");
                this.selectUserRatings(rateId);
                break;
                
            case "insert":
                jspPage = "UserRatings.jsp";
                showRateIdForm = false;
                showDetails = false;
                showEditForm = false;
                showUpdateStatus = false;
                showAddForm = false;
                showInsertStatus = true;
                showDeleteStatus = false;
                
                rateId = getValueForId("rateId");
                
                UserRatings r1 = new UserRatings();

                r1.setUserId(Integer.parseInt(request.getParameter("userId")));
                r1.setType(request.getParameter("type"));
                r1.setTvsId(Integer.parseInt(request.getParameter("tvsId")));
                r1.setMovieId(Integer.parseInt(request.getParameter("movieId")));
                r1.setRating(Integer.parseInt(request.getParameter("ratings")));
                
                boolean insertStatus = insertRating(r1);
				System.out.println(insertStatus);
				message = "Inserted Successfully!";
				System.out.println(message);

				if (insertStatus == false) {
					message = "Insert Failed!, Retry....";
					System.out.println("Edit Form Show:" + showAddForm);
				}

				request.setAttribute("xmessage", message);
				System.out.println("Inserted   " + insertStatus);
                break;
                
            
        }
        
        try {
            request.setAttribute("showRateIdForm", showRateIdForm);
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

    private int getValueForId(String key) {
        int rateId = -1;
        try {
            rateId = Integer.parseInt(this.request.getParameter(key));
        } catch (Exception ex) {
            System.out.println("Error with rate ID");
        }
        return rateId;
    }

    public void selectUserRatings(int rateId) {
        try {
            List<UserRatings> userRatingsList = new UserRatingsDAO().selectUserRatings(rateId);
            request.setAttribute("userRatingsList", userRatingsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public boolean updateRating(UserRatings rating) {
//        boolean updateStatus = true;
//        try {
//            updateStatus = new UserRatingsDAO().updateUserRating(rating);
//            request.setAttribute("isSuccessUpdate", updateStatus);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        return updateStatus;
//    }

    public boolean insertRating(UserRatings rating) {
        boolean insertStatus = false;
        try {
            insertStatus = new UserRatingsDAO().insertUserRating(rating);
            request.setAttribute("isSuccessInsert", insertStatus);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return insertStatus;
    }

    public boolean deleteRating(int rateId) {
        boolean deleteStatus = false;
        try {
            deleteStatus = new UserRatingsDAO().deleteUserRating(rateId);
            request.setAttribute("isSuccessDelete", deleteStatus);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return deleteStatus;
    }
}
