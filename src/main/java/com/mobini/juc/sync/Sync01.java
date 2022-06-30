package com.mobini.juc.sync;

/**
 * @Description: synchronized使用
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class Sync01 {
    private int count = 10;
    private Object o = new Object();

    public void m1() {
        // 任何线程要想执行下面的代码，必须先拿到o的锁
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public void m2() {
        // 任何线程想要执行那个下面的代码，必须先要拿到this的锁
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    // 等同于在方法的代码执行时要synchronized(this)
    public synchronized void m3() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

}
