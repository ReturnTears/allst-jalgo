package com.allst.jvalgo.util;

/**
 * @author Hutu
 * @since 2025-03-25 下午 08:51
 */
public class AppSkipList {
    public static void main(String[] args) {
        MySkipList list = new MySkipList();
        for (int i = 0; i < 100; i++) {
            list.insert(i);
        }
        System.out.println(list.find(0));
        System.out.println(list.find(1));
        System.out.println(list.find(2));
        System.out.println(list.find(3));
        System.out.println(list.find(4));
        list.delete(0);
        System.out.println("----------------------------------");
        System.out.println(list.find(0));
        list.display();
    }
}
