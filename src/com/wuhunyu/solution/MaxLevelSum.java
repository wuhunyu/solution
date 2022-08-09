package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/7/31 9:06
 */

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floor = 1;
        int minFloor = 1;
        int minSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
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
            if (minSum < sum) {
                minSum = sum;
                minFloor = floor;
            }
            floor++;
        }
        return minFloor;
    }

}
