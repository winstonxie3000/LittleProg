package com.math;

public class Bahuanghou {

    public static int[] list = new int[18]; // just change the array size to XX to calculate XX-HuangHou issue

    public static long cnt = 0;

    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        for (int i = 0; i < list.length; i++) {
            list[i] = 0;
        }
        calculate(0);
        System.out.println("There are "+ cnt + " different cases in total");
        System.out.println("Spent "+(System.currentTimeMillis()-current)+" milli seconds");
    }

    private static void calculate(int i){
        if (i < list.length - 1) {
            if (i > 0) {
                int[] subList = new int[i];
                for (int k = 0; k < i; k++) {
                    subList[k] = list[k];
                }
                if (!isAvailable(subList)) return;
            }
            while (list[i] < list.length) {
                calculate(i + 1);
                list[i]++;
                if (list[i] == list.length) {
                    list[i] = 0;
                    return;
                }
            }
        } else {
            while (list[i] < list.length) {
                printList();
                list[i]++;
                if (list[i] == list.length) {
                    list[i] = 0;
                    return;
                }
            }
        }
    }

    private static boolean isAvailable(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j]) return false;
                if ((j-i) == Math.abs(list[j]-list[i])) return false;
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
