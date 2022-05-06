package com.lianekai.study.concurrent;

/**
 * synchronize 同步锁
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/03/10 22:53
 */
public class SynchronizedDemo implements Runnable{

    private static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
    }

    /**主函数执行方法*/
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }
}
