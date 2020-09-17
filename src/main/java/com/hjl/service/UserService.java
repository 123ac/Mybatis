package com.hjl.service;

import com.hjl.pojo.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> select();

    UserInfo selectById(int id);
}
