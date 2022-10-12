package com.wuhunyu.solution;

import com.wuhunyu.domain.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 8:45
 */

public class NumComponents {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode node = head;
        boolean isContinue = false;
        int count = 0;
        while (node != null) {
            if (set.contains(node.val)) {
                if (!isContinue) {
                    isContinue = true;
                    count++;
                }
            } else {
                isContinue = false;
            }
            node = node.next;
        }
        return count;
    }

}
