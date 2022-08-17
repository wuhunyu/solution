package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 110. 平衡二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/17 11:16
 */

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (Math.abs(this.maxDepth(node.left, 0) - this.maxDepth(node.right, 0)) > 1) {
                return false;
            }
        }
        return true;
    }

    private int maxDepth(TreeNode node, int depth) {
        return node == null ?
                depth : Math.max(this.maxDepth(node.left, depth + 1), this.maxDepth(node.right, depth + 1));
    }

}
