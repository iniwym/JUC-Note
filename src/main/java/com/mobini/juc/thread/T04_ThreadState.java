package com.mobini.juc.thread;

/**
 * @Description: 线程状态
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class T04_ThreadState {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            // `RUNNABLE`的状态
            System.out.println(this.getState());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        // 当我们new一个线程时, 还没有调用start()该线程处于新建状态 `NEW`的状态
        Thread t = new MyThread();
        System.out.println(t.getState());
        // 到这start()完了之后呢是`RUNNABLE`的状态
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 然后join()之后，结束了是一个`TERMINATED`状态
        System.out.println(t.getState());
    }
}
