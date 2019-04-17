package com.allst.jvalgo.basicalgo;

/**
 * Variate：变量
 * 静态变量的调用顺序是依次调用
 * @author June 2019/03/02 下午 05:53
 * @version 1.0
 */
public class Variate {

    /**
     * 静态变量也称为类变量
     */
    final static Variate VARIATE = new Variate(5.0);
    static double start = 20.0;
    /**
     * 实例变量
     */
    double end;
    public Variate(double v) {
        end = start - v;
    }

    /**
     * start变量为非静态的时候
     * -5.0
     * 15.0
     * start变量为静态的时候
     * 15.0
     * 15.0
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Variate.VARIATE.end);
        Variate vari = new Variate(5.0);
        System.out.println(vari.end);
    }
}
