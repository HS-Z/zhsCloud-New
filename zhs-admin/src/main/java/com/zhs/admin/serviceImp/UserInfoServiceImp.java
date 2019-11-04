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

import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImp extends CommonService implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 根据账号查询用户信息
     *
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
     *
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

        Page page = PageHelper.startPage(requestPageInfo.getPage(), requestPageInfo.getLimit());
        List userInfoList = userInfoMapper.queryUserInfoList(queryInfo);
        ResponsePageInfo responsePageInfo = pageHelperService.pageHelper(page, userInfoList);
        return responsePageInfo;
    }


    /**
     * 物理删除
     *
     * @param id 用户id
     */
    @Override
    public void deleteById(Long id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }


    /**
     * 逻辑删除
     *
     * @param id 用户id
     */
    @Override
    public void deleteByIdAnother(Long id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        userInfo.setDeleted(Boolean.TRUE);
        userInfoMapper.updateByPrimaryKey(userInfo);
    }


    @Override
    public void saveOrUpdate(UserInfo userInfo) {

        if (userInfo != null) {

            if (userInfo.getId() == null) {   //新增用户信息

                String UUID = commonUtils.getUUID();
                String newPassword = commonUtils.encryptDataMD5(userInfo.getPassword(), UUID);

                userInfo.setSecurity(UUID);
                userInfo.setPassword(newPassword);
                userInfo.setCreateDate(new Date());
                userInfo.setLastEditDate(new Date());
                userInfo.setCreator("");
                userInfo.setLastEditor("");
                userInfo.setDeleted(Boolean.FALSE);
                userInfo.setLock(Boolean.FALSE);
                userInfo.setLogOut(Boolean.FALSE);

                userInfoMapper.insert(userInfo);

            } else {   //更新用户信息
                UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(userInfo.getId());
                userInfo1.setLastEditDate(new Date());
                userInfo1.setLastEditor("");
                userInfo1.setAdmin(userInfo.getAdmin());
                userInfo1.setSex(userInfo.getSex());
                userInfo1.setAddress(userInfo.getAddress());
                userInfo1.setEmail(userInfo.getEmail());
                userInfo1.setPhone(userInfo.getPhone());
                userInfo1.setUserName(userInfo.getUserName());
                userInfo1.setUserType(userInfo.getUserType());
                userInfo1.setDescription(userInfo.getDescription());

                userInfoMapper.updateByPrimaryKey(userInfo1);
            }
        }

    }


    /**
     * 账号的锁定与解锁
     *
     * @param id     用户id
     * @param isLock //锁定状态
     */
    @Override
    public void lock(Long id, Boolean isLock) {
        if (id == null) {
            return;
        }

        UserInfo userInfo = findById(id);
        if (userInfo != null) {

            userInfo.setLock(isLock);

            if (isLock) {  //账号锁定
                userInfo.setLockTime(new Date());
            } else {   //账号解锁
                userInfo.setLockTime(null);
            }

            userInfoMapper.updateByPrimaryKey(userInfo);
        }

    }

}
