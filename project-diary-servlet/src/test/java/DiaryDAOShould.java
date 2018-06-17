import model.dao.impl.DiaryDAOImpl;
import model.dao.interfaces.DiaryDAO;
import model.pojo.Diary;
import model.pojo.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by gab on 06.Mar.2018
 */
public class DiaryDAOShould {
    private static DiaryDAO diaryDAO;

    @BeforeClass
    public static void setUpFixture(){
        diaryDAO = new DiaryDAOImpl();
    }

    @Test
    public void getAllDiariesForUser(){
        User user = new User("test", "test");
        List<Diary> expectedDiaries = new ArrayList<>();
        expectedDiaries.add(new Diary("testname1","test note 1"));
        expectedDiaries.add(new Diary("testname2","test note 2"));
        expectedDiaries.add(new Diary("testname3","test note 3"));

        List<Diary> actualDiaries = diaryDAO.getAllDiariesByUser(user);

        assertThat(actualDiaries, notNullValue());
        assertThat(actualDiaries.size(), equalTo(3));
        assertThat(actualDiaries, is(expectedDiaries));
    }

    @Test
    public void getEmptyListWhenUserDoesNotExist(){
        String username = "Non432432rExisting4tery45User";
        String password = "238vcxsfqSJCN324IFKVMSCn000SKCCr";
        User user = new User(username, password);

        List<Diary> actualDiaries = diaryDAO.getAllDiariesByUser(user);
        assertThat(actualDiaries, notNullValue());
        assertThat(actualDiaries.size(), equalTo(0));
    }
}
