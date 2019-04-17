package com.allst.jvalgo.basicalgo;

/**
 * 置换问题
 * permute:vt. 交换；变更；排列
 * @author June 2019/03/01 下午 10:50
 * @version 1.0
 */
public class PermuteQuestion {
    public static void main(String[] args) {
        bottleWater();
    }

    /**
     * 空瓶换水的问题：
     * 假设50瓶饮料，三个空瓶可以换一瓶饮料,一共可以喝多少瓶水
     */
    private static void bottleWater() {
        // 最初的饮料瓶数, 兑换次数
        int jp = 50, trans = 0;
        while (true) {
            jp -= 3;
            jp++;
            trans++;
            if (jp < 3) {
                System.out.println("一共可以喝的酒瓶数量是: " + (50 + trans));
                break;
            }
        }
    }
}
