package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 655. 输出二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/22 19:12
 */

public class PrintTree {

    public List<List<String>> printTree(TreeNode root) {
        int maxDepth = this.maxDepth(root, 0);
        List<List<String>> lists = new ArrayList<>(maxDepth);
        int colRow = (int) Math.pow(2, maxDepth) - 1;
        for (int i = 0; i < maxDepth; i++) {
            List<String> list = new ArrayList<>(colRow);
            for (int j = 0; j < colRow; j++) {
                list.add("");
            }
            lists.add(list);
        }

        int midCol = (colRow - 1) >> 1;
        lists.get(0).set(midCol, String.valueOf(root.val));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        Queue<Integer> parentCol = new ArrayDeque<>();
        parentCol.offer(midCol);
        int curDepth = 1;
        while (curDepth < maxDepth) {
            List<String> rows = lists.get(curDepth);
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                Integer col = parentCol.poll();
                int add = (int) Math.pow(2, maxDepth - curDepth - 1);
                if (node.left != null) {
                    rows.set(col - add, String.valueOf(node.left.val));
                    queue.offer(node.left);
                    parentCol.offer(col - add);
                }
                if (node.right != null) {
                    rows.set(col + add, String.valueOf(node.right.val));
                    queue.offer(node.right);
                    parentCol.offer(col + add);
                }
            }
            curDepth++;
        }
        return lists;
    }

    private int maxDepth(TreeNode node, int curDepth) {
        if (node == null) {
            return curDepth;
        }
        return Math.max(this.maxDepth(node.left, curDepth), this.maxDepth(node.right, curDepth)) + 1;
    }

    public static void main(String[] args) {
        PrintTree printTree = new PrintTree();

//        List<List<String>> lists = printTree.printTree(TreeNode.makeupTree(new Integer[]{1, 2, 3, null, 4}));
        List<List<String>> lists = printTree.printTree(TreeNode.makeupTree(new Integer[]{1, 2}));
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print((s.length() == 0 ? "_" : s) + '\t');
            }
            System.out.println();
        }
    }

}
