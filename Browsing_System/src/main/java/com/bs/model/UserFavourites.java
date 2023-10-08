package com.bs.model;

import java.util.Date;

public class UserFavourites {

	 private int favId;
	    private int userId;
	    private char type;
	    private int tvsId;
	    private int movieId;
	    private Date rowCreatedDatetime;

	    public UserFavourites(int favId, int userId, char type, int tvsId, int movieId,
	                         Date rowCreatedDatetime) {
	        this.favId = favId;
	        this.userId = userId;
	        this.type = type;
	        this.tvsId = tvsId;
	        this.movieId = movieId;
	        this.rowCreatedDatetime = rowCreatedDatetime;
	    }

	    public int getFavId() {
	        return favId;
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

	    public Date getRowCreatedDatetime() {
	        return rowCreatedDatetime;
	    }
}
