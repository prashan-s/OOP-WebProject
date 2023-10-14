package com.bs.interfaces;

import java.util.List;

import com.bs.model.UserSubscription;

public interface IUserSubscriptionDAO {
	public List<UserSubscription> selectSubscription(int sub_id); 
}
