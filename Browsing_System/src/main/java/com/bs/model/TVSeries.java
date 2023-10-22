package com.bs.model;

import java.util.Date;

public class TVSeries {

	private int tvs_id;
	private String title;
	private String tvs_img_url;
	private boolean action_category;
	private boolean adventure_category;
	private boolean comedy_category;
	private boolean scify_category;
	private boolean horror_category;
	private boolean romance_category;
	private boolean science_category;
	private boolean crime_category;
	private boolean thriller_category;
	private boolean active;
	private Date row_created_datetime;
	
	

	public TVSeries(int tvs_id, String title, String tvs_img_url, boolean action_category, boolean adventure_category,
			boolean comedy_category, boolean scify_category, boolean horror_category, boolean romance_category,
			boolean science_category, boolean crime_category, boolean thriller_category, boolean active,
			Date row_created_datetime) {
		super();
		this.tvs_id = tvs_id;
		this.title = title;
		this.tvs_img_url = tvs_img_url;
		this.action_category = action_category;
		this.adventure_category = adventure_category;
		this.comedy_category = comedy_category;
		this.scify_category = scify_category;
		this.horror_category = horror_category;
		this.romance_category = romance_category;
		this.science_category = science_category;
		this.crime_category = crime_category;
		this.thriller_category = thriller_category;
		this.active = active;
		this.row_created_datetime = row_created_datetime;
	}



	public TVSeries(String title2, String imageUrl, boolean contains, boolean contains2, boolean contains3,
			boolean contains4, boolean contains5, boolean contains6, boolean contains7, boolean contains8,
			boolean contains9, boolean b, String string) {
		// TODO Auto-generated constructor stub
	}



	public TVSeries() {
		// TODO Auto-generated constructor stub
	}



	public void setTvs_id(int tvs_id) {
		this.tvs_id = tvs_id;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setTvs_img_url(String tvs_img_url) {
		this.tvs_img_url = tvs_img_url;
	}



	public void setAction_category(boolean action_category) {
		this.action_category = action_category;
	}



	public void setAdventure_category(boolean adventure_category) {
		this.adventure_category = adventure_category;
	}



	public void setComedy_category(boolean comedy_category) {
		this.comedy_category = comedy_category;
	}



	public void setScify_category(boolean scify_category) {
		this.scify_category = scify_category;
	}



	public void setHorror_category(boolean horror_category) {
		this.horror_category = horror_category;
	}



	public void setRomance_category(boolean romance_category) {
		this.romance_category = romance_category;
	}



	public void setScience_category(boolean science_category) {
		this.science_category = science_category;
	}



	public void setCrime_category(boolean crime_category) {
		this.crime_category = crime_category;
	}



	public void setThriller_category(boolean thriller_category) {
		this.thriller_category = thriller_category;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public void setRow_created_datetime(Date row_created_datetime) {
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



	public boolean isAction_category() {
		return action_category;
	}



	public boolean isAdventure_category() {
		return adventure_category;
	}



	public boolean isComedy_category() {
		return comedy_category;
	}



	public boolean isScify_category() {
		return scify_category;
	}



	public boolean isHorror_category() {
		return horror_category;
	}



	public boolean isRomance_category() {
		return romance_category;
	}



	public boolean isScience_category() {
		return science_category;
	}



	public boolean isCrime_category() {
		return crime_category;
	}



	public boolean isThriller_category() {
		return thriller_category;
	}



	public boolean isActive() {
		return active;
	}



	public Date getRow_created_datetime() {
		return row_created_datetime;
	}

}
