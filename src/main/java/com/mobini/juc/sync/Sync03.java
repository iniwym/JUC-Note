package com.mobini.juc.sync;

/**
 * @Description: synchronized使用
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class Sync03 implements Runnable {

    private /*volatile*/ int count = 100;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        Sync03 t = new Sync03();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

}
