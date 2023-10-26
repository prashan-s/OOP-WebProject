package com.bs.model;

import java.util.Date;

public class UserSubscription {

	private int subId;
	private int userId;
	private Date subscribeDate;
	private Date nextRenewalDate;
	private int planId;
	private boolean isActive;
	private Date rowCreatedDatetime;

	public UserSubscription() {

	}

	public UserSubscription(int subId, int userId, Date subscribeDate, Date nextRenewalDate, int planId,
			boolean isActive, Date rowCreatedDatetime) {
		this.subId = subId;
		this.userId = userId;
		this.subscribeDate = subscribeDate;
		this.nextRenewalDate = nextRenewalDate;
		this.planId = planId;
		this.isActive = isActive;
		this.rowCreatedDatetime = rowCreatedDatetime;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public void setNextRenewalDate(Date nextRenewalDate) {
		this.nextRenewalDate = nextRenewalDate;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setRowCreatedDatetime(Date rowCreatedDatetime) {
		this.rowCreatedDatetime = rowCreatedDatetime;
	}

	public int getSubId() {
		return subId;
	}

	public int getUserId() {
		return userId;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public Date getNextRenewalDate() {
		return nextRenewalDate;
	}

	public int getPlanId() {
		return planId;
	}

	public boolean isActive() {
		return isActive;
	}

	public Date getRowCreatedDatetime() {
		return rowCreatedDatetime;
	}
}
