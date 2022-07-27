package com.wuhunyu.domain.tree_node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/18 12:05
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 数组 -> 二叉树
     *
     * @param trees 二叉树数组
     * @return 二叉树根节点
     */
    public static TreeNode makeupTree(Integer[] trees) {
        int length = 0;
        if (trees == null || (length = trees.length) == 0) {
            return null;
        }
        TreeNode root = new TreeNode(trees[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int index = 1;
        while (index < length) {
            TreeNode node = deque.poll();
            TreeNode left = trees[index] == null ? null : new TreeNode(trees[index]);
            index++;
            TreeNode right = (index >= length || trees[index] == null) ? null : new TreeNode(trees[index]);
            index++;
            if (left != null) {
                node.left = left;
                deque.offer(left);
            }
            if (right != null) {
                node.right = right;
                deque.offer(right);
            }
        }
        return root;
    }

}
