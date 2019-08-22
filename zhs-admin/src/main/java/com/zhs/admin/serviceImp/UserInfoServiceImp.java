package com.zhs.admin.serviceImp;

import com.zhs.admin.mapper.UserInfoMapper;
import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImp implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 根据账号查询用户信息
     * @param account
     * @return
     */
    @Override
    public UserInfo findByAccount(String account) {
        return userInfoMapper.findByAccount(account);
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }


    /**
     * 保存用户信息
     * @param userInfo
     */
    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

}
