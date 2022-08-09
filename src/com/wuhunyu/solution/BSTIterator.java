package com.wuhunyu.solution;

import com.wuhunyu.domain.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 17:24
 */

public class BSTIterator {

    private List<Integer> nodes;

    private int index;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        index = 0;
        this.dfs(root, nodes);
    }

    private void dfs(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            this.dfs(node.left, nodes);
        }
        nodes.add(node.val);
        if (node.right != null) {
            this.dfs(node.right, nodes);
        }
    }

    public int next() {
        return nodes.get(index++);
    }

    public boolean hasNext() {
        return index < nodes.size();
    }

    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(TreeNode.makeupTree(new Integer[]{7, 3, 15, null, null, 9, 20}));
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

}
