package com.hjl.dao;

import com.hjl.pojo.Student;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper {

    List<Student> selectJion();

    Student selectById(int id);

    void updateById(Student student);
}
