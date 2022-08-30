package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 998. 最大二叉树 II
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-08-30 8:38
 */

public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode p = new TreeNode(101);
        p.left = root;
        TreeNode pre = p;
        TreeNode node = root;
        while (node != null) {
            if (node.val < val) {
                TreeNode cur = new TreeNode(val);
                cur.left = node;
                pre.right = cur;
                break;
            }
            pre = node;
            node = node.right;
        }
        if (node == null) {
            pre.right = new TreeNode(val);
        }
        return p.left;
    }

}
