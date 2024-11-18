package com.allst.jvalgo.advalgo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 利用时间戳得到8位不重复的随机数
 *
 * @author June 2019-05-14 下午 01:31
 * @version 1.0
 */
public class RandomNums {
    public static void main(String[] args) {
        long nowDate = System.currentTimeMillis();

        String sid = Integer.toHexString((int) nowDate);

        System.out.println(sid);

        Random r = new Random();
        int[] num = r.ints().limit(8).toArray();
        System.out.println(randomAccess(num));
    }

    /* 随机访问元素 */
    static int randomAccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机抽取一个数字
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取并返回随机元素
        int randomNum = nums[randomIndex];
        return randomNum;
    }
}
