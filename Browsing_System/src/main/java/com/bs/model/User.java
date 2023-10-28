package com.bs.model;

import java.util.Date;

public class User {

	private int userId;
    private String name;
    private String email;
    private String mobileNo;
    private Date dob;
    private String isPremiumUser;
    private boolean premiumUser;
    private String password;
    private String createdAdminName;
    private String isActiveStatus;
    private boolean isActive;
    private Date rowCreatedDatetime;
   
    public User() {
    	
    }
    
    public User(int userId, String name, String email, String mobileNo, Date dob, String isPremiumUser,
                boolean premiumUser, String password, String createdAdminName, String isActiveStatus,
                boolean isActive, Date rowCreatedDatetime) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.isPremiumUser = isPremiumUser;
        this.premiumUser = premiumUser;
        this.password = password;
        this.createdAdminName = createdAdminName;
        this.isActiveStatus = isActiveStatus;
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
    
    public String isPremiumUser() {
        return isPremiumUser;
    }

    public boolean premiumUser() {
        return premiumUser;
    }

    public String getPassword() {
        return password;
    }

    public String getCreatedAdminName() {
        return createdAdminName;
    }

    public String getIsActiveStatus() {
        return isActiveStatus;
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
	
	public void setIsPremiumUser(String isPremiumUser) {
		this.isPremiumUser = isPremiumUser;
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
	
	public void setIsActiveStatus(String isActiveStatus) {
		this.isActiveStatus = isActiveStatus;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setRowCreatedDatetime(Date rowCreatedDatetime) {
		this.rowCreatedDatetime = rowCreatedDatetime;
	}
    
}
