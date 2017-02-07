package com.math;

/**
 * Created by winston.xie on 27/10/2016 AD.
 */
public class Fibonacci {

    public static void main(String[] args) {

        fibonacci(2000);
    }

    public static void fibonacci(int len) {


        String a1 = "1";
        String a2 = "2";
        String a3;

        String tt = "";
        for (int i = 0; i < len; i++) {
            String test = new String("just to occupy the memory");
            tt = tt + test;
        }

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                a3 = "1";
            } else if (i == 1) {
                a3 = "2";
            } else {
                a3 = StringCalUtil.plus(a1, a2);
                a1 = a2;
                a2 = a3;
            }
            System.out.println("第" + (i + 1) + "个数是： " + a3);
        }
    }
}
