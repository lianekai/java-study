package com.lianekai.study.multithreading.create;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/10/14 9:37
 **/
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("我的Thread线程启动了~");
    }
}
