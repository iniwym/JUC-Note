package com.mobini.juc.T01_Thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程方法
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class C03_ThreadMethod {

    public static void main(String[] args) {
        testSleep();
        testYield();
        testJoin();
    }

    private static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("------------B" + i);
                if (i % 3 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    private static void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

