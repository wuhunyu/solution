package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/17 11:16
 */

public class IsBalanced {

    public boolean isBalanced(TreeNode node) {
        return node == null || (Math.abs(this.maxDepth(node.left) - this.maxDepth(node.right)) <= 1) &&
                this.isBalanced(node.left) && this.isBalanced(node.right);
    }

    private int maxDepth(TreeNode node) {
        return node == null ? 0 : Math.max(this.maxDepth(node.left), this.maxDepth(node.right)) + 1;
    }

}
