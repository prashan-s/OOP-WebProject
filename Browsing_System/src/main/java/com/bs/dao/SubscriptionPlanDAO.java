package com.bs.dao;

import com.bs.interfaces.ISubscriptionPlanDAO;
import com.bs.model.SubscriptionPlan;
import com.bs.utility.DBConnectionMSSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class SubscriptionPlanDAO implements ISubscriptionPlanDAO {

	private static final String SELECT_ALL_SUBSCRIPTION_PLANS = "SELECT plan_id, description, duration_in_months, amount, is_active, row_created_datetime "
			+ "FROM subscription_plan";

	private static final String SELECT_ALL_ACTIVE_SUBSCRIPTION_PLANS = "SELECT plan_id, description, duration_in_months, amount, is_active, row_created_datetime "
			+ "FROM subscription_plan WHERE is_active = 1";

	private static final String SELECT_SUBSCRIPTION_BY_ID = "SELECT plan_id, description, duration_in_months, amount, is_active, row_created_datetime "
			+ "FROM subscription_plan WHERE plan_id = ? ";

	private static final String INSERT_SUBSCRIPTION_PLAN = "INSERT INTO subscription_plan (description, duration_in_months, amount, is_active) "
			+ "VALUES (?, ?, ?, ?)";

	private static final String UPDATE_SUBSCRIPTION_PLAN = "UPDATE subscription_plan SET description=?, duration_in_months=?, amount=?, is_active=? "
			+ "WHERE plan_id = ?";

	private static final String DELETE_SUBSCRIPTION_PLAN = "DELETE FROM subscription_plan WHERE plan_id = ?";

	// select subscription details by Id
	public SubscriptionPlan selectSubscriptionPlanById(int planId) {
		SubscriptionPlan subscriptionPlan = null;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_SUBSCRIPTION_BY_ID);
			stmt.setInt(1, planId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int PlanId = rs.getInt("plan_id");
				String description = rs.getString("description");
				int duration = rs.getInt("duration_in_months");
				float amount = rs.getFloat("amount");
				boolean isActive = rs.getBoolean("is_active");
				Date rowCreatedDatetime = rs.getDate("row_created_datetime");

				subscriptionPlan = new SubscriptionPlan(PlanId, description, duration, amount, isActive,
						rowCreatedDatetime);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscriptionPlan;

	}

	// select all subscription plans
	public List<SubscriptionPlan> selectAllSubscriptionPlans() {

		ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_SUBSCRIPTION_PLANS);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int PlanId = rs.getInt("plan_id");
				String description = rs.getString("description");
				int duration = rs.getInt("duration_in_months");
				float amount = rs.getFloat("amount");
				boolean isActive = rs.getBoolean("is_active");
				Date rowCreatedDatetime = rs.getDate("row_created_datetime");
				String strIsActive = (isActive) ? "Active" : "InActive";
				SubscriptionPlan subscriptionPlan = new SubscriptionPlan(PlanId, description, duration, amount,
						isActive, rowCreatedDatetime);
				subscriptionPlan.setActiveStatus(strIsActive);
				subscriptionPlans.add(subscriptionPlan);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subscriptionPlans;
	}

	public List<SubscriptionPlan> selectAllActiveSubscriptionPlans() {

		ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ACTIVE_SUBSCRIPTION_PLANS);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int PlanId = rs.getInt("plan_id");
				String description = rs.getString("description");
				int duration = rs.getInt("duration_in_months");
				float amount = rs.getFloat("amount");
				boolean isActive = rs.getBoolean("is_active");
				Date rowCreatedDatetime = rs.getDate("row_created_datetime");

				SubscriptionPlan subscriptionPlan = new SubscriptionPlan(PlanId, description, duration, amount,
						isActive, rowCreatedDatetime);
				subscriptionPlans.add(subscriptionPlan);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subscriptionPlans;
	}

	// insert new subscription plan
	public boolean insertSubscriptionPlan(SubscriptionPlan subscriptionPlan) {

		boolean insertStatus = false;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_SUBSCRIPTION_PLAN);

			stmt.setString(1, subscriptionPlan.getDescription());
			stmt.setInt(2, subscriptionPlan.getDuration());
			stmt.setFloat(3, subscriptionPlan.getAmount());
			stmt.setBoolean(4, subscriptionPlan.getisActive());

			insertStatus = (stmt.executeUpdate() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertStatus;
	}

	// update subscription plan
	public boolean updateSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		boolean rowUpdate = false;
		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_SUBSCRIPTION_PLAN);

			stmt.setString(1, subscriptionPlan.getDescription());
			stmt.setInt(2, subscriptionPlan.getDuration());
			stmt.setFloat(3, subscriptionPlan.getAmount());
			stmt.setBoolean(4, subscriptionPlan.getisActive());

			stmt.setInt(5, subscriptionPlan.getPlanId());

			rowUpdate = stmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdate;
	}

	// delete a subscription plan
	public boolean deleteSubscriptionPlan(int planId) {
		boolean rowDelete = false;

		try {
			Connection con = DBConnectionMSSQL.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_SUBSCRIPTION_PLAN);

			stmt.setInt(1, planId);
			rowDelete = stmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDelete;
	}

}
