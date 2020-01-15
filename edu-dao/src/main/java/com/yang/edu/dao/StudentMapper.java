package com.yang.edu.dao;

import com.yang.edu.entity.Student;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-20
 **/
public interface StudentMapper {
    //List<Student> getStudentInfo();
    Student getStudent(String studentId);
}
