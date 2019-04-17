package com.allst.jvalgo.basicalgo;

import javax.swing.*;
import java.awt.*;

/**
 * 杨辉三角 Pascal's triangle
 * 帕斯卡三角形，是一个三角形矩阵，其顶端是 1,视为(row0).
 *                            第1行(row1)(1&1)两个1,这两个1是由他们上头左右两数之和 (不在三角形内的数视为0).
 *                  依此类推产生第2行(row2):0+1=1;1+1=2;1+0=1.
 *                            第3行(row3):0+1=1;1+2=3; 2+1=3;1+0=1. 循此法可以产生以下诸行
 * @author June 2019/03/01 下午 11:15
 * @version 1.0
 */
public class Pascal {
    public static void main(String[] args) {
        new PascalStr();

//        printPascal(5);
    }

    /**
     * 以二维数组的方式
     * 打印杨辉三角
     * @param row 行数
     */
    private static void printPascal(int row) {
        // 创建二维数组
        int[][] triangle = new int[row][];
        // 遍历二维数组的第一层
        for (int i = 0; i < triangle.length; i++) {
            // 初始化第二层数组的大小
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
    }

    /**
     *
     */
    private static class PascalStr extends JFrame {
        private static final long serialVersionUID = 1L;
        private PascalStr() {
            setBackground(Color.green);
            setTitle("帕斯卡三角形");
            setSize(660, 480);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        private long combi(int n, int r) {
            long p = 1;
            for (int i = 1; i <= r; i++) {
                p = p * (n - i + 1) / i;
            }
            return p;
        }

        @Override
        public void paint(Graphics g) {
            final int N = 12;
            int n, r;
            for (n = 0; n <= N; n++) {
                for (r = 0; r <= n; r++) {
                    g.drawString("" + combi(n, r), (N - n) * 20 + r * 40, n * 20 + 50);
                }
            }
        }
    }
}
