import com.gab.model.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by gab on 10.Mar.2018
 */
public class UserPojoTest {
    @Test
    public void equalsTest(){
        User u1, u2;
        u1 = new User("gab", "123");
        u2 = new User("gab", "123");

        Assert.assertTrue(u1.equals(u2));
    }
}
