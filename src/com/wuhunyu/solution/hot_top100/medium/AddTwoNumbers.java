package com.wuhunyu.solution.hot_top100.medium;

import com.wuhunyu.domain.ListNode;

/**
 * 2. 两数相加
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 20:22
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int num = flag;
            if (l1 != null && l2 != null) {
                num = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            } else {
                num += l2.val;
                l2 = l2.next;
            }
            if (num >= 10) {
                flag = num / 10;
                num %= 10;
            } else {
                flag = 0;
            }
            p.next = new ListNode(num);
            p = p.next;
        }
        if (flag > 0) {
            p.next = new ListNode(flag);
        }
        return head.next;
    }

}
