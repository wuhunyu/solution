package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/17 13:42
 */

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return this.dfs(node, 0) - 1;
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return max;
        }
        max = Math.max(this.maxDepth(node.left) + this.maxDepth(node.right) + 1, max);
        return Math.max(this.dfs(node.left, max), this.dfs(node.right, max));
    }

    private int maxDepth(TreeNode node) {
        return node == null ? 0 : Math.max(this.maxDepth(node.left), this.maxDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

        diameterOfBinaryTree.diameterOfBinaryTree(TreeNode.makeupTree(new Integer[]{1, 2, 3, 4, 5}));
    }

}
