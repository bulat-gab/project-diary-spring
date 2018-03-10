package com.gab.model.dao.interfaces;

import com.gab.model.pojo.User;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserDAO {
    User findUserByUserNameAndPassword(String username, String password);
    User createUser(String username, String password);
    boolean deleteUser(String username);
}
