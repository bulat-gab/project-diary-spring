package model.dao.impl;

import model.dao.interfaces.DiaryDAO;
import model.pojo.Diary;
import model.pojo.User;
import model.utils.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gab on 06.Mar.2018
 */
public class DiaryDAOImpl implements DiaryDAO {
    private static final Logger LOGGER = Logger.getLogger(DiaryDAOImpl.class.getName());

    @Override
    public List<Diary> getAllDiariesByUser(User user) {
        ArrayList<Diary> diaries = new ArrayList<>();
        if(user == null)
            return diaries;

        String sql = "SELECT name, note\n" +
                "FROM diaries AS d\n" +
                "WHERE d.d_id IN (\n" +
                "  SELECT d_id\n" +
                "  FROM keeps AS k INNER JOIN users AS u ON k.username = u.username\n" +
                "  WHERE u.username = ?\n" +
                ");";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                diaries.add(new Diary(
                        resultSet.getString(1),
                        resultSet.getString(2))
                );
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
           LOGGER.warning(e.getMessage());
        }
        return diaries;
    }

    @Override
    public boolean saveDiaryByUserName(String username, Diary diary) {
        String sqlInsertIntoDiaries = "INSERT INTO diaries(name, note) VALUES (?,?)";
        String sqlSelectMaxId = "(SELECT MAX(d_id) FROM diaries)";
        String sqlInsertIntoKeeps = "INSERT INTO keeps(d_id, username) VALUES (?,?)";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();

            PreparedStatement statement = connection.prepareStatement(sqlInsertIntoDiaries);
            statement.setString(1, diary.getName());
            statement.setString(2, diary.getNote());
            statement.execute();

            statement = connection.prepareStatement(sqlSelectMaxId);
            ResultSet maxIdResult = statement.executeQuery();
            maxIdResult.next();
            int maxId = maxIdResult.getInt(1);

            statement = connection.prepareStatement(sqlInsertIntoKeeps);
            statement.setInt(1, maxId);
            statement.setString(2, username);
            statement.execute();


            maxIdResult.close();
            statement.close();
            connection.close();
            return true;
        }
        catch (SQLException e){
            LOGGER.warning("Error adding diary in DB " + e);
            return false;
        }
    }

    @Override
    public boolean deleteDiaryByUserName(String username, String diaryName) {
        String sql = "DELETE FROM diaries\n" +
                "WHERE diaries.d_id IN\n" +
                "(SELECT k.d_id\n" +
                " FROM diaries d INNER JOIN keeps k ON d.d_id = k.d_id\n" +
                " WHERE k.username = ? AND d.name = ?)";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2, diaryName);
            int deletedRows = statement.executeUpdate();

            LOGGER.info(String.format("Delete query for <%s> affected rows: %d", username, deletedRows));
            statement.close();
            connection.close();
            return true;
        }
        catch (SQLException e){
            LOGGER.warning("Error adding diary in DB " + e);
            return false;
        }
    }

    @Override
    public List<Diary> getAllDiariesByUserName(String username) {
        return getAllDiariesByUser(new User(username, "password"));
    }
}
