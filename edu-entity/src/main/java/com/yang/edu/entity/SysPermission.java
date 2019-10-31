package com.yang.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : MrYang
 * @Description : 权限 资源实体
 * @Date : 2019-10-31
 **/
@Data
public class SysPermission {
    private Integer id;

    private String permissionId;

    private String name;

    private String description;

    private String url;

    private String perms;

    private Integer parentId;

    private Integer type;

    private Integer orderNum;

    private String icon;

    private Integer status;

    private Date create_time;

    private Date updateTime;
}
