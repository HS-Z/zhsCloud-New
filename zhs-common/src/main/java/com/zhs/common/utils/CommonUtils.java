package com.zhs.common.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Zhang on 2019/8/12.
 */
@Component
public class CommonUtils {


    /**
     * 获取 UUID
     *
     * @return UUID
     */
    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * 对数据进行加密
     *
     * @param data 要加密的数据
     * @param salt 加密的盐值
     * @return 加密后的值
     */
    public String encryptDataMD5(String data, String salt) {

        ByteSource newSalt = ByteSource.Util.bytes(salt);

        /*
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始数据
         * 第三个参数为盐值
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         */

        String newData = new SimpleHash("MD5", data, newSalt, 1024).toHex();

        return newData;
    }


    /**
     * 判断一个对象是否为null或为空
     *
     * @param o
     * @return
     */
    public static boolean isEmpty(Object o) {

        if (o == null) {
            return true;
        }

        if (o instanceof String) {
            if (StringUtils.isBlank(o.toString())) {
                return true;
            }
        } else if (o instanceof Collection) {
            if (((Collection) o).isEmpty()) {
                return true;
            }
        } else if (o.getClass().isArray()) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }


    /**
     * 判断一个对象是否为null或为空
     *
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }


}
