package com.samples.time;

import java.time.Clock;
import java.time.LocalTime;

/**
 * User: lanxinghua
 * Date: 2019/7/24 20:32
 * Desc: 它代表的是不含日期的时间
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        Clock clock = Clock.systemDefaultZone();
        long t0 = clock.millis();
        System.out.println(t0);
        System.out.println(System.currentTimeMillis());


    }
}
