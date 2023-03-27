package com.lianekai.study.multithreading.create;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.thread.RejectPolicy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/10/14 9:53
 **/
public class MyTreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(4,8,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(20),new NamedThreadFactory("pre",Boolean.FALSE), RejectPolicy.ABORT.getValue());

        threadPoolExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("我是线程池启动的线程");
        } );
        //关闭线程池
        threadPoolExecutor.shutdown();
    }
}
