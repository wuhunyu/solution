package com.wuhunyu.solution;

import com.wuhunyu.domain.node.children.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/18 9:12
 */

public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        this.dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                this.dfs(child, res);
            }
        }
    }

}
