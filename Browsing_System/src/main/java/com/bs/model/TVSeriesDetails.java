package com.bs.model;

import java.util.Date;

public class TVSeriesDetails {

	private int tvsDetailId;
    private int tvsId;
    private int season;
    private int episode;
    private String description;
    private int year;
    private int duration;
    private String quality;
    private Integer watchCount;
    private String tvsStreamUrl;
    private String createdAdminName;
    private boolean isActive;
    private Date rowCreatedDatetime;

    public TVSeriesDetails(int tvsDetailId, int tvsId, int season, int episode, String description,
                           int year, int duration, String quality, Integer watchCount,
                           String tvsStreamUrl, String createdAdminName, boolean isActive, Date rowCreatedDatetime) {
        this.tvsDetailId = tvsDetailId;
        this.tvsId = tvsId;
        this.season = season;
        this.episode = episode;
        this.description = description;
        this.year = year;
        this.duration = duration;
        this.quality = quality;
        this.watchCount = watchCount;
        this.tvsStreamUrl = tvsStreamUrl;
        this.createdAdminName = createdAdminName;
        this.isActive = isActive;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public TVSeriesDetails() {
		
	}

	public void setTvsDetailId(int tvsDetailId) {
		this.tvsDetailId = tvsDetailId;
	}

	public void setTvsId(int tvsId) {
		this.tvsId = tvsId;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
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

	public void setWatchCount(Integer watchCount) {
		this.watchCount = watchCount;
	}

	public void setTvsStreamUrl(String tvsStreamUrl) {
		this.tvsStreamUrl = tvsStreamUrl;
	}

	public void setCreatedAdminName(String createdAdminName) {
		this.createdAdminName = createdAdminName;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setRowCreatedDatetime(Date rowCreatedDatetime) {
		this.rowCreatedDatetime = rowCreatedDatetime;
	}

	public int getTvsDetailId() {
        return tvsDetailId;
    }

    public int getTvsId() {
        return tvsId;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
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

    public Integer getWatchCount() {
        return watchCount;
    }

    public String getTvsStreamUrl() {
        return tvsStreamUrl;
    }

    public String getCreatedAdminName() {
        return createdAdminName;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }
}
