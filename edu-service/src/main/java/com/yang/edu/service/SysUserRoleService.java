package com.yang.edu.service;

import com.yang.edu.entity.SysUserRole;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : --
 **/
public interface SysUserRoleService {
    List<SysUserRole> getRoleIdByUserId(String userId);
}
