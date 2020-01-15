package com.yang.edu.service.impl;

import com.yang.edu.dao.StudentMapper;
import com.yang.edu.entity.Student;
import com.yang.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-20
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudent(String studentId) {
        return studentMapper.getStudent(studentId);
    }

    @Override
    public List<Student> getStudentInfoById(String studentId) {
        return null;
    }
}
