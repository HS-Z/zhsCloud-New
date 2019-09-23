package com.zhs.common.enumerate;

public enum LogTypeEnum {

    SYSTEM("系统操作"),
    USER("用户操作"),
    ;

    private String name;

    LogTypeEnum(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }


}
