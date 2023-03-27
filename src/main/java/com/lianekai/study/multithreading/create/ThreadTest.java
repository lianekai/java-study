package com.lianekai.study.multithreading.create;

import java.util.concurrent.FutureTask;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/10/14 9:45
 **/
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        Thread thread1=new MyThread();
        thread1.start();

        MyRunnable runnable1=new MyRunnable();
        Thread thread2=new Thread(runnable1);
        thread2.start();

        MyCallable callable1=new MyCallable();
        FutureTask futureTask1=new FutureTask(callable1);
        Thread thread3=new Thread(futureTask1);
        thread3.start();
        System.out.println("callable返回的结果"+futureTask1.get());

    }
}
