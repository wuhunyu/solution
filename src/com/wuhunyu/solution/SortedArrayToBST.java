package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/19 10:23
 */

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = this.dfs(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left < 0 || left >= nums.length || right < 0 || right >= nums.length) {
            return null;
        }
        int mid = ((right - left) >> 1) + left;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = this.dfs(nums, left, mid - 1);
        treeNode.right = this.dfs(nums, mid + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();

        System.out.println(sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}
