package com.lianekai.study.multithreading.create;

import java.util.concurrent.Callable;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/10/14 9:44
 **/
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "我的Callable启动了~";
    }
}
