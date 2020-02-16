package com.allst.jvalgo.sparse;

import java.util.Arrays;

/**
 * 稀疏数组
 * @author YiYa
 * @since 2020-02-16 下午 06:24
 */
public class SparseArray {

    /**
     * 原始数组的行列
     */
    private final static Integer originCol = 11;
    private final static Integer originRow = 11;

    public static void main(String[] args) {
        int[][] sparseArr = originToSparseArray();
        sparseToArray(sparseArr);
    }

    /**
     * 二维数组转稀疏数组
     */
    private static int[][] originToSparseArray () {
        int[][] originArr = new int[originCol][originRow];
        originArr[2][3] = 1;
        originArr[3][4] = 2;

        System.out.println("原始的二维数组: ");
        for (int[] row : originArr) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }
        // System.out.println(Arrays.deepToString(originArr));

        // 二维数组转稀疏数组思路:
        // 1、获取有效数据的个数
        int sum = 0;
        for (int i = 0; i < originRow; i++) {
            for (int j = 0; j < originCol; j++) {
                if (originArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2、创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 3、赋值
        sparseArr[0][0] = originRow;
        sparseArr[0][1] = originCol;
        sparseArr[0][2] = sum;
        // 用于记录第几个非0数据
        int count = 0;
        for (int i = 0; i < originRow; i++) {
            for (int j = 0; j < originCol; j++) {
                if (originArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = originArr[i][j];
                }
            }
        }
        System.out.println("转换为稀疏数组: ");
        /*for (int[] row : sparseArr) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }*/
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

        // 返回稀疏数组
        return sparseArr;
    }

    /**
     * 将稀疏数组转换为二维数组
     * @return  结果
     */
    private static int[][] sparseToArray (int[][] sparseArr) {
        int[][] originArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            originArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组: ");
        for (int[] ori : originArr) {
            for (int data : ori) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return originArr;
    }

}
