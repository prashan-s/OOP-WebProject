package com.bs.model;

import java.util.Date;

public class Payment {

	private int paymentId;
    private int userId;
    private int subId;
    private float amount;
    private int paymentMethodId;
    private Date rowCreatedDatetime;

    public Payment(int paymentId, int userId, int subId, float amount, int paymentMethodId,
                   Date rowCreatedDatetime) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.subId = subId;
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getSubId() {
        return subId;
    }

    public float getAmount() {
        return amount;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }
}
