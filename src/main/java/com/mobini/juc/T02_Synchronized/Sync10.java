package com.mobini.juc.T02_Synchronized;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description: synchronized锁升级
 * @Author: Mobini
 * @Date: 2022-07-01
 */
public class Sync10 {
    // 无锁 -> 偏向锁
    /*public static void main(String[] args) {
        Object o = new Object();
        // 无锁状态
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            // 偏向锁
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }*/

    /**
     * 偏向锁是延迟开启的 默认4秒，为了看到效果, 设置5秒
     * 方式一： Thread.sleep(5000);
     * 方式二： -XX:BiasedLockingStartupDelay=0
     */
    /*public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();
        // 偏向锁 但是没有偏向任何线程
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            // 偏向锁
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }*/

    /**
     * 第一种情况
     * 匿名偏向
     * Main: 101(偏向)
     * T1: 010(重量)
     *
     * 第二种情况
     * 匿名偏向
     * Main: 010(重量)
     * T1: 010(重量)
     */
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        // 匿名偏向
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(() -> {
            synchronized (o) {
                // 1
                System.out.println("T1: " + ClassLayout.parseInstance(o).toPrintable());
                // 2
            }
        }).start();

        synchronized (o) {
            // 3
            System.out.println("Main: " + ClassLayout.parseInstance(o).toPrintable());
            // 4
        }
    }
}
