package com.mobini.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description: 对象再内存中是如何存储的
 * @Author: Mobini
 * @Date: 2022-07-01
 */
public class SyncTest02 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
