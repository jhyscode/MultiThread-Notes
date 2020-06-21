package com.multithread.ch02;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author ：jhys
 * @date ：Created in 2020/6/5 19:22
 * @Description ：
 */
public class ArrayListMultiThread {
    static Vector<Integer> vector = new Vector<>(10);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                vector.add(i);
            }
        }
    }

    /**
     * ArrayList是一个线程不安全的容器,多线程操作时会出现冲突
     * Vector是一个线程安全的容器,可以代替ArrayList
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(vector.size());
    }

}

