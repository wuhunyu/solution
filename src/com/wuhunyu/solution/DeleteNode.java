package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-22 13:00
 */

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tmpRoot = new TreeNode(Integer.MIN_VALUE);
        tmpRoot.right = root;
        TreeNode node = tmpRoot;
        TreeNode p = null;
        while (node != null) {
            if (node.val == key) {
                break;
            }
            p = node;
            node = node.val > key ? node.left : node.right;
        }
        if (node == null) {
            return tmpRoot.right;
        }
        if (node.right == null) {
            if (p.left == node) {
                p.left = node.left;
            } else {
                p.right = node.left;
            }
            return tmpRoot.right;
        }
        TreeNode pMinNode = node;
        TreeNode minNode = node.right;
        while (minNode.left != null) {
            pMinNode = minNode;
            minNode = minNode.left;
        }
        node.val = minNode.val;
        if (pMinNode.right == minNode) {
            pMinNode.right = minNode.right;
        } else {
            pMinNode.left = minNode.right;
        }
        return tmpRoot.right;
    }

}
