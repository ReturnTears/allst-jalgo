package com.allst.jvalgo.stack;

import java.util.Scanner;

/**
 * 使用数组模拟栈
 *
 * @author YiYa
 * @since 2020-02-19 下午 05:26
 */
public class ArrayStack {

    public static void main(String[] args) {
        // 测试
        ArrayS as = new ArrayS(5);
        String key = "";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 表示退出栈");
            System.out.println("push: 表示添加数据到栈");
            System.out.println("pop: 表示从栈中取出数据");
            System.out.println("请输入~~~");
            key = scanner.next();
            switch (key) {
                case "show":
                    as.list();
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                case "push":
                    System.out.println("请输入一个数字~~~");
                    int value = scanner.nextInt();
                    as.push(value);
                    break;
                case "pop":
                    try {
                        int val = as.pop();
                        System.out.printf("出栈的数据为:%d\n", val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }

}

// 模拟栈结构栈
class ArrayS {
    private int maxSIze;    // 数组最大值
    private int top = -1;   // 表示栈顶,默认初始值-1
    private int[] arr;      // 数组，存储数据用

    // 构造器
    public ArrayS(int maxSIze) {
        this.maxSIze = maxSIze;
        arr = new int[this.maxSIze];
    }

    // 模拟栈
    // 栈满
    public boolean isFull() {
        return top == maxSIze - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈push
    public void push(int value) {
        if (isFull()) {
            //throw new RuntimeException("栈空间满了，不能添加数据~~~\n");
            System.out.println("栈空间满了，不能添加数据~~~");
            return;
        }
        top++;
        arr[top] = value;
    }

    // 出栈pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空间为空，没有任何数据~~~\n");
        }
        int value = arr[top];
        top--;
        return value;
    }

    // 遍历栈，从栈顶开始
    public void list() {
        if (isEmpty()) {
            //throw new RuntimeException("栈空间为空，没有任何数据可便利~~~\n");
            System.out.println("栈空间为空，没有任何数据可便利~~~");
            return;
        }
        // for循环遍历数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈空间的数据为: arr[%d] = %d\n", i, arr[i]);
        }
    }

}