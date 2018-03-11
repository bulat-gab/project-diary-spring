package com.gab.services.interfaces;

import com.gab.model.pojo.User;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserService {
    boolean auth(String username, String password);
    boolean register(String name, String password);
}
