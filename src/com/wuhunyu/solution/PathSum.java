package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/18 10:12
 */

public class PathSum {

    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.dfs(root, targetSum);
        return count;
    }

    private void dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        this.singlePathSum(node, 0L, targetSum);
        this.dfs(node.left, targetSum);
        this.dfs(node.right, targetSum);
    }

    private void singlePathSum(TreeNode node, long sum, int targetSum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == targetSum) {
            count++;
        }
        if (node.left != null) {
            this.singlePathSum(node.left, sum, targetSum);
        }
        if (node.right != null) {
            this.singlePathSum(node.right, sum, targetSum);
        }
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        System.out.println(pathSum.pathSum(TreeNode.makeupTree(new Integer[]{1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000}), 0));
    }

}
