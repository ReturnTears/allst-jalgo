package com.allst.jvalgo.algorithm.algo;

import java.util.Stack;

/**
 * 栈:栈（stack）是一种遵循先入后出逻辑的线性数据结构
 */
public class AppStack {
    public static void main(String... args) {
        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();

        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        /* 访问栈顶元素 */
        int peek = stack.peek();
        System.out.println("peek:" + peek);

        /* 元素出栈 */
        int pop = stack.pop();
        System.out.println("pop:" + pop);

        /* 获取栈的长度 */
        int size = stack.size();
        System.out.println("size:" + size);

        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();
        System.out.println("isEmpty:" + isEmpty);

        /* 测试 基于链表的实现 */
        LinkedListStack listStack = new LinkedListStack();
        listStack.push(1);
        listStack.push(3);
        listStack.push(2);
        listStack.push(4);
        listStack.push(5);
        int peek1 = listStack.peek();
        System.out.println("peek1 : " + peek1);

        /* 测试 基于数组的实现 */
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(2);
        arrayStack.push(4);
        arrayStack.push(5);
        int peek2 = arrayStack.peek();
        System.out.println("peek2 : " + peek2);
    }
}
