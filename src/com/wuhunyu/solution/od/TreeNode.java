package com.wuhunyu.solution.od;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 华为笔试
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 15:15
 */

public class TreeNode {

    private int val;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public static TreeNode makeupTree(int[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        int len = nodes.length;
        while (index < len) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (nodes[index] != -1) {
                    node.left = new TreeNode(nodes[index]);
                    queue.offer(node.left);
                }
                index++;
                if (nodes[index] != -1) {
                    node.right = new TreeNode(nodes[index]);
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }

}
