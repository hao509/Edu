package com.yang.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : MrYang
 * @Description : 权限 角色资源关系实体
 * @Date : 2019-10-31
 **/
@Data
public class SysRolePermission {
    private Integer id;

    private String roleId;

    private String permissionId;

}
