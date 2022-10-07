package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.ListNode;

/**
 * 160. 相交链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 12:41
 */

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a == null) {
                a = headB;
            } else if (b == null) {
                b = headA;
            }
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

}
