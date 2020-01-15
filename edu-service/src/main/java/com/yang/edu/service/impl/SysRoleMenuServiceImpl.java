package com.yang.edu.service.impl;

import com.yang.edu.dao.SysRoleMenuMapper;
import com.yang.edu.entity.SysRoleMenu;
import com.yang.edu.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-21
 **/
@Service
@Transactional
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysRoleMenu> getMenuIdByRoleId(String roleId) {
        return sysRoleMenuMapper.getMenuIdByRoleId(roleId);
    }
}
