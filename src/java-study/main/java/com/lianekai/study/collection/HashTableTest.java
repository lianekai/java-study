package com.lianekai.study.collection;

import java.util.Hashtable;

/**
 * HashTableTest
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/03/09 22:29
 */
public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable=new Hashtable<>();
        hashtable.put("key1","value1");
        System.out.println(hashtable.get("key1"));
    }
}
