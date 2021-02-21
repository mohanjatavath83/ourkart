package com.ourkart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomePageController {

    @ResponseBody
    @RequestMapping("/")
    public String getHomePage()
    {
        return "welcome to ourkart home page mmmmmmm";
    }

}
