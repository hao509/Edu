package com.yang.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : MrYang
 * @Description : 权限 用户实体
 * @Date : 2019-10-31
 **/
@Data
public class SysUser {
    private Integer id;

    private String userId;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String phone;

    private Integer sex;

    private Integer age;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;
}
