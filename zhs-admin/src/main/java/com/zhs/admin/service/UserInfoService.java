package com.zhs.admin.service;

import com.zhs.admin.model.UserInfo;

public interface UserInfoService {

    UserInfo findByAccount(String account);

    UserInfo findById(Long id);

    void saveUserInfo(UserInfo userInfo);

}
