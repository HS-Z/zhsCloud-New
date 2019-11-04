package com.zhs.common.enumerate;

public enum LogOperateTypeEnum {

    ADD("新增"),
    UPDATE("编辑"),
    DELETE("删除"),
    LOCK("锁定"),
    UNLOCK("解锁"),
    SIGN_IN("登录"),
    SIGN_OUT("退出"),
    LOG_OUT("注销"),
    LOG_ON("注册"),
    UPDATE_PASSWORD("更改密码");

    private String name;

    LogOperateTypeEnum(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }


}
