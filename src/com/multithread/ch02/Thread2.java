package com.multithread.ch02;

/**
 * @author ：jhys
 * @date ：Created in 2020/6/5 15:30
 * @Description ：run（）方法是多线程程序的一个约定。所有的多线程代码都在run方法里面。
 * Thread类实际上也是实现了Runnable接口的类。
 */
public class Thread2 implements Runnable{
    private String name;

    public Thread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println(name + "运行:  " + i);
            try{
                Thread.sleep((int) Math.random() * 100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Thread2("C"));
        t1.start();
        t1.join();
        new Thread(new Thread2("D")).start();

    }
}
