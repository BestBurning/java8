package com.diyishuai.lambda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

/**
 * Created by Bruce on 16/8/9.
 * SQL -> Java
 --------------------------
 date -> LocalDate
 time -> LocalTime
 timestamp -> LocalDateTime
 */
public class LocalDateAndTimeAndDateTime {

    public static void main(String[] args) {
//        localdate();
//        localtime();
        localdatetime();

    }


    public static void localdate(){
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate someday = LocalDate.of(2016,8,9);

        LocalDate withstr = LocalDate.parse("2016-08-09");

        if (someday.equals(withstr))
            System.out.println(true);
        else
            System.out.println(false);

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2016-08-09
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2016-08-02
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2016-08-31
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2016-09-01
        // 取2016年9月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2016-09-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2016-09-05
    }

    public static void localtime() {
        //包含毫秒
        LocalTime now = LocalTime.now();
        System.out.println(now);

        //清除毫秒数
        LocalTime time = LocalTime.now().withNano(0);
        System.out.println(time);

        //构造时间
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
        System.out.println(zero);
        System.out.println(mid);

    }

    public static void localdatetime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }
}
