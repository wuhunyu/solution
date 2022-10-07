package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 16:10
 */

public class DiameterOfBinaryTree {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lNum = this.dfs(node.left);
        int rNum = this.dfs(node.right);
        max = Math.max(max, lNum + rNum);
        return Math.max(lNum, rNum) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(TreeNode.makeupTree(new Integer[]{1, 2, 3, 4, 5})));
    }

}
