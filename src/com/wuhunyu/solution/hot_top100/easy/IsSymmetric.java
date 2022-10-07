package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 101. 对称二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 10:03
 */

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return this.isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && this.isMirror(left.left, right.right) && this.isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();

        System.out.println(isSymmetric.isSymmetric(TreeNode.makeupTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }

}
