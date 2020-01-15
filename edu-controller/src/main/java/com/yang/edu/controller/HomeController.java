package com.yang.edu.controller;

import com.yang.edu.entity.Student;
import com.yang.edu.entity.SysMenu;
import com.yang.edu.entity.SysRoleMenu;
import com.yang.edu.entity.SysUserRole;
import com.yang.edu.service.SysMenuService;
import com.yang.edu.service.SysRoleMenuService;
import com.yang.edu.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-07
 **/
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("")
    public String homePage(Model model, HttpServletRequest request){
        String user = request.getParameter("user");
        HttpSession session   =   request.getSession();

        List<SysUserRole> sysUserRoleList = null;
        List<SysRoleMenu> sysRoleMenuList = null;
        Map<String,List<Map<String,String>>> menuGroup = new HashMap<>();
        List<String> groupList = new ArrayList<>();
        List<Map<String,String>> menuList = new ArrayList<>();

        Object userSession = request.getSession().getAttribute("user_session_key");
        if("student".equals(user)){
            Student studentEntity = (Student)userSession;
            //用户角色关系集合（查询该登录用户有几个角色）
            sysUserRoleList = sysUserRoleService.getRoleIdByUserId(studentEntity.getId());
            if (sysUserRoleList!=null&&sysUserRoleList.size()>0){
                for (SysUserRole userRole:sysUserRoleList) {
                    //菜单Id集合（通过角色查询该角色有哪些权限--菜单）
                    List<SysRoleMenu> menuIds = sysRoleMenuService.getMenuIdByRoleId(userRole.getRoleId());
                    for (SysRoleMenu menuId:menuIds) {
                        //菜单信息
                        SysMenu menu = sysMenuService.getMenuByMenuId(menuId.getMenuId());
                        if(menu!=null){
                            Map<String,String> map = new HashMap<String, String>();
                            //菜单id
                            map.put("menuId", menu.getId());
                            //菜单Url
                            map.put("menuUrl", menu.getMenuUrl());
                            //菜单name
                            map.put("menuName", menu.getMenuName());
                            //菜单parentId
                            map.put("parentId", menu.getParentId());
                            //分组
                            map.put("group", menu.getMenuName());
                            if("0".equals(menu.getIsParent())){
                                menuList.add(map);
                            }else{
                                if(!groupList.contains(menu.getMenuGroup())){
                                    groupList.add(menu.getMenuGroup());
                                }
                            }
                        }
                    }
                }
            }

        }else if("teacher".equals(user)){

        }else{

        }

        request.setAttribute("menus",menuList);
        request.setAttribute("menuGroup",groupList);

        return "home";
    }
}
