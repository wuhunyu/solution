package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.ListNode;

/**
 * 234. 回文链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 12:42
 */

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        if (fast != null) {
            mid = mid.next;
        }
        ListNode p = new ListNode(-1);
        ListNode node = head;
        while (node != slow) {
            ListNode next = p.next;
            p.next = node;
            node = node.next;
            p.next.next = next;
        }
        ListNode first = p.next;
        while (mid != null) {
            if (first.val != mid.val) {
                return false;
            }
            first = first.next;
            mid = mid.next;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        System.out.println(isPalindrome.isPalindrome(ListNode.makeupListNode(new Integer[]{1, 2, 2, 1})));
        System.out.println(isPalindrome.isPalindrome(ListNode.makeupListNode(new Integer[]{1, 2, 3, 2, 1})));
    }

}
