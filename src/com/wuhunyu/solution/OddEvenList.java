package com.wuhunyu.solution;

import com.wuhunyu.domain.ListNode;

/**
 * 328. 奇偶链表
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 16:26
 */

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);

        ListNode p1 = oddHead;
        ListNode p2 = evenHead;

        int count = 1;
        while (head != null) {
            ListNode tmp = head.next;
            if ((count++ & 1) == 1) {
                p1.next = head;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = head;
                p2 = p2.next;
                p2.next = null;
            }
            head = tmp;
        }
        p1.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();

        oddEvenList.oddEvenList(ListNode.makeupListNode(new Integer[]{1, 2, 3, 4, 5}));
    }


}
