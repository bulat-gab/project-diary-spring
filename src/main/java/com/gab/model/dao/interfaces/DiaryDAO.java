package com.gab.model.dao.interfaces;

import com.gab.model.pojo.Diary;
import com.gab.model.pojo.User;
import java.util.List;

/**
 * Created by gab on 06.Mar.2018
 */
public interface DiaryDAO {
    List<Diary> getAllDiariesByUser(User user);
    List<Diary> getAllDiariesByUserName(String username);
    boolean saveDiaryByUserName(String username, Diary diary);
    boolean deleteDiaryByUserName(String username, String diaryName);
}
