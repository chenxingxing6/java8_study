package com.samples.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User: lanxinghua
 * Date: 2019/7/24 20:32
 * Desc: 它包含了日期及时间
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse("2018-01-12 17:07:05",df);
        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt);
    }
}
