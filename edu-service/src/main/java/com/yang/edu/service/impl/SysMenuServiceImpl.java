package com.yang.edu.service.impl;

import com.yang.edu.dao.SysMenuMapper;
import com.yang.edu.entity.SysMenu;
import com.yang.edu.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-20
 **/
@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public void save(SysMenu menu) {
        sysMenuMapper.save(menu);
    }

    @Override
    public List<SysMenu> getMenu() {
        return sysMenuMapper.getMenu();
    }

    @Override
    public SysMenu getMenuByMenuId(String id) {
        return sysMenuMapper.getMenuByMenuId(id);
    }
}
