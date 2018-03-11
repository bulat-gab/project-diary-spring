package com.gab.services.impl;

import com.gab.model.dao.impl.DiaryDAOImpl;
import com.gab.model.dao.interfaces.DiaryDAO;
import com.gab.model.pojo.Diary;
import com.gab.model.pojo.User;
import com.gab.services.interfaces.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gab on 06.Mar.2018
 */
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryDAO diaryDAO;

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
