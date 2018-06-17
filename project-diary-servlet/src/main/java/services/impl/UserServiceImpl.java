package services.impl;

import model.dao.impl.UserDAOImpl;
import model.dao.interfaces.UserDAO;
import model.pojo.User;
import services.interfaces.UserService;

import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    //private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        return userDAO.findUserByUserNameAndPassword(login, password);
    }

    @Override
    public boolean register(String username, String password){
        return userDAO.createUser(username, password) != null;
    }


}