package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/19 9:11
 */

public class IsValidBST {

    private Integer pre;

    public boolean isValidBST(TreeNode root) {
        return this.dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean flag = this.dfs(node.left);
        if (pre != null && node.val <= pre) {
            flag = false;
        }
        pre = node.val;
        flag &= this.dfs(node.right);
        return flag;
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();

        System.out.println(isValidBST.isValidBST(TreeNode.makeupTree(new Integer[]{3, 1, 5, null, 2})));
        System.out.println(isValidBST.isValidBST(TreeNode.makeupTree(new Integer[]{1, 1})));
    }

}
