package com.bs.interfaces;

import java.util.List;

import com.bs.model.SubscriptionPlan;

public interface ISubscriptionPlanDAO {

	List<SubscriptionPlan>selectSubscriptionPlan();
	public boolean insertSubscriptionPlan(SubscriptionPlan sub);
	public boolean updateSubscriptionPlan(SubscriptionPlan sub);
	public boolean deleteSubscriptionPlan(int planId);
}
