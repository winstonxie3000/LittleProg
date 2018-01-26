package com.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberUtil {

    private static List<String> primeNumbers = new ArrayList<>();

    public static List<String> generate(int num) {

        primeNumbers.add("3");
        int number = 0;
        String primeNumber;
        boolean isPrimeNumber;

        primeNumber = primeNumbers.get(primeNumbers.size()-1);
        while (number < num) {
            isPrimeNumber = true;
            primeNumber = StringCalUtil.plus(primeNumber, "2");
            for (int i = 0; isPrimeNumber && i < primeNumbers.size(); i++) {
                boolean isExactDivide = StringCalUtil.isExactDivide(primeNumber, primeNumbers.get(i));
                if (isExactDivide) {
                    isPrimeNumber = false;
                }
            }
            if (isPrimeNumber) {
                primeNumbers.add(primeNumber);
                System.out.println(primeNumber);
                number++;
            }
        }
        return null;
    }

    public static void test() {
        String t = "199";
        int i = 0;
        while (i < 100) {
            t = StringCalUtil.plus(t, "2");
            System.out.println(t);
            i++;
        }
    }
}
