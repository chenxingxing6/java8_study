package com.samples.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * User: lanxinghua
 * Date: 2019/7/24 20:32
 * Desc: 不包含具体时间的日期
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        System.out.println(today);
        System.out.println(tomorrow);
        System.out.println(yesterday);

        LocalDate localDate = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);

    }
}
