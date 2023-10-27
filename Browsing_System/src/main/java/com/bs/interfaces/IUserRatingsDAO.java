package com.bs.interfaces;

import java.util.List;
import com.bs.model.UserRatings;

public interface IUserRatingsDAO {

    List<UserRatings> selectUserRatings(int userId);
    boolean insertUserRating(UserRatings userRating);
    boolean deleteUserRating(int rateId);
}
