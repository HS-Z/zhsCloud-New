package com.zhs.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Zhang on 2019/8/12.
 */
public class DateUtils {


    /**
     * 获取时间戳（秒）
     * @return  10位数字
     */
    public static Long getTimeStampWithSecond(){
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }


    /**
     * 获取时间戳（豪秒）
     * @return  13位数字
     */
    public static Long getTimeStampWithMillisecond(){
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    /**
     * 获取当前时间，精确到天
     * @return 2019-09-23
     */
    public static String getNowDate(){
        LocalDate date = LocalDate.now();
        return date.toString();
    }


    /**
     * 获取当天时间，不含具体的年月日，精确到毫秒
     * @return  00:07:50.251
     */
    public static String getDayTime(){
        LocalTime localTime = LocalTime.now();
        return localTime.toString();
    }



}
