package com.allst.jvalgo.recursion;

/**
 * 八皇后问题
 *
 * @author YiYa
 * @since 2020-02-20 上午 11:00
 */
public class EightQueensPuzzle {
    // max表示共有多少个皇后
    int max = 8;
    // 定义数组存放皇后放置位置的结果
    int[] array = new int[max];
    // 统计解法数
    static int count = 0;
    // 统计判断冲突的次数
    static int judgeCount = 0;

    public static void main(String[] args) {
        EightQueensPuzzle puzzle = new EightQueensPuzzle();
        puzzle.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w+
    }

    /**
     * 将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int arr : array) {
            System.out.print(arr + " ");
        }
        System.out.println();
    }

    /**
     * 查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n     表示第n个皇后
     * @return      结果
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            /*
             * array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
             * Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
             * 判断是否在同一行, 没有必要判断，n 每次都在递增
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     * 注意:
     *       check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
     * @param n     第n个
     */
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
}
