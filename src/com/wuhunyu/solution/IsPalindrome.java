package com.wuhunyu.solution;

import com.wuhunyu.domain.ListNode;

/**
 * 234. 回文链表
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/11 17:30
 */

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode p = new ListNode(-1);
        ListNode node = p;
        while (slow != null) {
            ListNode tmp = node.next;
            node.next = slow;
            slow = slow.next;
            node.next.next = tmp;
        }
        ListNode node1 = p.next;
        ListNode node2 = head;
        while (node1 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        System.out.println(isPalindrome.isPalindrome(ListNode.makeupListNode(new Integer[]{1, 2, 2, 1})));
        System.out.println(isPalindrome.isPalindrome(ListNode.makeupListNode(new Integer[]{1, 2})));
        System.out.println(isPalindrome.isPalindrome(ListNode.makeupListNode(new Integer[]{1, 2, 1})));
        System.out.println(isPalindrome.isPalindrome(ListNode.makeupListNode(new Integer[]{1, 2, 3})));
    }

}
