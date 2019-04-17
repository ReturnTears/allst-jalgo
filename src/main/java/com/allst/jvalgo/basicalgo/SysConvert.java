package com.allst.jvalgo.basicalgo;

/**
 * 进制转换
 * @author June 2019/03/01 下午 06:59
 * @version 1.0
 */
public class SysConvert {
    public static void main(String[] args) {
        SysConvert sysConvert = new SysConvert();
        sysConvert.binaryToDecimal3(10);

        binaryToDecimal(10);
    }

    /**
     * 十进制转二进制
     * Method1:除基倒取余法
     * 平时最符合数学逻辑思维的方式：输入一个十进制数n，每次用n除以2，把余数记下来，再用商去除以2...依次循环，直到商为0结束，
     *                          把余数倒着依次排列，就构成了转换后的二进制数。
     *
     * 在实际实现中,可以用int的一个数来存储最后的二进制，每次求余后把余数存储在int型数的低位，依次递增
     * Math.pow(m, n)即等于求m的n次方
     */
    private void binaryToDecimal1(int n) {
        // t记录位数,bin记录最后的二进制,r用来存储余数
        int t = 0, bin = 0, r;
        while (n != 0) {
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10, t);
            t++;
        }
        System.out.println(bin);
    }

    /**
     * 十进制转二进制
     * 对binaryToDecimal1方法的改进
     * int型最大只能表示2^31-1 的正数，所以，存储的二进制数位数有限；我们都知道，int在java中的存储范围是32位，则可以使用字符串的拼接（+）来实现
     * @param n 十进制数
     */
    private static void binaryToDecimal(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n /2;
        }
        System.out.println(str);
    }

    /**
     * 十进制转二进制
     * Method2:利用“移位”操作实现
     * 将最高位的数移至最低位（移31位），除过最低位其余位置清零，使用& 操作，可以使用和1相与（&），由于1在内存中除过最低位是1，
     * 其余31位都是零，然后把这个数按十进制输出；再移次高位，做相同的操作，直到最后一位
     */
    private void binaryToDecimal2(int n) {
        for(int i = 31; i >= 0; i--) {
            System.out.print(n >>> i & 1);
        }
    }

    /**
     * 十进制转二进制
     * Method3:调用API函数
     */
    private void binaryToDecimal3(int n) {
        String result = Integer.toBinaryString(n);
        System.out.println(result);
        System.out.println("res = " + 1/2);
    }

    /**
     * -2
     * 0
     */
    private static void basicChar() {
        System.out.println(Integer.MAX_VALUE * 2);
        System.out.println(Integer.MIN_VALUE * 2);
    }
}
