package com.yang.edu.service;

import com.yang.edu.entity.Student;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-20
 **/
public interface StudentService {
    List<Student> getStudentInfoById(String studentId);
    Student getStudent(String studentId);
}
