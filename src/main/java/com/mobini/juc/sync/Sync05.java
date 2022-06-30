package com.mobini.juc.sync;

/**
 * @Description: 同步方法和非同步方法是否可以同时调用
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class Sync05 {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        Sync05 t = new Sync05();

        // 1.8之前的写法
        /*new Thread(new Runnable() {

            @Override
            public void run() {
                t.m1();
            }

        });*/

        // Lambda表达式方式1
        /*new Thread(() -> t.m1(), "t1").start();
        new Thread(() -> t.m2(), "t2").start();*/

        // Lambda表达式方式2
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();

    }

}

