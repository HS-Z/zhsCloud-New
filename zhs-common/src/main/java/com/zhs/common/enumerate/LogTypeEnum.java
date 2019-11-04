package com.zhs.common.enumerate;

public enum LogTypeEnum {

    SYSTEM("系统"),
    USER("用户"),;

    private String name;

    LogTypeEnum(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }


}
