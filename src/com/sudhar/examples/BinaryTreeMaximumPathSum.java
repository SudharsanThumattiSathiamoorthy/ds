package com.sudhar.examples;

public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSum(root.left), 0);
        int rightSum = Math.max(maxPathSum(root.right), 0);

        max = Math.max(max, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }

}
