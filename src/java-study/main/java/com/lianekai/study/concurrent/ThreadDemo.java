package com.lianekai.study.concurrent;

import java.util.concurrent.*;

/**
 * @author lianekai
 * @className ThreadDemo
 * @description 测试线程
 *
 * 创建线程的方式：1 通过继承Thread类创建线程 2 通过Runnable接口创建线程 3 通过Callable 和Future接口创建线程 4 通过线程池创建线程
 *
 *
 * @version: 1.0
 * @date 2022/5/8 1:14
 */
public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread1();
        thread.setName("thread-thread1");
        thread.start(); //调了start()方法，线程就开始执行了 处于就绪状态 等待CPU调度 这里可能会出现阻塞，由main线程先执行完毕，然后才执行线程1

        System.out.println("当前的线程是："+Thread.currentThread().getName());



        Thread thread2 = new Thread(new Runnable1());
        thread2.setName("thread-runnable1");
        thread2.start();

        Callable1 callable1 = new Callable1();
        FutureTask<String> futureTask = new FutureTask<>(callable1);
        Thread thread3=new Thread(futureTask);
        thread3.setName("thread-callable");
        thread3.start();
        System.out.println("futureTask的结果是："+futureTask.get());


        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        FutureTask<String> futureTask2 = new FutureTask<>( () -> {
            System.out.println("线程池中的线程是："+Thread.currentThread().getName());
            return "线程池中的线程执行完毕";
        });
        executorService1.submit(futureTask2);
        System.out.println("futureTask2的结果是："+futureTask2.get());

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        Thread thread4 = threadFactory.newThread(new Runnable1());
        thread4.setName("thread-threadFactory");
        thread4.start();


        ExecutorService executorService2 = Executors.newCachedThreadPool(threadFactory);
        executorService2.submit(new Runnable1());
    }
}
