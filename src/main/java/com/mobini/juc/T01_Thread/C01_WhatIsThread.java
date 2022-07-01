package com.mobini.juc.T01_Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 什么是线程
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class C01_WhatIsThread {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    /**
     * run()
     * 串行执行, T1打印完成后, Main再打印
     */
    @Test
    public void Test01() {
        new MyThread().run();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main");
        }
    }

    /**
     * start()
     * 并行执行, T1和 Main交替打印
     */
    @Test
    public void Test02() {
        new MyThread().start();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main");
        }
    }
}
