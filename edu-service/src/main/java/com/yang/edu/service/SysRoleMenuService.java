package com.yang.edu.service;

import com.yang.edu.entity.SysRoleMenu;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-21
 **/
public interface SysRoleMenuService {
    List<SysRoleMenu> getMenuIdByRoleId(String roleId);
}
