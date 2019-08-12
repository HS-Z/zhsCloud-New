package com.zhs.admin.config.shiro;

import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 权限控制
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        if (principalCollection.getPrimaryPrincipal() == null) {
            return null;
        }

        String account= (String) principalCollection.getPrimaryPrincipal();  //登陆账号

        UserInfo userInfo=userInfoService.findByAccount(account);
        if (userInfo == null){
            return null;
        }

        //添加角色权限和控制
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }


    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        if (authenticationToken.getPrincipal() == null) {
            return null;
        }

        String account=(String) authenticationToken.getPrincipal();  //登陆账号

        UserInfo userInfo=userInfoService.findByAccount(account);

        if (userInfo == null){  //账号不存在
            throw new UnknownAccountException();
        }

        if (Boolean.TRUE.equals(userInfo.getLogOut())){  //账号已注销
            throw new UnknownAccountException();
        }

        /*
         *  记录用户在某段时间登陆的次数，访问一次，计数一次，不考虑密码是否正确
         *  目前只有在密码错误多次的情况下，该账号会被锁定，成功登陆后，会清除该用户的记录数，不妨碍下次登陆
         */



        // 获取盐值
        ByteSource salt = ByteSource.Util.bytes(userInfo.getSecurity());

        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(account, userInfo.getPassword(), salt, getName());

        return authenticationInfo;
    }
}
