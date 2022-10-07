package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 10:03
 */

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }

}
