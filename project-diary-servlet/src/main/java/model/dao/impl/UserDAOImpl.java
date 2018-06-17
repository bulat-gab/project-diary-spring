package model.dao.impl;

import model.dao.interfaces.UserDAO;
import model.pojo.User;
import model.utils.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by admin on 20.04.2017.
 */
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        User user = null;
        String sql = "SELECT username, password FROM users WHERE username = ? AND password =?;";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            user = new User(resultSet.getString("username"), resultSet.getString("password"));

            LOGGER.info(String.format("User %s has found.", username));

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.warning(String.format("Error while fetching user from database: %s.", e));
        }

        return user;
    }

    @Override
    public User createUser(String username, String password) {
        User user = null;
        String sql = "INSERT INTO users(username, password) VALUES (?, ?)";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            int insertedUser = statement.executeUpdate();


            if(insertedUser == 1){
                LOGGER.info(String.format("User %s has registered.", username));
                user = new User(username, password);
            }

            statement.close();
            connection.close();
        }
        catch (SQLException e){
            LOGGER.warning(String.format("User registration failed %s.", e.getMessage()));
        }
        return user;
    }

    @Override
    public boolean deleteUser(String username) {
         String sql = "DELETE FROM users\n" +
                 "WHERE users.username = ?";

         try {
             Connection connection = DataSourceFactory.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1, username);

             int deletedUser = statement.executeUpdate();
             if(deletedUser == 1){
                 LOGGER.info(String.format("User %s has been deleted.", username));
                 return true;
             }
             LOGGER.info(username + " not found.");
         }
         catch (SQLException e){
             LOGGER.warning(String.format("User deletion failed %s.", e.getMessage()));
         }
         return false;
    }
}
