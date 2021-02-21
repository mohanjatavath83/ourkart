package com.ourkart.service;

import com.ourkart.model.UserModel;

import java.util.List;

public interface UserService {
    void registerUser(UserModel userModel);
     List<UserModel> getUsers();
    UserModel getUserbyUid(String uid);
    String removeUser(String uid);
}
