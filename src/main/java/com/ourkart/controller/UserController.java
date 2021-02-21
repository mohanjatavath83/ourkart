package com.ourkart.controller;

import com.ourkart.data.UserData;
import com.ourkart.facade.UserFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserFacadeImpl userFacade;

    @ResponseBody
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserData userData)
    {
        userFacade.registerUser(userData);

        ResponseEntity<String> responseEntity = new ResponseEntity<String>("successfully",HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @ResponseBody
    @GetMapping
    public List<UserData> getUsers()
    {
        return userFacade.getUsers();
    }

    @ResponseBody
    @GetMapping("/{uid}")
    public UserData getUserByUid(@PathVariable String uid)
    {



        UserData userdata = userFacade.getUserByUid(uid);
       // ResponseEntity<UserData> responseEntity = new ResponseEntity<>(userdata, HttpStatus.ACCEPTED);

        return userdata;

    }

    @ResponseBody
    @DeleteMapping("/{uid}")
    public String removeUser(@PathVariable String uid ) {
        return userFacade.removeUser(uid);
    }


}
