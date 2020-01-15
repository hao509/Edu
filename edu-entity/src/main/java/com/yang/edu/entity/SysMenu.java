package com.yang.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-20
 **/
@Data
public class SysMenu {
    private String id;

    private String menuName;

    private String menuUrl;

    private String menuCode;

    private String parentId;

    private String isParent;

    private String menuGroup;

    private Integer orderNum;

    private String icon;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
