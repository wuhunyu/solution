package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/17 10:16
 */

public class InvertTree {

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = this.invertTree(node.left);
        TreeNode right = this.invertTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();

        invertTree.invertTree(TreeNode.makeupTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
    }

}
