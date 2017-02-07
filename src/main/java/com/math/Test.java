package com.math;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by winston.xie on 04/11/2016 AD.
 */
public class Test {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        int i = 0;

        System.out.println(Runtime.getRuntime().freeMemory());

        while (i < 2000) {
            executorService.submit(() -> {
                Fibonacci.fibonacci(5000000);
            });
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Got exception...");
                e.printStackTrace();
            }
            System.out.println(i + " threads have been created!!");
        }

//        i = 0;
//        while (i < 10) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                System.out.println("Got exception...");
//                e.printStackTrace();
//            }
//            System.out.println(Runtime.getRuntime().freeMemory());
//            i++;
//            int nbThreads =  Thread.getAllStackTraces().keySet().size();
//            System.out.println("There are "+nbThreads+" threads!");
//        }

    }
}
