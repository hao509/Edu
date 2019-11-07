package com.yang.edu.util.shiro;

import com.yang.edu.entity.UserEntity;
import com.yang.edu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @Author : MrYang
 * @Description : 自定义realm，完成认证和授权逻辑
 * @Date : 2019-10-28
 **/
public class MyUserRealm extends AuthorizingRealm {



    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");

        //给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("xx:xxx");
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        UserEntity userEntity = (UserEntity) subject.getPrincipal();
        //到数据库查询当前用户的授权信息
        userService.getUserEntityByName(userEntity.getUserName());

        //授权
        info.addStringPermission(userService.getUserEntityByName(userEntity.getUserName()).getUserPassword());
        return info;
    }

    private UserService userService;

    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken myToken = (UsernamePasswordToken)token;
        //验证数据库是否存在该用户，并获取该用户信息
        UserEntity userEntity = userService.getUserEntityByName(myToken.getUsername());
        if(userEntity==null){
            //用户名不存在
            return null;//shiro底层会抛出UnknownAccountExcption
        }

        //第一个参数为principal 返回给token的数据信息，授权时用到
        //第二个参数为密码，进行比较
        return new SimpleAuthenticationInfo(userEntity,userEntity.getUserPassword(),"");
    }


}
