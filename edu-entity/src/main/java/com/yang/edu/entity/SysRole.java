package com.yang.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-21
 **/
@Data
public class SysRole {
    private String roleId;

    private String name;

    private String description;

    private  Integer status;

    private Date createTime;

    private Date updateTime;
}
