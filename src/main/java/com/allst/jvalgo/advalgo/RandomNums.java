package com.allst.jvalgo.advalgo;

/**
 * 利用时间戳得到8位不重复的随机数
 * @author June 2019-05-14 下午 01:31
 * @version 1.0
 */
public class RandomNums {
    public static void main(String[] args) {
        long nowDate = System.currentTimeMillis();

        String sid = Integer.toHexString((int)nowDate);

        System.out.println(sid);
    }
}
