package com.wuhunyu.solution.od;

import java.util.*;

/**
 * 完全二叉树非叶子部分后序遍历
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 15:14
 */

public class PostTravelArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        List<Integer> list = new ArrayList<>();
        int len = str.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                list.add(num);
                num = 0;
                continue;
            }
            num = num * 10 + str.charAt(i) - '0';
            if (i == len - 1) {
                list.add(num);
                break;
            }
        }
        TreeNode root = TreeNode.makeupTree(list);
        List<Integer> ans = new ArrayList<>();
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        } else {
            dfs(root, ans);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer el : ans) {
            sb.append(el)
                    .append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            dfs(node.left, list);
        }
        if (node.right != null) {
            dfs(node.right, list);
        }
        if (node.left != null || node.right != null) {
            list.add(node.val);
        }
    }

    private static class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }

        public static TreeNode makeupTree(List<Integer> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            TreeNode root = new TreeNode(nodes.get(0));
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int index = 1;
            int len = nodes.size();
            while (index < len) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (index < len) {
                        node.left = new TreeNode(nodes.get(index));
                        queue.offer(node.left);
                    }
                    index++;
                    if (index < len) {
                        node.right = new TreeNode(nodes.get(index));
                        queue.offer(node.right);
                    }
                    index++;
                }
            }
            return root;
        }

    }


}
