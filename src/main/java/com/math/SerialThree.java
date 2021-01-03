package com.math;

/**
 *  任意相邻3个数的和都是3的倍数
 */
public class SerialThree {

    public static int[] list = new int[8]; // just change the array size to XX to calculate XX-HuangHou issue

    public static long cnt = 0;

    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        for (int i = 0; i < list.length; i++) {
            list[i] = 1;
        }
        calculate(0);
        System.out.println("There are "+ cnt + " different cases in total");
        System.out.println("Spent "+(System.currentTimeMillis()-current)+" milli seconds");

    }

    private static void calculate(int i){
        if (i > 0) {
            int[] subList = new int[i];
            for (int k = 0; k < i; k++) {
                subList[k] = list[k];
            }
            if (!isAvailable(subList)) return;
        }
        while (list[i] <= list.length) {
            if (i == list.length -1 ){
                printList();
            }
            if (i < list.length - 1)
                calculate(i + 1);
            if (list[i] == list.length) {
                list[i] = 1;
                return;
            }
            list[i]++;
        }
    }

    private static boolean isAvailable(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == list[list.length-1]) return false;
        }

        for (int i = 0; i < list.length - 2; i++) {
            if ((list[i] + list[i+1] + list[i+2]) % 3 != 0) {
                return false;
            }
        }
        return true;
    }

    private static void printList() {
        if (!isAvailable(list)) return;
        for (int l:list) {
            System.out.print(l+",");
        }
        cnt++;
        System.out.println("  count: " + cnt);
    }
}
