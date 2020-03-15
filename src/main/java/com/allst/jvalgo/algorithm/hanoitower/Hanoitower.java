package com.allst.jvalgo.algorithm.hanoitower;

/**
 * 分治算法实现~汉诺塔
 *
 * @author YiYa
 * @since 2020-03-15 下午 05:55
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔算法
     * @param num 盘的数量
     * @param a A
     * @param b B
     * @param c C
     */
    private static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.printf("第 1 个盘从 %s -> %s\n", a, c);
        } else {
            // 如果num >= 2, 我们总是可以看做连个盘: 最下边的是一个盘， 上面的所有盘看作一个整体的盘
            hanoiTower(num - 1, a, c, b);   // 先把最上面的所有盘a -> b, 移动过程会用到c
            System.out.printf("第 %d 个盘从 %s -> %s\n", num, a, c); // 把最下边的盘a -> c
            hanoiTower(num - 1, b, a, c);   // 把b塔上的所有盘从b -> c, 移动过程是由到a
        }
    }

}
