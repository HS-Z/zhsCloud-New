package com.zhs.admin.mapper;

import com.zhs.admin.model.UserInfo;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {


    UserInfo findByAccount(String account);


}
