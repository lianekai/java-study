package com.lianekai.study.concurrent;

/**
 * @author Administrator
 * @className Runnable1
 * @description TODO
 * @version: 1.0
 * @date 2022/5/8 10:14
 */
public class Runnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable1");
        System.out.println("当前的线程是：" + Thread.currentThread().getName());
    }
}
