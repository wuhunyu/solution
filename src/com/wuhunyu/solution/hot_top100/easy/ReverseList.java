package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.ListNode;

/**
 * 206. 反转链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 12:41
 */

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(-1);
        while (head != null) {
            ListNode next = p.next;
            p.next = head;
            head = head.next;
            p.next.next = next;
        }
        return p.next;
    }

}
