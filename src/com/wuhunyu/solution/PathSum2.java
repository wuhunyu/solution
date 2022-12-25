package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.*;

/**
 * 113. 路径总和 II
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/22 8:42
 */

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> sumQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int curSum = sumQueue.poll();
            if (node.left == null && node.right == null && curSum == targetSum) {
                ans.add(this.getPathList(node, map));
            }
            if (node.left != null) {
                map.put(node.left, node);
                nodeQueue.offer(node.left);
                sumQueue.offer(curSum + node.left.val);
            }
            if (node.right != null) {
                map.put(node.right, node);
                nodeQueue.offer(node.right);
                sumQueue.offer(curSum + node.right.val);
            }
        }
        return ans;
    }

    private List<Integer> getPathList(TreeNode node, Map<TreeNode, TreeNode> map) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();

        System.out.println(pathSum2.pathSum(TreeNode.makeupTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
    }

}
