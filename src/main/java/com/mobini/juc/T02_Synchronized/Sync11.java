package com.mobini.juc.T02_Synchronized;

/**
 * @Description: 锁消除
 * @Author: Mobini
 * @Date: 2022-07-02
 */
public class Sync11 {
    public static void main(String[] args) {
        synchronized (Sync11.class) {
            int i = 1;
            i++;
            System.out.println(i);
        }
    }

    // 等价于
    /*public static void main(String[] args) {
        int i = 1;
        i++;
        System.out.println(i);
    }*/
}
