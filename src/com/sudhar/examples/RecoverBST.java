package com.sudhar.examples;

public class RecoverBST {

    TreeNode leftPointer = null, rightPointer = null, prev = null;

    public void recover(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root);

        if (leftPointer != null) {
            int temp = leftPointer.val;
            leftPointer.val = rightPointer.val;
            rightPointer.val = temp;
        }
    }

    private void inorderTraverse(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inorderTraverse(curr.left);
        if (prev != null) {
            if (prev.val > curr.val) {
                if (leftPointer == null) {
                    leftPointer = prev;
                }
                rightPointer = curr;
            }
        }

        prev = curr;

        inorderTraverse(curr.right);
    }
}
