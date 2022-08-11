package com.wuhunyu.solution;

import com.wuhunyu.domain.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/11 17:13
 */

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(-1, head);
        ListNode fast = p;
        ListNode slow = p;
        while (n-- >= 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return p.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();

        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.makeupListNode(new Integer[]{1, 2, 3, 4, 5}), 2));
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.makeupListNode(new Integer[]{1}), 1));
    }

}
