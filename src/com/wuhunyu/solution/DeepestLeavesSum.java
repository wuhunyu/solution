package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/17 9:57
 */

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

}
