package com.zhs.common.utils;

import com.zhs.common.enumerate.SexEnum;

public class EnumUtils {


    /**
     * 性别显示
     *
     * @param value 枚举值
     * @return
     */
    public static String getSexEnumName(String value) {
        if (SexEnum.MALE.toString().equals(value)) {
            return "男";
        } else if (SexEnum.FEMALE.toString().equals(value)) {
            return "女";
        } else if (SexEnum.SECRECY.toString().equals(value)) {
            return "保密";
        } else if (SexEnum.UNKNOWN.toString().equals(value)) {
            return "未知";
        } else {
            return "";
        }
    }


}
