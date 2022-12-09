package com.wuhunyu.solution.lcof;

import com.wuhunyu.domain.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/9 22:09
 */

public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        return this.reverse(head, 0);
    }

    private int[] reverse(ListNode node, int depth) {
        if (node == null) {
            return new int[depth];
        }
        int[] arr = reverse(node.next, depth + 1);
        arr[arr.length - depth - 1] = node.val;
        return arr;
    }

}
