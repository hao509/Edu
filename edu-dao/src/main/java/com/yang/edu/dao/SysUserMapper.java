package com.yang.edu.dao;

import com.yang.edu.entity.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(SysUser key);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(SysUser key);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}