package com.samples.time;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * User: lanxinghua
 * Date: 2019/7/25 10:12
 * Desc:
 */
public class DateUtil {
    public static void main(String[] args) {
        // String format = cn.hutool.core.date.DateUtil.format(new Date(), "yyyyMMdd");
        LocalDateTime localDateTime = timestampToDateTime(System.currentTimeMillis());
        System.out.println(localDateTime);
        long time = localDateTimeToTimestamp(localDateTime);
        System.out.println(time);
        System.out.println(format(System.currentTimeMillis(), "yyyyMMdd"));

    }


    /**
     * 格式化时间
     * @param timeStamp
     * @param pattern
     * @return
     */
    public static String format(Long timeStamp, String pattern) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = timestampToDateTime(timeStamp);
        return localDateTime.format(format);
    }


    /**
     * 时间戳转localDateTime
     * @param timestamp
     * @return
     */
    public static LocalDateTime timestampToDateTime(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * localDateTime转时间戳
     * @param localDateTime
     * @return
     */
    public static long localDateTimeToTimestamp(LocalDateTime localDateTime){
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return instant.toEpochMilli();
    }
}
