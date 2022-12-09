package com.wuhunyu.solution.lcof;

import com.wuhunyu.domain.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/9 22:19
 */

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(-1);
        ListNode node = head;
        while (node != null) {
            ListNode tmp = p.next;
            p.next = node;
            node = node.next;
            p.next.next = tmp;
        }
        return p.next;
    }

}
