package com.bs.model;

import java.util.Date;

public class TVSeries {

	private int tvs_id;
	private String title;
	private String tvs_img_url;
	private String category;
	private boolean active;
	private Date row_created_datetime;
	
	public TVSeries(int tvs_id, String title, String tvs_img_url, String category, boolean active,
			Date row_created_datetime) {
		super();
		this.tvs_id = tvs_id;
		this.title = title;
		this.tvs_img_url = tvs_img_url;
		this.category = category;
		this.active = active;
		this.row_created_datetime = row_created_datetime;
	}

	public int getTvs_id() {
		return tvs_id;
	}

	public String getTitle() {
		return title;
	}

	public String getTvs_img_url() {
		return tvs_img_url;
	}

	public String getCategory() {
		return category;
	}

	public boolean isActive() {
		return active;
	}

	public Date getRow_created_datetime() {
		return row_created_datetime;
	}
	
}
