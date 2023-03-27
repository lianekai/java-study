package com.lianekai.study.multithreading.create;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/10/14 9:43
 **/
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("我的Runnable线程启动了~");
    }
}
