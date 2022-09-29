package com.wuhunyu.solution;

import com.wuhunyu.domain.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. 两数相加 II
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-29 9:17
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        ListNode p1 = l1;
        while (p1 != null) {
            stack1.push(p1.val);
            p1 = p1.next;
        }
        ListNode p2 = l2;
        while (p2 != null) {
            stack2.push(p2.val);
            p2 = p2.next;
        }
        int flag = 0;
        ListNode head = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + flag;
            flag = sum / 10;
            sum %= 10;
            ListNode tmpNode = head.next;
            head.next = new ListNode(sum % 10);
            head.next.next = tmpNode;
        }
        if (flag != 0) {
            ListNode tmpNode = head.next;
            head.next = new ListNode(flag);
            head.next.next = tmpNode;
        }
        return head.next;
    }

}
