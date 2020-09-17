package com.hjl.service.impl;

import com.hjl.dao.UserMapper;
import com.hjl.pojo.UserInfo;
import com.hjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> select() {
        return userMapper.select();
    }

    @Override
    public UserInfo selectById(int userId) {
        return userMapper.selectById(userId);
    }
}
