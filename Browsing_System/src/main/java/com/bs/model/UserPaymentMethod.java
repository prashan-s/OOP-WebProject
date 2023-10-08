package com.bs.model;

import java.util.Date;

public class UserPaymentMethod {

	private int paymentMethodId;
    private String cardNumber;
    private Date cardExpiryDate;
    private int cvv;
    private int userId;
    private boolean isActive;
    private Date rowCreatedDatetime;

    public UserPaymentMethod(int paymentMethodId, String cardNumber, Date cardExpiryDate,
                             int cvv, int userId, boolean isActive, Date rowCreatedDatetime) {
        this.paymentMethodId = paymentMethodId;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.userId = userId;
        this.isActive = isActive;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getCardExpiryDate() {
        return cardExpiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }
}
