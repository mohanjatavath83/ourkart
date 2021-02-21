package com.ourkart.facade;

import com.ourkart.data.UserData;

import java.util.List;

public interface UserFacade {

    void registerUser(UserData userData);
    List<UserData> getUsers();
    String removeUser(String uid);
}
