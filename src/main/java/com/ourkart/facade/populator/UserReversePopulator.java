package com.ourkart.facade.populator;

import com.ourkart.data.UserData;
import com.ourkart.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserReversePopulator implements Populator<UserData, UserModel> {

    @Override
    public UserModel populate(UserData userData) {
        UserModel userModel = new UserModel();
        userModel.setUid(userData.getUid());
        userModel.setFirstName(userData.getFirstName());
        userModel.setLastName(userData.getLastName());
        userModel.setEmail(userData.getEmail());
        userModel.setPassword(userData.getPassword());
        userModel.setMobileNumber(userData.getMobileNumber());
        return userModel;
    }
}