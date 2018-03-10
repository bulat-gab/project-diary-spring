package com.gab.model.pojo;

import java.util.Objects;

/**
 * Created by gab on 05.Mar.2018
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " " + password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof User))
            return false;

        User user = (User) obj;
        return Objects.equals(username, user.getUsername())
                && Objects.equals(password, user.getPassword());
    }
}
