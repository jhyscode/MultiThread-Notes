package com.multithread.ch03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：jhys
 * @date ：Created in 2020/6/21 15:25
 * @Description ：
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread id:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            MyTask task = new MyTask();
            ExecutorService es = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 10; i++) {
                es.submit(task);
            }
        }

    }
}
