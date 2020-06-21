package com.multithread.ch01;

/**
 * @author ：jhys
 * @date ：Created in 2020/6/5 15:21
 * @Description ：
 */
public class RunnableSample implements Runnable {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableSample());
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Oh , I am Runale");
    }
}

