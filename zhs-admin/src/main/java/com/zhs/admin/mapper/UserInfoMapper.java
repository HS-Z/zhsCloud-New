package com.zhs.admin.mapper;

import com.zhs.admin.model.UserInfo;
import com.zhs.common.model.QueryInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {


    UserInfo findByAccount(String account);


    List queryUserInfoList(QueryInfo queryInfo);


}
