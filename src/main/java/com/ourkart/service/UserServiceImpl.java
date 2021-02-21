package com.ourkart.service;

import com.ourkart.dao.AddressRepository;
import com.ourkart.dao.UserRepository;
import com.ourkart.exception.ResourceAlreadyExists;
import com.ourkart.exception.ResourceNotFoundException;
import com.ourkart.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public void registerUser(UserModel userModel)
    {
        if(userRepository.findById(userModel.getUid()).isPresent())
        {
            throw new ResourceAlreadyExists("User already exist with uid "+userModel.getUid());
        }

        addressRepository.saveAll(userModel.getAddress());
        userRepository.save(userModel);
    }

    public List<UserModel> getUsers()
    {
        return (List)userRepository.findAll();
    }

    @Cacheable(cacheNames = "users",key = "#uid")
    public UserModel getUserbyUid(String uid)
    {
        try {
            System.out.println("fetching data from database = "+uid);
            Thread.sleep(1000);
            return userRepository.findById(uid).get();
        }catch (Exception ex)
        {
            ex.printStackTrace();
            throw new ResourceNotFoundException("User is not exist with uid  = "+uid);
        }
    }

    @Override
    public String removeUser(String uid)
    {
        userRepository.deleteById(uid);
        return "successfully deleted";
    }

    public void update(UserModel userModel)
    {
        userRepository.save(userModel);
    }


}
