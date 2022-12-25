package com.wuhunyu.solution.lcof;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/22 10:03
 */

public class TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre;

    private Node head;

    public Node treeToDoublyList(Node node) {
        if (node == null) {
            return null;
        }
        this.dfs(node);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        this.dfs(node.left);
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        this.dfs(node.right);
    }

}
