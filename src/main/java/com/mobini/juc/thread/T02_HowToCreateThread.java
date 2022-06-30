package com.mobini.juc.thread;

/**
 * @Description: 如何创建一个线程
 * @Author: Mobini
 * @Date: 2022-06-30
 */
public class T02_HowToCreateThread {
    /**
     * 继承Thread类
     */
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello Thread!");
        }
    }

    /**
     * 实现Runnable接口
     */
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRunnable!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        /**
         * 使用Lambda表达式
         */
        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start();

    }

}
