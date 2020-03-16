package com.allst.jvalgo.algorithm.dynamic;

/**
 * 动态背包问题
 *
 * @author YiYa
 * @since 2020-03-16 下午 11:48
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        // 物品的重量
        int[] w = {1, 4, 3};
        // 物品的价值
        int[] val = {1500, 3000, 2000};
        // 背包的容量
        int m = 4;
        // 物品的个数
        int n = val.length;

        // 创建二维数组, v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];

        // 记录商品放入情况
        int[][] path = new int[n + 1][m + 1];

        // 初始化第一行、第一列均为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; // 第一列置为0
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0; // 第一行置为0
        }

        // 动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下v 看看目前的情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=============================================================");

        int i = path.length - 1;        // 行的最大下标
        int j = path[0].length - 1;     // 列的最大下标
        while (i > 0 && j > 0) {        // 从path的最后开始找
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1]; //w[i-1]
            }
            i--;
        }
    }
}
