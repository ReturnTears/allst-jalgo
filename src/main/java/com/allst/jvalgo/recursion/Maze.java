package com.allst.jvalgo.recursion;

import com.allst.jvalgo.basicalgo.FactorialAdd;

/**
 * 递归解决 - 迷宫问题
 *
 * @author YiYa
 * @since 2020-02-20 上午 01:31
 */
public class Maze {

    private static final int ROW = 8;
    private static final int COL = 7;


    public static void main(String[] args) {
        // 使用二维数组模拟迷宫
        int[][] map = new int[ROW][COL];
        // 使用1表示墙体， 把二维数组的四周都置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        System.out.println("输出地图~~~");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 找路
        setWay2(map, 1, 1);
        System.out.println("找路地图~~~");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 规定:
     * 开始位置为(1,1)
     * 终点位置为(6,5)
     * (i,j)为0时表示该点没有走过
     * (1,j)为1表示墙体，2表示通路路可以走，3表示该点已走过但是不通
     * 走迷宫时确定一个策略：下 -> 右 -> 上 -> 左， 如果改点走不通再回溯
     *
     * @param map 地图
     * @param i   (i,j)表示从那个位置开始
     * @param j
     * @return 如果找到通路返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {   // 未走过
                // 按照策略走
                map[i][j] = 2;      // 假定该点可以通
                if (setWay(map, i + 1, j)) {    // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {     // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {     // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {     // 向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 修改行走策略: 上 -> 右 -> 下 -> 左
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {   // 未走过
                // 按照策略走
                map[i][j] = 2;      // 假定该点可以通
                if (setWay2(map, i - 1, j)) {    // 向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {     // 向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {     // 向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {     // 向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
