package com.bs.interfaces;

import java.util.List;
import com.bs.model.User;

public interface IUserDAO {
	public User selectUser(int userId);
	public List<User> selectUserList();
	public String loginUser(String name);
	public boolean insertUser(User user);
	public boolean updateUserByUser(User user);
	public boolean updateUserByAdmin(User user);
	public boolean upgradeToPremium(int userId);
	public boolean changePassword(User user);
	public boolean deleteUser(int userID); 

}
