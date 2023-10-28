package com.bs.model;

import java.util.Date;

public class Movie {

	private int movie_id;
	private String title;
	private String description;
	private int year;
	private int duration;
	private String quality;
	private int watch_count;
	private String movie_img_url;
	private String movie_stream_url;
	private boolean action_category;
	private boolean adventure_category;
	private boolean comedy_category;
	private boolean scify_category;
	private boolean horror_category;
	private boolean romance_category;
	private boolean science_category;
	private boolean crime_category;
	private boolean thriller_category;
	private boolean is_active;
	private String is_active_Status;
	private String created_admin_name;
	private Date row_created_datetime;

	public Movie(int movie_id, String title, String description, int year, int duration, String quality,
			int watch_count, String movie_img_url, String movie_stream_url, boolean action_category,
			boolean adventure_category, boolean comedy_category, boolean scify_category, boolean horror_category,
			boolean romance_category, boolean science_category, boolean crime_category, boolean thriller_category,
			boolean is_active, String created_admin_name, Date row_created_datetime) {
		// super();
		this.movie_id = movie_id;
		this.title = title;
		this.description = description;
		this.year = year;
		this.duration = duration;
		this.quality = quality;
		this.watch_count = watch_count;
		this.movie_img_url = movie_img_url;
		this.movie_stream_url = movie_stream_url;
		this.action_category = action_category;
		this.adventure_category = adventure_category;
		this.comedy_category = comedy_category;
		this.scify_category = scify_category;
		this.horror_category = horror_category;
		this.romance_category = romance_category;
		this.science_category = science_category;
		this.crime_category = crime_category;
		this.thriller_category = thriller_category;
		this.is_active = is_active;
		this.created_admin_name = created_admin_name;
		this.row_created_datetime = row_created_datetime;
	}

	public void setisActiveStatus(String str) {
		this.is_active_Status = str;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public void setWatch_count(int watch_count) {
		this.watch_count = watch_count;
	}

	public void setMovie_img_url(String movie_img_url) {
		this.movie_img_url = movie_img_url;
	}

	public void setMovie_stream_url(String movie_stream_url) {
		this.movie_stream_url = movie_stream_url;
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

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public void setCreated_admin_name(String created_admin_name) {
		this.created_admin_name = created_admin_name;
	}

	public void setRow_created_datetime(Date row_created_datetime) {
		this.row_created_datetime = row_created_datetime;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public int getMovie_id() {
		return movie_id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getYear() {
		return year;
	}

	public int getDuration() {
		return duration;
	}

	public String getQuality() {
		return quality;
	}

	public int getWatch_count() {
		return watch_count;
	}

	public String getMovie_img_url() {
		return movie_img_url;
	}

	public String getMovie_stream_url() {
		return movie_stream_url;
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

	public boolean isIs_active() {
		return is_active;
	}

	public String getCreated_admin_name() {
		return created_admin_name;
	}

	public Date getRow_created_datetime() {
		return row_created_datetime;
	}

}
