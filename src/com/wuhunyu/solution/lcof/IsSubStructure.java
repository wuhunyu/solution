package com.wuhunyu.solution.lcof;

import com.wuhunyu.domain.tree_node.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author gongzhiqiang
 * @date 2022/12/13 21:39
 **/

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null && (this.dfs(A, B) || this.isSubStructure(A.left, B) || this.isSubStructure(A.right, B));
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        return B == null || A != null && A.val == B.val && this.dfs(A.left, B.left) && this.dfs(A.right, B.right);
    }

}
