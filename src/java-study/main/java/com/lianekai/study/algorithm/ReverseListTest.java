package com.lianekai.study.algorithm;

/**
 * @author lianyikai
 * @className ReverseListTest
 * @description 翻转链表
 * @version: 1.0
 * @date 2022/5/6 13:52
 */
public class ReverseListTest {
     static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        while(head != null) {
            System.out.println(head.val);

            head = head.next;
        }
    }

}
