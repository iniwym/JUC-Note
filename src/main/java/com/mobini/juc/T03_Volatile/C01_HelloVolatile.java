package com.mobini.juc.T03_Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 可见性
 * 在下面的代码中，running是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy,并不会每次都去
 * 读取堆内存，这样，当线程修改running的值之后，t1线程感知不到，所以不会停止运行
 * 使用volatile，将会强制所有线程都会去堆内存中读取running的值
 * @Author: Mobini
 * @Date: 2022-07-01
 */
public class C01_HelloVolatile {
    // 对比一下有无volatile的情况下，整个程序运行结果的区别
    /*volatile*/ boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        C01_HelloVolatile t = new C01_HelloVolatile();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }

}
