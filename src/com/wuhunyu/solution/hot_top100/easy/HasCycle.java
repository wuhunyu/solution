package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.ListNode;

/**
 * 141. 环形链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 10:04
 */

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
