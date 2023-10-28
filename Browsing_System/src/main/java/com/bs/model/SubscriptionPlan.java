package com.bs.model;

import java.lang.String;
import java.util.Date;

import com.oracle.wls.shaded.org.apache.xpath.operations.String;

public class SubscriptionPlan {

	private int planId;
    private String description;
    private int duration;
    private float amount;
    private boolean isActive;
    private Date rowCreatedDatetime;
    private String activeStatus;
    public SubscriptionPlan() {
    	
    }
    public SubscriptionPlan(int planId, String description, int duration, float amount,
                            boolean isActive, Date rowCreatedDatetime) {
        this.planId = planId;
        this.description = description;
        this.duration = duration;
        this.amount = amount;
        this.isActive = isActive;
        this.activeStatus = "InActive";
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public void setActiveStatus(String str) {
		this.activeStatus = str;
	}


    public int getPlanId() {
        return planId;
    }
    public int getDuration() {
        return duration;
    }

    public float getAmount() {
        return amount;
    }

    public boolean getisActive() {
        return isActive;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	
}
