package com.lianekai.study.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

/**
 * 学生类
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/19 15:24
 */
@Getter
@Setter
@ToString
@Component
public class Student {
    private String name;

    private Student(){}

    public Student(String name){
        this.name=name;
    }

    public void init(){
        System.out.println("Student对象开始实例化了,学生是："+name);
    }

    public void destroy(){
        System.out.println("Student对象执行销毁了");
    }

}
