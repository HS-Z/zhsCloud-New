package com.zhs.admin.serviceImp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhs.admin.mapper.UserInfoMapper;
import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import com.zhs.common.model.QueryInfo;
import com.zhs.common.model.RequestPageInfo;
import com.zhs.common.model.ResponsePageInfo;
import com.zhs.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImp extends CommonService implements UserInfoService {

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

    @Override
    public List queryAllUserInfoList() {
        return userInfoMapper.selectAll();
    }

    @Override
    public ResponsePageInfo queryUserInfoList(RequestPageInfo requestPageInfo, QueryInfo queryInfo) {

        Page page = PageHelper.startPage(requestPageInfo.getPage(),requestPageInfo.getLimit());
        List userInfoList = userInfoMapper.queryUserInfoList(queryInfo);
        ResponsePageInfo responsePageInfo = pageHelperService.pageHelper(page,userInfoList);
        return responsePageInfo;
    }

}
