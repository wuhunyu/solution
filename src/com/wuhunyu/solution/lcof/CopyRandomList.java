package com.wuhunyu.solution.lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/9 22:32
 */

public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = new Node(-1);
        Node node1 = p;
        Node node2 = head;
        while (node2 != null) {
            Node node = new Node(node2.val);
            node1.next = node;
            node1 = node1.next;
            map.put(node2, node);
            node2 = node2.next;
        }
        node1 = p.next;
        node2 = head;
        while (node2 != null) {
            node1.random = map.get(node2.random);
            node1 = node1.next;
            node2 = node2.next;
        }
        return p.next;
    }

}
