package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 617. 合并二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 16:11
 */

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = this.mergeTrees(root1.left, root2.left);
        node.right = this.mergeTrees(root1.right, root2.right);
        return node;
    }

}
