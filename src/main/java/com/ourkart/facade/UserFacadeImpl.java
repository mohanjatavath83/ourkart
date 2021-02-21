package com.ourkart.facade;

import com.ourkart.data.AddressData;
import com.ourkart.data.UserData;
import com.ourkart.facade.populator.AddressReversePopulator;
import com.ourkart.facade.populator.UserPopulator;
import com.ourkart.facade.populator.UserReversePopulator;
import com.ourkart.model.AddressModel;
import com.ourkart.model.UserModel;
import com.ourkart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade
{
    @Autowired
    UserReversePopulator userReversePopulator;

    @Autowired
    UserPopulator userPopulator;

    @Autowired
    UserService userService;

    @Autowired
    AddressReversePopulator addressReversePopulator;

    public void registerUser(UserData userData)
    {
        UserModel userModel = userReversePopulator.populate(userData);

        if (userData.getAddresses() != null && userData.getAddresses().size() > 0)
        {
            List<AddressModel> addresses = new ArrayList<>();
            for (AddressData addressData : userData.getAddresses()) {
                AddressModel addressModel = addressReversePopulator.populate(addressData);
                addresses.add(addressModel);
            }

            userModel.setAddress(addresses);
        }

        userService.registerUser(userModel);
    }

    public List<UserData> getUsers()
    {
        List<UserModel> userList = userService.getUsers();

        List<UserData> userDataList = new ArrayList<>();
        for(UserModel userModel : userList){
            UserData userData = userPopulator.populate(userModel);
            userDataList.add(userData);
        }

        return userDataList;
    }
    public UserData getUserByUid(String uid)
    {
        UserModel userModel = userService.getUserbyUid(uid);
        UserData userData = userPopulator.populate(userModel);
        return userData;

    }

    public String removeUser(String uid)
    {
        return userService.removeUser(uid);
    }
}
