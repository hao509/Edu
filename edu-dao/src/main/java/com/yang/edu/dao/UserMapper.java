package com.yang.edu.dao;

import com.yang.edu.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAllUser();
    void save(UserEntity user);
}
