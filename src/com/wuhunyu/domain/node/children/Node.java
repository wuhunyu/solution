package com.wuhunyu.domain.node.children;

import java.util.List;

/**
 * 多节点Node
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/18 9:11
 */

public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
