package com.yang.edu.entity;

import lombok.Data;

/**
 * @Author : MrYang
 * @Description : 权限 用户角色关系表
 * @Date : 2019-10-31
 **/
@Data
public class SysUserRole {
    private Integer id;

    private String userId;

    private String roleId;
}
