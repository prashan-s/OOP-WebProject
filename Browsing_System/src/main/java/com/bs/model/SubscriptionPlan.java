package com.bs.model;

import java.util.Date;

public class SubscriptionPlan {

	private int planId;
    private String description;
    private int duration;
    private float amount;
    private boolean isActive;
    private Date rowCreatedDatetime;

    public SubscriptionPlan(int planId, String description, int duration, float amount,
                            boolean isActive, Date rowCreatedDatetime) {
        this.planId = planId;
        this.description = description;
        this.duration = duration;
        this.amount = amount;
        this.isActive = isActive;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public int getPlanId() {
        return planId;
    }

    public String getTerm() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public float getAmount() {
        return amount;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }
}
