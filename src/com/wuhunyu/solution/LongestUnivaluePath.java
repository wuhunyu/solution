package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 687. 最长同值路径
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-02 8:21
 */

public class LongestUnivaluePath {

    private int max;

    public int longestUnivaluePath(TreeNode root) {
        this.dfs(root);
        return max;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        max = Math.max(max, this.maxDept(node.left, node.val) + this.maxDept(node.right, node.val));
        if (node.left != null) {
            this.dfs(node.left);
        }
        if (node.right != null) {
            this.dfs(node.right);
        }
    }

    private int maxDept(TreeNode node, int curVal) {
        if (node == null || node.val != curVal) {
            return 0;
        }
        return Math.max(this.maxDept(node.left, curVal), this.maxDept(node.right, curVal)) + 1;
    }

    public static void main(String[] args) {
        // [1,null,1,1,1,1,1,1]
        TreeNode treeNode = TreeNode.makeupTree(new Integer[]{1, null, 1, 1, 1, 1, 1, 1});
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();

        System.out.println(longestUnivaluePath.maxDept(treeNode, 1));
        System.out.println(longestUnivaluePath.longestUnivaluePath(treeNode));
    }

}
