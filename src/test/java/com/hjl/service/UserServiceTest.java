package com.hjl.service;

import com.hjl.dao.UserMapper;
import com.hjl.pojo.UserInfo;
import com.hjl.springbootmybatisdemo.SpringbootMybatisDemoApplication;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = SpringbootMybatisDemoApplication.class) //启动项类
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

   Logger logger=Logger.getLogger(this.getClass());

    @Test
    @Transactional//开启事务
//    1、为什么开启事务
//    由于使用了数据库连接池，默认每次查询完之后自动commite，这就导致两次查询使用的不是同一个sqlSessioin，根据一级缓存的原理，它将永远不会生效。
//    当我们开启了事务，两次查询都在同一个sqlSession中，从而让第二次查询命中了一级缓存。读者可以自行关闭事务验证此结论。
    void selectById(){
        UserInfo userInfo=userMapper.selectById(1);
        logger.info(userInfo);

        UserInfo userInfo1=userMapper.selectById(1);
        logger.info(userInfo1);

        logger.info(userInfo==userInfo1);
        logger.info("命中了mybatis的一级缓存---》数据库只查询了一次");
    }




    @Test
    @Transactional//默认
    void selectById1( ) {
        UserInfo userInfo=userMapper.selectById(1);
        logger.info(userInfo);
        UserInfo userInfo1=userMapper.selectById1(1);
        logger.info(userInfo1);
        logger.info(userInfo==userInfo1);
        logger.info("没有命中mybatis的一级缓存--》原因：UserInfoMappex.xml中的StatementId不相同，即使sql语句一样");
    }

    @Test
    @Transactional//默认
    void selectById2() {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",1);
        map.put("test",1);
        UserInfo userInfo=userMapper.selectById2(map);
        logger.info(userInfo);

        Map<String,Object> map1=new HashMap<>();
        map1.put("userId",1);
        map1.put("test",2);
        UserInfo userInfo1=userMapper.selectById2(map1);
        logger.info(userInfo1);
        logger.info(userInfo==userInfo1);
        logger.info("命中mybatis的一级缓存--》原因：最终传递的sql参数一致 sql语句一样");
    }

    @Test
    @Transactional//默认
    void testSql() {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",1);
        map.put("type",1);
        UserInfo userInfo=userMapper.selectById3(map);
        logger.info(userInfo);

        Map<String,Object> map1=new HashMap<>();
        map1.put("userId",1);
        map1.put("type",2);
        UserInfo userInfo1=userMapper.selectById3(map1);
        logger.info(userInfo1);
        logger.info(userInfo==userInfo1);
        logger.info("没有命中mybatis的一级缓存--》原因：sql语句不一致");
    }
}