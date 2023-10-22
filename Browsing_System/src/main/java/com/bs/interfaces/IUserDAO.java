package com.bs.interfaces;

import java.util.List;
import com.bs.model.User;

public interface IUserDAO {
	public List<User> selectUser(int userId);
	public boolean insertUser(User user);
	public boolean updateUserByUser(User user);
	public boolean upgradeToPremium(int userId);
	public boolean changePassword(User user);
	public boolean deleteUser(int userID); 

}
