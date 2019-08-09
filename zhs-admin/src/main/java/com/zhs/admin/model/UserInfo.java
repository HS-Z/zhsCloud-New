package com.zhs.admin.model;

import com.zhs.common.model.CommonModel;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Zhang on 2019/8/9.
 */
@Table(name = "t_zhs_user_info")
public class UserInfo extends CommonModel{

    private String userName;  //用户名称

    private String userType;  //用户类型

    private String sex;  //性别 1男 2女 3保密

    private String account;  //登陆账号

    private String password;  //登陆密码

    private String security;  //加密时生成的key

    private String email;  //邮箱

    private String phone;  //手机号码

    private String address;  //住址

    private String state;  //用户状态

    private Date lastLoginTime;  //最近一次登陆时间（该值改变时，不更新lastUpdate）

    private Boolean isAdmin=Boolean.FALSE;  //是否是管理员

    private Boolean isLock=Boolean.FALSE;  //账号是否锁定，默认为否

    private Date lockTime;  //账号锁定时间

    private Boolean logOut=Boolean.FALSE;  //账号是否已注销，默认为否

    private Date logOutTime;  //账号注销时间
}
