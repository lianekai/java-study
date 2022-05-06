package com.lianekai.study.jvm.loader;

/**
 * 测试查看类的加载顺序
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/26 14:01
 */
public class Test1 {
    /**常量a*/
    public static final int a=123;
    /**类变量b*/
    public static int b=222;
    /**实例变量b*/
    public int c;

    // 用 -XX:+TraceClassLoading 命令跟踪类的加载过程
    public static void main(String[] args) {
        User user = new User();
        user.sayHello();
        System.out.println(b);
    }




}
