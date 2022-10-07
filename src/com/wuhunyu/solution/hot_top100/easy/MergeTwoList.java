package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 9:01
 */

public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list1.next = this.mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = this.mergeTwoLists(list1, list2.next);
                return list2;
            }
        } else if (list1 != null) {
            return list1;
        }
        return list2;
    }

}
