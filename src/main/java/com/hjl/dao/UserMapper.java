package com.hjl.dao;

import com.hjl.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<UserInfo> select();

    UserInfo selectById(int userId);

    UserInfo selectById1(int userId);

    UserInfo selectById2(Map<String,Object> map);

    UserInfo selectById3(Map<String,Object> map);
}
