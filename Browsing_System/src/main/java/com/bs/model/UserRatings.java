package com.bs.model;

import java.util.Date;

public class UserRatings {

	private int rateId;
    private int userId;
    private String type;
    private int tvsId;
    private int movieId;
    private int rating;
    private Date rowCreatedDatetime;

    public UserRatings(int rateId, int userId, String type, int tvsId, int movieId,
                      int rating, Date rowCreatedDatetime) {
        this.rateId = rateId;
        this.userId = userId;
        this.type = type;
        this.tvsId = tvsId;
        this.movieId = movieId;
        this.rating = rating;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public UserRatings(int returnedMovieId, int ratingCount) {
		// TODO Auto-generated constructor stub
	}

	public UserRatings() {
		// TODO Auto-generated constructor stub
	}

	public int getRateId() {
        return rateId;
    }

    public int getUserId() {
        return userId;
    }

    public String getType() {
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

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTvsId(int tvsId) {
		this.tvsId = tvsId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setRowCreatedDatetime(Date rowCreatedDatetime) {
		this.rowCreatedDatetime = rowCreatedDatetime;
	}
    
}
