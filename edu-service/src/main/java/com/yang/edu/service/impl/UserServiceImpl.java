package com.yang.edu.service.impl;

import com.yang.edu.dao.UserMapper;
import com.yang.edu.entity.UserEntity;
import com.yang.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserEntity> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void save(UserEntity user) {
        userMapper.save(user);
    }

    @Override
    public UserEntity getUserEntityByName(String userName) {
        return null;
    }
}
