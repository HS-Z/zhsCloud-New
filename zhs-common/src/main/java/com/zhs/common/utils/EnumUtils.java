package com.zhs.common.utils;

import com.zhs.common.enumerate.SexEnum;

public class EnumUtils {


    /**
     * 性别显示
     * @param value  枚举值
     * @return
     */
    public String getSexEnumName(String value){
        if (SexEnum.MALE.equals(value)){
            return "男";
        }else if (SexEnum.FEMALE.equals(value)){
            return "女";
        }else if (SexEnum.SECRECY.equals(value)){
            return "保密";
        }else if (SexEnum.UNKNOWN.equals(value)){
            return "未知";
        }else {
            return "";
        }
    }




}
