package com.wuhunyu.solution;


import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 669. 修剪二叉搜索树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-10 7:50
 */

public class TrimBST {

    public TreeNode trimBST(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }
        if (node.val < low) {
            return this.trimBST(node.right, low, high);
        } else if (node.val > high) {
            return this.trimBST(node.left, low, high);
        } else {
            node.left = this.trimBST(node.left, low, high);
            node.right = this.trimBST(node.right, low, high);
            return node;
        }
    }

}
