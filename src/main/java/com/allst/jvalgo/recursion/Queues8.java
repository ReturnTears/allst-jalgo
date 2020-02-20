package com.allst.jvalgo.recursion;

/**
 * 递归 - 八皇后问题
 * @author YiYa
 * @since 2020-02-20 下午 12:33
 */
public class Queues8 {

    private static final int queueNums = 8;
    /**
     * 理论上使用二维数组可以定位皇后摆放的位置
     * 实际分析中可以使用一维数组:
     * 数组的下标index当作行，对应的值为列
     */
    int[] array = new int[queueNums];
    static int count = 0, sCount = 0;

    public static void main(String[] args) {
        Queues8 queues8 = new Queues8();
        queues8.place(0);
        System.out.println("解法数: " + count);
        System.out.println("冲突数: " + sCount);
    }

    /**
     * 放置第k个皇后
     * 特别注意：
     *      调用place方法时，place中有递归， 每一次递归进入place方法都有for循环，因此会有回溯
     * @param k     第k个
     */
    private void place(int k) {
        // 表示queueNums个皇后已经放置完成
        if (k == queueNums) {
            printMth();
            return;
        }
        // 依次放入皇后并冲突判断
        for (int i = 0; i < queueNums; i++) {
            // 把当前皇后放在该行的第一列开始，依次递增
            array[k] = i;
            // 当前放置的皇后和前面已经放置的皇后位置不冲突
            if (decide(k)) {
                // 不冲突就接着放下一个皇后
                place(k + 1);
            }
            // 如果冲突的话，继续执行for循环里面的循环体
        }
    }

    /**
     * 当放置第k个皇后时，去判断该皇后放置的位置是否和前面已经摆放的所有皇后冲突
     * 冲突是指: 是否在同一行，同一列，同一斜线上
     * @param k     第K个皇后
     * @return      结果true/false
     */
    private boolean decide(int k) {
        sCount++;
        // 因为要与前面已经放置的皇后做比较，故使用for循环
        for (int i = 0; i < k; i++) {
            /**
             * array[i] == array[k]表示这两个位置的皇后在同一列
             * 后面语句判断第k个皇后和第i个皇后是否在同一斜线:
             * 判断依据是: 根据数组的设计，array[i] = value
             * 下标i+1表示当前皇后所在行，value+1表示当前皇后所在列
             * k本身代表行，在递增
             */
           if (array[i] == array[k] || (Math.abs(k - i) == Math.abs(array[k] - array[i]))) {
               return false;
           }
        }
        return true;
    }

    /**
     * 打印皇后放置位置的解法
     */
    private void printMth() {
        count++;
        for (int i = 0; i < queueNums; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
