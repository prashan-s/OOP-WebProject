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

    public UserPaymentMethod() {
    	
    }
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

    public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void setRowCreatedDatetime(Date rowCreatedDatetime) {
		this.rowCreatedDatetime = rowCreatedDatetime;
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
