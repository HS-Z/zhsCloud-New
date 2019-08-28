package com.zhs.admin.controller;

import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import com.zhs.common.model.Json;
import com.zhs.common.model.QueryInfo;
import com.zhs.common.model.RequestPageInfo;
import com.zhs.common.model.ResponsePageInfo;
import com.zhs.common.utils.CommonUtils;
import com.zhs.common.utils.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "toUserInfoList",method = RequestMethod.GET)
    public String toUserInfoList(Model model){
        return "user/userInfoList";
    }


    @RequestMapping(value = "queryUserInfoList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponsePageInfo queryUserInfoList(RequestPageInfo requestPageInfo, QueryInfo queryInfo){

        ResponsePageInfo responsePageInfo = userInfoService.queryUserInfoList(requestPageInfo,queryInfo);

        return responsePageInfo;
    }


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


    @RequestMapping(value = "deleteById",method = {RequestMethod.POST})
    @ResponseBody
    public Json deleteById(Long id){
        try {
            userInfoService.deleteById(id);
            return Json.ok("删除成功");
        }catch (Exception e){
            return Json.fail("删除失败");
        }
    }


    /**
     * 用户明细查看
     * @param model 视图
     * @param id  用户id
     * @return
     */
    @RequestMapping(value = "view",method = RequestMethod.GET)
    public String view(Model model, Long id){
        UserInfo userInfo = userInfoService.findById(id);
        String sex = EnumUtils.getSexEnumName(userInfo.getSex());
        userInfo.setSex(sex);
        model.addAttribute("userInfo",userInfo);
        return "user/view";
    }


}
