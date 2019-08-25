package com.zhs.admin.controller;

import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import com.zhs.common.model.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Zhang on 2019/8/12.
 */
@Controller
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    @RequestMapping(value = "loginSystem",method = {RequestMethod.POST})
    @ResponseBody
    public Json loginSystem(@RequestParam("account") String account, @RequestParam("password") String password){
        try {
            UserInfo userInfo = userInfoService.findByAccount("zhs");
            UserInfo userInfo1 = userInfoService.findById(1L);
            return Json.ok();
        }catch (Exception e){
            return Json.fail("登陆失败，请联系管理员！");
        }
    }


}

