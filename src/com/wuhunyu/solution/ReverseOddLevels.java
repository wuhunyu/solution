package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 6182. 反转二叉树的奇数层
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-18 10:41
 */

public class ReverseOddLevels {

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.clear();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if ((depth & 1) == 1) {
                    list.add(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            int halfLimit = list.size() >> 1;
            for (int i = 0, j = list.size() - 1; i < halfLimit; i++, j--) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(j);
                int tmp = left.val;
                left.val = right.val;
                right.val = tmp;
            }
            depth++;
        }
        return root;
    }

    public static void main(String[] args) {
        ReverseOddLevels reverseOddLevels = new ReverseOddLevels();

        System.out.println(reverseOddLevels.reverseOddLevels(TreeNode.makeupTree(new Integer[]{2, 3, 5, 8, 13, 21, 34})));
    }

}
