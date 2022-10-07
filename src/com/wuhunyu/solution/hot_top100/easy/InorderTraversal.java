package com.wuhunyu.solution.hot_top100.easy;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 9:02
 */

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while (node != null && !set.contains(node)) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            set.add(node);
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();

        System.out.println(inorderTraversal.inorderTraversal(TreeNode.makeupTree(new Integer[]{1, 2, 3, 4, 5, null})));
    }

}
