package com.lianekai.study.generic;

import java.lang.reflect.Field;

/**
 * @author lianekai
 * @date 2022/11/27 14:27
 * @version: 1.0
 * @description 泛型测试
 */
@SuppressWarnings("all")
public class GenericTest {

    public static void main(String[] args) {
        Class<Demo> demoClass=Demo.class;
        Field[] declaredFields=demoClass.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field.getName()+":"+field.getType());
        }
    }

}

class Demo<T>{
    T t;
    Integer i;
}

class Demo2<T extends Number>{
    T t;
    Integer i;
}