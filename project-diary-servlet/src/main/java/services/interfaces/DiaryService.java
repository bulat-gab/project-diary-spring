package services.interfaces;

import model.pojo.Diary;
import model.pojo.User;

import java.util.List;

/**
 * Created by gab on 06.Mar.2018
 */
public interface DiaryService {
    List<Diary> getAllDiariesByUser(User user);
    List<Diary> getAllDiariesByUserName(String username);
    Diary getDiaryByUser(User user, String name);
    boolean saveDiaryByUserName(String username, Diary diary);
    boolean deleteDiaryByUserName(String username, String diaryName);
}
