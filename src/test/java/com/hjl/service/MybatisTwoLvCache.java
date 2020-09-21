package com.hjl.service;

import com.hjl.dao.StudentMapper;
import com.hjl.pojo.Student;
import com.hjl.springbootmybatisdemo.SpringbootMybatisDemoApplication;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = SpringbootMybatisDemoApplication.class) //启动项类
public class MybatisTwoLvCache {
    @Autowired
    private StudentMapper studentMapper;

    Logger logger=Logger.getLogger(this.getClass());

    /**
     * 测试二级缓存效果
     * 需要*Mapper.xml开启二级缓存
     **/
    @Test
     void selectById() {
        Student student=studentMapper.selectById(1);
        logger.info(student);
        Student student1=studentMapper.selectById(1);
        logger.info(student1);

        logger.info(student== student1);//false的原因是由于每次序列化产生新的对象

    }

    /**
     * 测试多表联查的二级缓存效果
     **/
    @Test
    public void testJoin(){

        logger.info(studentMapper.selectJion());
        logger.info(studentMapper.selectJion());

        Student student=new Student();
        student.setId(1);
        student.setSchool("常盘台中学");
        student.setClassName("二年级");
        studentMapper.updateById(student) ;

        logger.info(studentMapper.selectJion());
    }

}
