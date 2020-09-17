package com.hjl.service;

import com.hjl.dao.UserMapper;
import com.hjl.pojo.UserInfo;
import com.hjl.springbootmybatisdemo.SpringbootMybatisDemoApplication;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = SpringbootMybatisDemoApplication.class) //启动项类
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    Logger logger=Logger.getLogger(this.getClass());

    @Test
    @Transactional(rollbackFor = Throwable.class)//默认
     void selectById() {
        UserInfo userInfo=userMapper.selectById(1);
        logger.info(userInfo);
        UserInfo userInfo1=userMapper.selectById(1);
        logger.info(userInfo1);

        logger.info(userInfo==userInfo1);
        logger.info("命中了mybatis的一级缓存---》数据库只查询了一次");
    }
}
