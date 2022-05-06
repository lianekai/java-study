package com.lianekai.study.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * Person
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/19 15:24
 */
@Getter
@Setter
@Component
public class Person implements DisposableBean {

    private final String name="lianekai" ;

    private String age;

    private Student student;

    public void echo(){
        System.out.println("Person类中的输出方法"+student);
    }

    public void initMethod(){
        System.out.println("初始化bean..initMethod");
    }

    public void destroyMethod(){
        System.out.println("销毁bean..destroyMethod");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行销毁bean");
    }
}
