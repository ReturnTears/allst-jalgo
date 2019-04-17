package com.allst.jvalgo.basicalgo;

/**
 * 阶乘累加算法:求1+2!+3!+...+20!的和
 * @author June 2019/03/01 下午 10:58
 * @version 1.0
 */
public class FactorialAdd {
    public static void main(String[] args) {
        factorial(4);
    }

    /**
     * 自然数阶乘相加
     * @param num 自然数
     */
    private static void factorial(int num) {
        long sum = 0, start = 1;
        for (int i = 1; i <= num; i++) {
            start = start * i;
            sum += start;
        }
        System.out.println(sum);
    }
}
