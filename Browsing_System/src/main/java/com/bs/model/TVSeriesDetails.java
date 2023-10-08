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
