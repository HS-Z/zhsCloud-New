package com.zhs.admin.service;

import com.zhs.admin.model.UserInfo;
import com.zhs.common.model.QueryInfo;
import com.zhs.common.model.RequestPageInfo;
import com.zhs.common.model.ResponsePageInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo findByAccount(String account);

    UserInfo findById(Long id);

    void saveUserInfo(UserInfo userInfo);

    List queryAllUserInfoList();

    ResponsePageInfo queryUserInfoList(RequestPageInfo requestPageInfo, QueryInfo queryInfo);


}
