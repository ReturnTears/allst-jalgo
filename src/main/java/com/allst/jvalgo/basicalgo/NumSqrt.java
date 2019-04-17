package com.allst.jvalgo.basicalgo;

/**
 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少
 * @author June 2018-01-13 下午 01:56
 * @version 1.0
 */
public class NumSqrt {
    public static void main(String[] args) {
        sqrtNums();
    }

    /**
     * 使用if(Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 268) % 1 == 0) {} 也可以
     * 能够对1求余为0的一定是int型
     */
    private static void sqrtNums() {
        for (int i = 0; i < 100000; i++) {
            if (Math.sqrt(i + 100) % 1 == 0) {
                if (Math.sqrt(i + 268) % 1 == 0) {
                    System.out.println("此整数是:" + i);
                }
            }
        }
    }
}
