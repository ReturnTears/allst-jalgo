package com.allst.jvalgo.util;

/**
 * 即使在代码中并没有使用synchronized之类的关键字和锁，仍然可以保证数据的安全性，这便是CAS算法的初衷.
 *
 * @author Hutu
 * @since 2025-03-25 下午 08:42
 */
public class MyCAS {
    public static void main(String[] args) {
        MyCAS myCAS = new MyCAS();
        boolean flag = myCAS.setValue(0, 1);
        System.out.printf("flag:%s , value: %s%n", flag, myCAS.getValue());
    }

    private int value;

    public int getValue() {
        return value;
    }

    public boolean setValue(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return this.value == expectedValue;
    }
}
