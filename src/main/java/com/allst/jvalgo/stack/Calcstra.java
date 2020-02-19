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
        String nifixExp = "1+((2+4)×5÷2)-6";
        List<String> nifixList = nifixExpressions2List(nifixExp);
        System.out.printf("中缀表达式: %s 转换为对于的List: %s\n", nifixExp, nifixList);

        List<String> postfixList = nifixExpList2PostfixExpressions(nifixList);
        System.out.printf("中缀List列表: %s 转换后缀表达式为: %s\n", nifixList, postfixList);

        String suffixExp = "4 5 × 8 - 60 + 8 2 ÷ +";
        // 测试数据转换
        List<String> list = getListString(suffixExp);
        System.out.println(list);

        int result = calculate(postfixList);
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

    /**
     * 将中缀表达式转换为List
     * @param exp   参数
     * @return      结果
     */
    public static List<String> nifixExpressions2List(String exp) {
        List<String> list = new ArrayList<>();
        int i = 0;      // 这是一个指针，用于遍历中缀表达式字符串
        String str;     // 对多位数的拼接
        char c;         // 每遍历一个字符，就放入到c
        do {
            // 如果c是非数字，就加入到list中
            if ((c = exp.charAt(i)) < 48 || (c = exp.charAt(i)) > 57) {
                list.add("" + c);
                i++;    // 后移
            } else {    // 如果是一个数，需考虑多位数
                str = "";
                while (i < exp.length() && (c = exp.charAt(i)) >= 48 && (c = exp.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < exp.length());
        return list;
    }

    /**
     * 计算后缀表达式
     * @param ls    参数
     * @return      结果
     */
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

    /**
     * 将中缀表达式List列表转换为后缀表达式
     * @param nifixList     参数
     * @return              结果
     */
    public static List<String> nifixExpList2PostfixExpressions(List<String> nifixList) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>();       // 符号栈
        List<String> s2 = new ArrayList<>();    // 存储中间结果的栈，因为没有pop操作， 所以使用列表代替， 便于逆序输出
        // 遍历
        for (String item : nifixList) {
            // 是数就添加到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();       // 消除"("
            } else {
                // 当item的优先级小于等于s1的栈顶的优先级，
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }
}

/**
 * 优先级类
 */
class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;
    public static int getValue(String oper) {
        int result = 0;
        switch (oper) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "×":
                result = MUL;
                break;
            case "÷":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}