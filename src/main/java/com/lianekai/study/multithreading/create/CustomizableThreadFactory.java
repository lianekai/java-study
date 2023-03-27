package com.lianekai.study.multithreading.create;

import java.util.concurrent.ThreadFactory;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/10/14 10:02
 **/
public class CustomizableThreadFactory implements ThreadFactory {

    public CustomizableThreadFactory(String myThreadFactoryName){

    }

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
