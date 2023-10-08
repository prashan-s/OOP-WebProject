package com.bs.model;

import java.util.Date;

public class UserRatings {

	private int rateId;
    private int userId;
    private char type;
    private int tvsId;
    private int movieId;
    private int rating;
    private Date rowCreatedDatetime;

    public UserRatings(int rateId, int userId, char type, int tvsId, int movieId,
                      int rating, Date rowCreatedDatetime) {
        this.rateId = rateId;
        this.userId = userId;
        this.type = type;
        this.tvsId = tvsId;
        this.movieId = movieId;
        this.rating = rating;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public int getRateId() {
        return rateId;
    }

    public int getUserId() {
        return userId;
    }

    public char getType() {
        return type;
    }

    public int getTvsId() {
        return tvsId;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }
}
