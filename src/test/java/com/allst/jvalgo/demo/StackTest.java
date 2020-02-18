package com.allst.jvalgo.demo;

import org.junit.Test;

import java.util.Stack;

/**
 * 栈的基本使用Test
 * @author YiYa
 * @since 2020-02-18 下午 06:03
 */
public class StackTest {

    @Test
    public void stack_test() {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("Java");
        stack.add("JavaScript");
        stack.add("Scala");
        stack.add("BigData");
        stack.add("Haskell");
        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}
