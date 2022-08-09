package com.wuhunyu.domain;

/**
 * 单向链表
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 16:28
 */

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode makeupListNode(Integer[] nodes) {
        int len = 0;
        if (nodes == null || (len = nodes.length) == 0) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < len; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
        }
        return head.next;
    }

}
