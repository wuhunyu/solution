package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/5 8:44
 */

public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode p = new TreeNode(val);
            p.left = root;
            return p;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curDepth = 2;
        while (!queue.isEmpty()) {
            if (curDepth++ == depth) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                }
                break;
            }
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        AddOneRow addOneRow = new AddOneRow();
        System.out.println(addOneRow.addOneRow(TreeNode.makeupTree(new Integer[]{4, 2, 6, 3, 1, 5}), 1, 2));
    }

}
