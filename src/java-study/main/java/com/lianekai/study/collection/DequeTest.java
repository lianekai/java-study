package com.lianekai.study.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DequeTest
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/03/27 15:52
 */
@Slf4j
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> codeDeque = new ArrayDeque<>();
        for(int i=0;i<=5;i++){
            codeDeque.addFirst(i+"");
            log.info(codeDeque.toString());
        }

        for(int i=0;i<=10;i++){
            String code=codeDeque.pollFirst();
            log.info("现在的code是："+code);
        }

    }
}
