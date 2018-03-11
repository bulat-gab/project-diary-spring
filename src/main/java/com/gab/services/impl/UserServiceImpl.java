package com.gab.services.impl;

import com.gab.model.dao.impl.UserDAOImpl;
import com.gab.model.dao.interfaces.UserDAO;
import com.gab.model.pojo.User;
import com.gab.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean auth(String login, String password) {
        return userDAO.findUserByUserNameAndPassword(login, password) != null;
    }

    @Override
    public boolean register(String username, String password){
        return userDAO.createUser(username, password) != null;
    }
}