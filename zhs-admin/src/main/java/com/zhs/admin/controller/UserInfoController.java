package com.zhs.admin.controller;

import com.alibaba.fastjson.JSON;
import com.zhs.admin.model.UserInfo;
import com.zhs.admin.service.UserInfoService;
import com.zhs.common.model.Json;
import com.zhs.common.model.QueryInfo;
import com.zhs.common.model.RequestPageInfo;
import com.zhs.common.model.ResponsePageInfo;
import com.zhs.common.utils.CommonUtils;
import com.zhs.common.utils.EnumUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("userInfo")
public class UserInfoController {

    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "toUserInfoList", method = RequestMethod.GET)
    public String toUserInfoList(Model model) {
        return "user/userInfoList";
    }


    @RequestMapping(value = "queryUserInfoList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponsePageInfo queryUserInfoList(RequestPageInfo requestPageInfo, QueryInfo queryInfo) {

        ResponsePageInfo responsePageInfo = userInfoService.queryUserInfoList(requestPageInfo, queryInfo);

        return responsePageInfo;
    }


    @RequestMapping(value = "saveUserInfo", method = RequestMethod.GET)
    public void saveUserInfo() {
        String account = "zhs";
        String password = "111111";

        String UUID = commonUtils.getUUID();
        String newPassword = commonUtils.encryptDataMD5(password, UUID);

        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(account);
        userInfo.setSecurity(UUID);
        userInfo.setPassword(newPassword);
        userInfo.setAdmin(Boolean.TRUE);

        userInfoService.saveUserInfo(userInfo);

    }


    @RequestMapping(value = "saveAccount", method = RequestMethod.POST)
    @ResponseBody
    public Json saveAccount(String account, String password) {
        try {
            return Json.ok("成功");
        } catch (Exception e) {
            return Json.fail("失败");
        }
    }


    @RequestMapping(value = "deleteById", method = {RequestMethod.POST})
    @ResponseBody
    public Json deleteById(Long id) {
        try {
            userInfoService.deleteById(id);
            logger.info("");
            return Json.ok("删除成功");
        } catch (Exception e) {
            return Json.fail("删除失败");
        }
    }


    /**
     * 用户明细查看
     *
     * @param model 视图
     * @param id    用户id
     * @return
     */
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String view(Model model, Long id) {
        UserInfo userInfo = userInfoService.findById(id);
        String sex = EnumUtils.getSexEnumName(userInfo.getSex());
        userInfo.setSex(sex);
        model.addAttribute("userInfo", userInfo);
        return "user/view";
    }


    @RequestMapping(value = "toAddOrEdit", method = RequestMethod.GET)
    public String toAddOrEdit(Model model, Long id) {

        if (id != null) {
            UserInfo userInfo = userInfoService.findById(id);
            model.addAttribute("userInfo", userInfo);
            return "user/editUserInfo";
        }

        return "user/addUserInfo";
    }


    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Json saveOrUpdate(UserInfo userInfo) {

        try {

            if (userInfo != null && userInfo.getId() == null) {    //新增

                if (StringUtils.isBlank(userInfo.getAccount())) {
                    return Json.fail("账号不能为空！");
                }

                UserInfo userInfo1 = userInfoService.findByAccount(userInfo.getAccount());

                if (userInfo1 != null) {
                    return Json.fail("该账号已存在！");
                }
            }

            userInfoService.saveOrUpdate(userInfo);

            return Json.ok("操作成功！");

        } catch (Exception e) {
            return Json.fail("操作失败！");
        }

    }


    /**
     * 账号的锁定与解锁
     *
     * @param id     用户id
     * @param isLock 锁定状态
     */
    @RequestMapping(value = "lock", method = {RequestMethod.POST})
    @ResponseBody
    public Json lock(Long id, Boolean isLock) {
        String msg;

        try {

            if (isLock) {
                msg = "账号已锁定！";
            } else {
                msg = "账号已解锁！";
            }

            userInfoService.lock(id, isLock);

            return Json.ok(msg);
        } catch (Exception e) {
            return Json.fail();
        }
    }


    @RequestMapping(value = "deleteChoose", method = {RequestMethod.POST})
    @ResponseBody
    public Json deleteChoose(String ids) {
        try {
            if (StringUtils.isBlank(ids)) {
                return Json.fail("请选择要删除的数据！");
            }

            List<Long> idList = JSON.parseArray(ids, Long.class);
            for (Long id : idList) {
                userInfoService.deleteByIdAnother(id);
            }

            return Json.ok("操作成功！");
        } catch (Exception e) {
            return Json.fail("操作失败！");
        }
    }


}
