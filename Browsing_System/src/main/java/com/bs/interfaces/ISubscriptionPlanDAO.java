package com.bs.interfaces;

import java.util.List;

import com.bs.model.SubscriptionPlan;

public interface ISubscriptionPlanDAO {

	List<SubscriptionPlan>selectSubscriptionPlan(int subId);
	public void insertSubscriptionPlan(SubscriptionPlan sub);
	public void updateSubscriptionPlan(SubscriptionPlan sub);
	public void deleteSubscriptionPlan(SubscriptionPlan sub);
}
