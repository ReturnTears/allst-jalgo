package com.allst.jvalgo.basicalgo;

/**
 * 任何>=6的偶数都可以分解为两个质数的和，键盘输入一个偶数，输出其分解的质数
 * @author June 2019/03/02 上午 12:03
 * @version 1.0
 */
public class NumsDecom {
    public static void main(String[] args) {
        decom(22);
    }

    private static void decom(int num) {
        if (num < 6 || num % 2 != 0) {
            System.out.println("input error.");
            return;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (isPrim(i) && isPrim(num - i)) {
                System.out.println(num + " => " + i + " : " + (num - i));
            }
        }
    }

    /**
     * 判断是否是质数
     * @param num 数字
     * @return
     */
    private static boolean isPrim(int num) {
        boolean isPrime = true;
        // 判断是否是质数
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                continue;
            }
        }
        return isPrime;
    }
}
