package com.allst.jvalgo.demo;

/**
 * @author YiYa
 * @since 2020-02-16 下午 04:51
 */
public class Question1 {

    public static void main(String[] args) {
        String str = "Java,Java,Hello,World";
        String newStr = str.replaceAll("Java", "Data~");
        System.out.println("newStr = " + newStr);
    }

}
