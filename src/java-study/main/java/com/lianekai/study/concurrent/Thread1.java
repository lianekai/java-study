package com.lianekai.study.concurrent;

/**
 * @author Administrator
 * @className Thread1
 * @description TODO
 * @version: 1.0
 * @date 2022/5/8 1:21
 */
public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1 run");
        System.out.println("当前的线程是："+Thread.currentThread().getName());
    }
}
