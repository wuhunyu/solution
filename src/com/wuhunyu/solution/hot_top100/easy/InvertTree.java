package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 12:42
 */

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();

        invertTree.invertTree(TreeNode.makeupTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
    }

}
