package services.interfaces;

import model.pojo.User;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserService {
    User auth(String username, String password);
    boolean register(String name, String password);
}
