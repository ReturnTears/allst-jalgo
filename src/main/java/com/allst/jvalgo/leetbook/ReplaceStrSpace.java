package com.allst.jvalgo.leetbook;

/**
 * 替换空格
 * 字符串都被设计成「不可变」的类型，即无法直接修改字符串的某一位字符，需要新建一个字符串实现。
 * <p>
 * 算法流程：
 * 初始化一个 list (Python) / StringBuilder (Java) ，记为 res ；
 * 遍历列表 s 中的每个字符 c ：
 * 当 c 为空格时：向 res 后添加字符串 "%20" ；
 * 当 c 不为空格时：向 res 后添加字符 c ；
 * 将列表 res 转化为字符串并返回。
 * 复杂度分析：
 * 时间复杂度 O(N)O(N) ： 遍历使用 O(N)O(N) ，每轮添加（修改）字符操作使用 O(1)O(1) ；
 * 空间复杂度 O(N)O(N) ： Python 新建的 list 和 Java 新建的 StringBuilder 都使用了线性大小的额外空间。
 *
 * @author June
 * @since 2021年08月
 */
public class ReplaceStrSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));

        String str = "Hello World, 你好 世界!";
        System.out.println(replaceSpace2(str));
    }

    /**
     * 自定义函数
     */
    protected static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    /**
     * 使用Java api
     */
    protected static String replaceSpace2(String s) {
        return s.replaceAll("\\s+", "%20");
    }
}
