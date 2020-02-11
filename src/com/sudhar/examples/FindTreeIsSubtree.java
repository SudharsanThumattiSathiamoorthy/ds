package com.sudhar.examples;

public class FindTreeIsSubtree {

    public boolean isSubTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        inorder(a, sb1, true);
        inorder(b, sb2, true);

        return sb1.toString().contains(sb2.toString());
    }

    private void inorder(TreeNode curr, StringBuilder sb1, boolean isLeft) {
        if (curr == null) {
            if (isLeft) {
                sb1.append("lnull");
            } else {
                sb1.append("rnull");
            }
        }

        inorder(curr.left, sb1, true);
        sb1.append(curr.val);
        inorder(curr.right, sb1, false);
    }
}
