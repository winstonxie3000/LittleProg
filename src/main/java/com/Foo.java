package com;

import com.math.StringCalUtil;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;
import it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList;

public class Foo {

    public static void main(String[] args) throws InterruptedException {

//        ObjectBigArrayBigList list = new ObjectBigArrayBigList();
//        for (int i = 0; i < Integer.MAX_VALUE/2; i++) {
//            if (i%10000==0){
//                System.out.println(i);
//                Thread.sleep(1);
//            }
//            list.add("test");
//        }
//        System.out.println(list.size64());

        System.out.println(Long.MAX_VALUE);
        System.out.println(StringCalUtil.index("2","64"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Math.random() * Long.MAX_VALUE);

//        LongBigArrayBigList list = new LongBigArrayBigList();
//        for (int i = 0; i < Integer.MAX_VALUE/2; i++) {
//            if (i%10000==0){
//                System.out.println(i);
//                Thread.sleep(1);
//            }
//            list.add(1);
//        }
//        System.out.println(list.size64());

    }
}
