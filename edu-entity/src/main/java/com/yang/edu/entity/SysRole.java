package com.yang.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : MrYang
 * @Description : 权限 角色实体
 * @Date : 2019-10-31
 **/
@Data
public class SysRole {
    private Integer id;

    private String roleId;

    private String name;

    private String description;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
