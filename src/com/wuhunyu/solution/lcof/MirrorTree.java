package com.wuhunyu.solution.lcof;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author gongzhiqiang
 * @date 2022/12/13 22:20
 **/

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = this.mirrorTree(root.right);
        root.right = this.mirrorTree(left);
        return root;
    }

}
