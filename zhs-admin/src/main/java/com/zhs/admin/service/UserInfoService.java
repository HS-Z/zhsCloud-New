package com.zhs.admin.service;

import com.zhs.admin.model.UserInfo;

public interface UserInfoService {

    UserInfo findByAccount(String account);

    void saveUserInfo(UserInfo userInfo);

}
