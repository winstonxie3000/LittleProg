package com.math;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrimeNumberUtilTest {

    @Test
    public void generate() {
        PrimeNumberUtil.generate();
    }

    @Test
    public void test() throws IOException{
//        String str = "3\n5\n7\n11\n13\17";
//        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
//        writer.write(str);
//
//        writer.close();
//        String str = "Hello";
        String fileName = "test2.txt";
//
//        Path path = Paths.get(fileName);
//        byte[] strToBytes = str.getBytes();
//
//        Files.write(path, strToBytes);

//        RandomAccessFile stream = new RandomAccessFile(fileName, "rw");
        FileOutputStream stream = new FileOutputStream(fileName, true);

        FileChannel channel = stream.getChannel();
        String value = "Hello\nWorld\n";
        byte[] strBytes = value.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();
    }
}