package com.yang.edu.service;

import com.yang.edu.entity.SysMenu;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-20
 **/
public interface SysMenuService {
    void save(SysMenu menu);
    List<SysMenu> getMenu();
    SysMenu getMenuByMenuId(String id);
}
