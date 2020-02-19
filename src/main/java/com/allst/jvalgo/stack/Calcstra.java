package com.allst.jvalgo.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 * 后缀表达式
 * @author YiYa
 * @since 2020-02-19 下午 10:38
 */
public class Calcstra {

    public static void main(String[] args) {
        // 逆波兰表达式 (3+4)×5-6 => 先需要计算的额两个值放在一块，符号跟在数后面
        String suffixExp = "4 5 × 8 - 60 + 8 2 ÷ +";
        // 测试数据转换
        List<String> list = getListString(suffixExp);
        System.out.println(list);
        int result = calculate(list);
        System.out.println("计算结果为: " + result);
    }

    /**
     * 将一个逆波兰表达式依次将将数据和运算符放入到ArrayList中
     * @param exp   逆波兰表达式
     * @return      结果
     */
    public static List<String> getListString(String exp) {
        String[] res = exp.split(" ");
        return new ArrayList<>(Arrays.asList(res));
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(item);   // 入栈
            } else {
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)) {
                    res = n1 + n2;
                } else if ("-".equals(item)) {
                    res = n2 -n1;
                } else if ("×".equals(item)) {
                    res = n1 * n2;
                } else if ("÷".equals(item)) {
                    res = n2 / n1;
                } else {
                    throw new RuntimeException("运算符有误~~~");
                }
                // 结果入栈
                stack.push("" + res);
            }
        }
        // 最终结果
        return Integer.parseInt(stack.pop());
    }
}
