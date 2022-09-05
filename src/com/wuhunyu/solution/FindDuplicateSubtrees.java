package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-05 8:17
 */

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        this.dfs(root, map, set);
        return new ArrayList<>(set);
    }

    private String dfs(TreeNode node, Map<String, TreeNode> map, Set<TreeNode> set) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(this.dfs(node.left, map, set));
        sb.append(")(");
        sb.append(this.dfs(node.right, map, set));
        sb.append(")");
        String nodeStr = sb.toString();
        System.out.println(nodeStr);
        TreeNode targetNode = map.get(nodeStr);
        if (targetNode != null) {
            set.add(targetNode);
        } else {
            map.put(nodeStr, node);
        }
        return nodeStr;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();

        findDuplicateSubtrees.findDuplicateSubtrees(TreeNode.makeupTree(new Integer[]{2, 1, 1}));
    }

}
