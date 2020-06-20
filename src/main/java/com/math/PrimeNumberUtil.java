package com.math;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumberUtil {

    private static List<String> primeNumbers = new ArrayList<>();
    private static String fileName = "primeNumberFile";

    public static void generate() {

        primeNumbers.add("3");
        int number = 0;
        String primeNumber, upperlimit;
        boolean isPrimeNumber;
        String primeNumberBuffer = "3\n";

        primeNumber = primeNumbers.get(primeNumbers.size()-1);
        while (true) {
            isPrimeNumber = true;
            primeNumber = StringCalUtil.plus(primeNumber, "2");
            for (int i = 0; isPrimeNumber && i < primeNumbers.size(); i++) {
                boolean isExactDivide = StringCalUtil.isExactDivide(primeNumber, primeNumbers.get(i));
                if (isExactDivide) {
                    isPrimeNumber = false;
                } else {
                    upperlimit = StringCalUtil.getQuotient(primeNumber, primeNumbers.get(i)) + 1;
                    if (StringCalUtil.lessThan(upperlimit, primeNumbers.get(i))) {
                        isPrimeNumber = true;
                        break;
                    }
                }
            }
            if (isPrimeNumber) {
                primeNumbers.add(primeNumber);
                primeNumberBuffer+=primeNumber+"\n";
                System.out.println(number+":"+primeNumber);
                number++;
                if (number%1000 == 0) {
                    try {
                        FileOutputStream stream = new FileOutputStream(fileName+"_"+number/1000000+".txt", true);
                        FileChannel channel = stream.getChannel();
                        byte[] strBytes = primeNumberBuffer.getBytes();
                        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                        buffer.put(strBytes);
                        buffer.flip();
                        channel.write(buffer);
                        stream.close();
                        channel.close();
                        primeNumberBuffer = "";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void test() {
        String primeNumberBuffer = "test\n";
        String primeNumber = "Hello";
        primeNumberBuffer+=primeNumber+"\nWorld";
        System.out.println(primeNumberBuffer);
    }

    public static void main(String[] args) {
        String primeNumberBuffer = "test\n";
        String primeNumber = "Hello";
        primeNumberBuffer+=primeNumber+"\nWorld";
        System.out.println(primeNumberBuffer);
        System.out.println(17/123);

    }
}
