package com.allst.jvalgo.recursion;

/**
 * @author Hutu
 * @since 2024-04-26 下午 11:07
 */
public class RecApp {
    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println("factorial = " + factorial);
        int fact2 = fact2(5);
        System.out.println("fact2 = " + fact2);
        int fibonacci2 = fibonacci2(5);
        System.out.println("fibonacci2 = " + fibonacci2);
    }

    /**
     * 阶乘递归
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * 阶乘递推
     */
    public static int fact2(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }
        return s;
    }

    /**
     * Fibonacci数列递推
     */
    public static int fibonacci2(int n) {
        int f0 = 1, f1 = 1, f = 1;
        if (n < 2) {
            return 1;
        }
        for (int i = 0; i < n - 1; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
