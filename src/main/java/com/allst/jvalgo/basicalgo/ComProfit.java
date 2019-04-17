package com.allst.jvalgo.basicalgo;

import java.util.Scanner;

/**
 * 利润计算
 * @author June 2018-01-13 下午 12:08
 * @version 1.0
 */
public class ComProfit {
    public static void main(String[] args) {
        companyProfit1();
        companyProfit2();
    }

    /**
     * 方法一：这种方式是最笨的方式
     * ----------
     * 企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%;
     * 利润高于10万元，低于20万元时，低于10万元的部分按 10%提成，高于10万元的部分，可可提成7.5%;
     * 20万到40万之间时，高于20万元的部分，可提成5%;
     * 40万到60万之间时高于40万元的部分， 可提成3%;
     * 60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求 应发放奖金总数
     */
    private static void companyProfit1() {
        System.out.println("输入利润提成(单位万元):");
        Scanner scan = new Scanner(System.in);
        double profit = scan.nextDouble();
        double bonus = 0, num1 = 10, num2 = 20, num4 = 40, num6 = 60, num = 100;
        if (profit <= num1) {
            bonus = profit * 0.1;
        } else if (num1 < profit && profit < num2) {
            bonus = (num1 * 0.1 + (profit - num1) * 0.075);
        } else if (num2 <= profit && profit < num4) {
            bonus = (num1 * 0.1 + (num2 - num1) * 0.075 + (profit - num2) * 0.05);
        } else if (num4 <= profit && profit < num6) {
            bonus = (num1 * 0.1 + (num2 - num1) * 0.075 + (num4 - num2) * 0.05 + (profit - num4) * 0.03);
        } else if (num6 <= profit && profit < num) {
            bonus = (num1 * 0.1 + (num2 - num1) * 0.075 + (num4 - num2) * 0.05 + (num6 - num4) * 0.03 + (profit - num6) * 0.015);
        } else {
            bonus = (num1 * 0.1 + (num2 - num1) * 0.075 + (num4 - num2) * 0.05 + (num6 - num4) * 0.03 + (num - num6) * 0.015 + (profit - num) * 0.01);
        }
        System.out.println("奖金为: " + bonus + "万元");
    }

    /**
     * 方法二:采用累加的方式
     */
    private static void companyProfit2() {
        System.out.println("输入利润提成(单位万元):");
        Scanner scan = new Scanner(System.in);
        double profit = scan.nextDouble();
        double bonus = 0;
        double nums = profit;
        if (profit > 100) {
            profit = nums - 100;
            nums = 100;
            bonus += profit * 0.01;
        }
        if (nums > 60) {
            profit = nums - 60;
            nums = 60;
            bonus += profit * 0.015;
        }
        if (nums > 40) {
            profit = nums - 40;
            nums = 40;
            bonus += profit * 0.03;
        }
        if (nums > 20) {
            profit = nums - 20;
            nums = 20;
            bonus += profit * 0.05;
        }
        if (nums > 10) {
            profit = nums - 10;
            nums = 10;
            bonus += profit * 0.075;
        }
        bonus += nums * 0.1;
        System.out.println("奖金为: " + bonus + "万元");
    }
}
