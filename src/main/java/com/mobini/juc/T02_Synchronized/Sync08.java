package com.mobini.juc.T02_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 父子验证可重入
 * 子类调用父类的同步方法
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class Sync08 {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Child().m();
    }

}

class Child extends Sync08 {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
