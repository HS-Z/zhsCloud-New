package com.zhs.admin.controller;

import com.zhs.admin.model.UserInfo;
import com.zhs.common.model.Json;
import com.zhs.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserInfoController {

    @Autowired
    private CommonUtils commonUtils;


    public void saveUserInfo(){
        String account = "";
        String password = "";

        String UUID = commonUtils.getUUID();
        String newPassword = commonUtils.encryptDataMD5(password,UUID);

        UserInfo userInfo =  new UserInfo();
        userInfo.setAccount(account);
        userInfo.setSecurity(UUID);
        userInfo.setPassword(newPassword);

    }


    @RequestMapping(value = "saveAccount", method = RequestMethod.POST)
    @ResponseBody
    public Json saveAccount(String account, String password){
        try {
            return Json.ok("成功");
        }catch (Exception e){
            return Json.fail("失败");
        }
    }


}
