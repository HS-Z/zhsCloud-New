package com.zhs.admin.controller;

import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import com.zhs.common.model.Json;
import com.zhs.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "saveUserInfo",method = RequestMethod.GET)
    public void saveUserInfo(){
        String account = "zhs";
        String password = "111111";

        String UUID = commonUtils.getUUID();
        String newPassword = commonUtils.encryptDataMD5(password,UUID);

        UserInfo userInfo =  new UserInfo();
        userInfo.setAccount(account);
        userInfo.setSecurity(UUID);
        userInfo.setPassword(newPassword);
        userInfo.setAdmin(Boolean.TRUE);

        userInfoService.saveUserInfo(userInfo);

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
