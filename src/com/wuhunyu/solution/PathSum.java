package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/18 10:12
 */

public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        System.out.println(pathSum.pathSum(TreeNode.makeupTree(new Integer[]{1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000}), 0));
    }

}
