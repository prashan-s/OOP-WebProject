package com.bs.model;

import java.util.Date;

public class SubscriptionPlan {

	private int planId;
    private String term;
    private int duration;
    private float amount;
    private boolean isActive;
    private Date rowCreatedDatetime;

    public SubscriptionPlan(int planId, String term, int duration, float amount,
                            boolean isActive, Date rowCreatedDatetime) {
        this.planId = planId;
        this.term = term;
        this.duration = duration;
        this.amount = amount;
        this.isActive = isActive;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public int getPlanId() {
        return planId;
    }

    public String getTerm() {
        return term;
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
