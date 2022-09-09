package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-09 22:42
 */

public class FindBottomLeftValue {

    private int maxDepth;

    private int val;

    public int findBottomLeftValue(TreeNode root) {
        this.dfs(root, 0);
        return val;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            val = node.val;
        }
        this.dfs(node.left, depth + 1);
        this.dfs(node.right, depth + 1);
    }

}
