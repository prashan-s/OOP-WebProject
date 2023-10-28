package com.bs.model;

import java.util.Date;

public class User {

	private int userId;
    private String name;
    private String email;
    private String mobileNo;
    private Date dob;
    private boolean premiumUser;
    private String password;
    private String createdAdminName;
    private boolean isActive;
    private Date rowCreatedDatetime;
   
    public User() {
    	
    }
    
    public User(int userId, String name, String email, String mobileNo, Date dob,
                boolean premiumUser, String password, String createdAdminName,
                boolean isActive, Date rowCreatedDatetime) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.premiumUser = premiumUser;
        this.password = password;
        this.createdAdminName = createdAdminName;
        this.isActive = isActive;
        this.rowCreatedDatetime = rowCreatedDatetime;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Date getDob() {
        return dob;
    }

    public boolean isPremiumUser() {
        return premiumUser;
    }

    public String getPassword() {
        return password;
    }

    public String getCreatedAdminName() {
        return createdAdminName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public Date getRowCreatedDatetime() {
        return rowCreatedDatetime;
    }

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPremiumUser(boolean premiumUser) {
		this.premiumUser = premiumUser;
	}

	public void setPassword(String password) {
		this.password = password;
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
    
}
