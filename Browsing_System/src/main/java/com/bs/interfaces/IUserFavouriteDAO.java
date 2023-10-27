package com.bs.interfaces;

import java.util.List;
import com.bs.model.UserFavourites;

public interface IUserFavouriteDAO {

    List<UserFavourites> selectUserFavourites(int userId);
    boolean insertUserFavourite(UserFavourites userFavourite);
    boolean deleteUserFavourite(int favId);
    boolean updateUserFavourite(UserFavourites userFavourite);
}
