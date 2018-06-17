import model.dao.impl.UserDAOImpl;
import model.dao.interfaces.UserDAO;
import model.pojo.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * Created by gab on 06.Mar.2018
 */

public class UserDAOShould {
    private static UserDAO userDAO;

    @BeforeClass
    public static void setUpFixture(){
        userDAO = new UserDAOImpl();
    }

    @Test
    public void fetchAdminFromDB(){
        String adminName = "admin";
        String adminPassword = "qwerty";

        User user = userDAO.findUserByUserNameAndPassword(adminName, adminPassword);

        assertThat(user, notNullValue());
        assertThat(adminName, equalTo(user.getUsername()));
        assertThat(adminPassword, equalTo(user.getPassword()));
    }

    @Test
    public void fetchUserFromDB(){
        String username = "gab";
        String password = "123";

        User user = userDAO.findUserByUserNameAndPassword(username, password);

        assertThat(user, notNullValue());
        assertThat(username, equalTo(user.getUsername()));
        assertThat(password, equalTo(user.getPassword()));
    }

    @Test
    public void returnNullWhenUserDoesNotExist(){
        String username = "Non432432rExisting4tery45User";
        String password = "238vcxsfqSJCN324IFKVMSCn000SKCCr";

        User user = userDAO.findUserByUserNameAndPassword(username, password);

        assertThat(user, nullValue());
    }

    @Test
    public void createUser(){
        String username = "testUser4231";
        String password = "testUser4231password";
        userDAO.deleteUser(username);

        User user = userDAO.createUser(username, password);

        assertThat(user, notNullValue());
        assertThat(username, equalTo(user.getUsername()));
        assertThat(password, equalTo(user.getPassword()));
    }
}
