package com.yang.edu.service;

import com.yang.edu.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();
    void save(UserEntity user);
}
