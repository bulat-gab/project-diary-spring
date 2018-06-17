package services.impl;

import model.dao.impl.DiaryDAOImpl;
import model.dao.interfaces.DiaryDAO;
import model.pojo.Diary;
import model.pojo.User;
import services.interfaces.DiaryService;

import java.util.List;

/**
 * Created by gab on 06.Mar.2018
 */
public class DiaryServiceImpl implements DiaryService {
    private DiaryDAO diaryDAO = new DiaryDAOImpl();

    @Override
    public List<Diary> getAllDiariesByUserName(String username) {
        return diaryDAO.getAllDiariesByUserName(username);
    }

    @Override
    public List<Diary> getAllDiariesByUser(User user) {
        return diaryDAO.getAllDiariesByUser(user);
    }

    @Override
    public Diary getDiaryByUser(User user, String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean saveDiaryByUserName(String username, Diary diary) {
        return diaryDAO.saveDiaryByUserName(username, diary);
    }

    @Override
    public boolean deleteDiaryByUserName(String username, String diaryName) {
        return diaryDAO.deleteDiaryByUserName(username, diaryName);
    }
}
