package com.mobini.juc.T02_Synchronized;

/**
 * @Description: 锁膨胀
 * @Author: Mobini
 * @Date: 2022-07-02
 */
public class Sync12 {
    static int j = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 99999; i++) {
            synchronized (Sync12.class) {
                j += i;
            }
        }
    }

    // 类似于
    /*public static void main(String[] args) {
        synchronized (Sync12.class) {
            for (int i = 0; i < 99999; i++) {
                j += i;
            }
        }
    }*/
}
