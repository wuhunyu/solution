package com.wuhunyu.solution.lcof;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * @author gongzhiqiang
 * @date 2022/12/13 22:22
 **/

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return root == null || this.dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && this.dfs(node1.left, node2.right) && this.dfs(node1.right, node2.left);
    }

}
