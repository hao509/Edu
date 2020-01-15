package com.yang.edu.service.impl;

import com.yang.edu.dao.SysUserRoleMapper;
import com.yang.edu.entity.SysUserRole;
import com.yang.edu.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date :
 **/
@Service
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<SysUserRole> getRoleIdByUserId(String userId) {
        return sysUserRoleMapper.getRoleIdByUserId(userId);
    }
}
