package com.mobini.juc.sync;

/**
 * @Description: synchronized使用
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class Sync02 {
    private static int count = 10;

    // 这里等同于synchronized(Sync02.class)
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        // 考虑一下这里写synchronized(this)是否可以？ 可以
        synchronized (Sync02.class) {
            count--;
        }
    }
}
