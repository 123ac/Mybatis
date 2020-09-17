package com.hjl.controller;

import com.hjl.pojo.UserInfo;
import com.hjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/select"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<UserInfo> getAllUsers(){
        List<UserInfo> list =  userService.select();
        return list;
    }
}
