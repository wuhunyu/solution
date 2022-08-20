package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 654. 最大二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/20 8:31
 */

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this.dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int[] maxArr = this.max(nums, left, right);
        TreeNode node = new TreeNode(maxArr[0]);
        node.left = this.dfs(nums, left, maxArr[1] - 1);
        node.right = this.dfs(nums, maxArr[1] + 1, right);
        return node;
    }

    private int[] max(int[] nums, int left, int right) {
        int max = -1;
        int maxIndex = -1;
        while (left <= right) {
            if (max < nums[left]) {
                max = nums[left];
                maxIndex = left;
            }
            left++;
        }
        return new int[]{max, maxIndex};
    }

    public static void main(String[] args) {
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();

        System.out.println(constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }

}
