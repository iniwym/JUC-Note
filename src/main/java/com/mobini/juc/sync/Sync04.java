package com.mobini.juc.sync;

/**
 * @Description: 预测一下输出结果
 * 锁定的必须是同一个对象
 * @Author: Mobini
 * @Date: 2022-06-30
 *
 * THREAD0 count = 9
 * THREAD4 count = 9
 * THREAD3 count = 9
 * THREAD2 count = 9
 * THREAD7 count = 9
 * THREAD1 count = 9
 * THREAD6 count = 9
 * THREAD5 count = 9
 * THREAD8 count = 9
 * THREAD9 count = 9
 */
public class Sync04 implements Runnable {

    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Sync04 t = new Sync04();
            new Thread(t, "THREAD" + i).start();
        }
    }

}

