package com.yang.edu.dao;

import com.yang.edu.entity.SysRoleMenu;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-21
 **/
public interface SysRoleMenuMapper {
    List<SysRoleMenu> getMenuIdByRoleId(String roleId);
}
