package com.lianekai.study.callback;

import lombok.Getter;
import lombok.Setter;

/**
 * 同步调用
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/18 23:04
 */
@Getter
@Setter
public class Teacher {
    private String name;

    void askQuestion(){
        System.out.println(name+"问问题");
    }
}
