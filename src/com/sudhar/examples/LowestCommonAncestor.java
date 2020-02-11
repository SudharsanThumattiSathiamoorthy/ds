package com.sudhar.examples;

public class LowestCommonAncestor {

    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }

        if (root.val == a.val || root.val == b.val) {
            return root;
        }

        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        return left;
    }
}
