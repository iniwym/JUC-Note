package com.mobini.juc;

/**
 * @Description: i++;是原子操作吗
 * @Author: Mobini
 * @Date: 2022-07-01
 */
public class SyncTest01 {

    int i = 0;

    public void increment02() {
        synchronized (this) {
            i++;
        }
    }

    public void increment01() {
        i++;
    }

}
