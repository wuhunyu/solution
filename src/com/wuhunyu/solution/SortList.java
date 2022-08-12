package com.wuhunyu.solution;

import com.wuhunyu.domain.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 148. 排序链表
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 8:52
 */

public class SortList {

    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        nodes.sort(Comparator.comparingInt(listNode -> listNode.val));
        ListNode p = new ListNode(-1);
        node = p;
        for (ListNode listNode : nodes) {
            node.next = listNode;
            node = node.next;
            node.next = null;
        }
        return p.next;
    }

}
