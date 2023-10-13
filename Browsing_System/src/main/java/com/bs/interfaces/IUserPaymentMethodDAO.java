package com.bs.interfaces;

import java.util.List;
import com.bs.model.UserPaymentMethod;

public interface IUserPaymentMethodDAO {
	
	public List<UserPaymentMethod> selectUserPaymentMethod(int paymentMethodId);
	public void insertUserPaymentMethod(UserPaymentMethod userPaymentMethod);
	public boolean deleteUserPaymentMethod(int paymentMethodId);
}

