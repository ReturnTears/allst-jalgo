package com.allst.jvalgo.demo;

import org.junit.Test;

/**
 * 递归Test
 * @author YiYa
 * @since 2020-02-20 上午 12:54
 */
public class RecursionTest {

    @Test
    public void test1() {
        test1(7);
    }

    @Test
    public void test2() {
        int result = factorial(5);
        System.out.println(result);
    }

    /**
     * 打印问题
     * @param n 参数
     */
    private static void test1(int n) {
        if (n > 2)
            test1(n - 1);
        // else
        System.out.println("n = " + n);
    }

    /**
     * 阶乘问题
     * @param n 参数
     */
    private static int factorial(int n) {
        if (n == 1)
            return 1;
        else
            return factorial(n - 1) * n;
    }
}
