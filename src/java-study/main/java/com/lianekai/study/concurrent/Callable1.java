package com.lianekai.study.concurrent;

import java.util.concurrent.Callable;

/**
 * @author Administrator
 * @className Callable1
 * @description 用于测试Callable接口的实现类
 * @version: 1.0
 * @date 2022/5/8 10:25
 */
public class Callable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0;i<10;i++){
            System.out.println("i="+i);
        }
        System.out.println("当前的线程名称："+Thread.currentThread().getName());
        return "hello 任务执行完毕";
    }
}
