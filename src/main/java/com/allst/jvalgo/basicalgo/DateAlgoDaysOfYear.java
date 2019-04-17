package com.allst.jvalgo.basicalgo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * 计算出某一年的具体日期是这一年的第几天
 * @author June 2019/03/02 下午 05:34
 * @version 1.0
 */
public class DateAlgoDaysOfYear {
    public static void main(String[] args) {
//        dayOfYear("2019-03-02");
        System.out.println(getDate());
    }

    /**
     * day of year algo
     * @param date yyyy-MM-dd
     */
    private static void dayOfYear(String date) {
        String[] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int mon = Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        // 每个月的天数
        int[] dayOfM = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 判断是否是闰年(闰年二月29天, 平年二月28天)
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + "是闰年");
            dayOfM[1] = 29;
        } else {
            System.out.println(year + "是平年");
        }
        // 记录第几天
        int countDay = 0;
        for (int i = 0; i < mon - 1; i++) {
            countDay += dayOfM[i];
        }
        countDay += day;

        System.out.println("输入日期" + date + "是"+ year +"年的第 " + countDay + " 天");
    }

    /**
     * 获取当前日期
     * @return
     */
    private static Date getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        Date date = new Date();
        System.out.println(localDate);
        return new Date();
    }
}
