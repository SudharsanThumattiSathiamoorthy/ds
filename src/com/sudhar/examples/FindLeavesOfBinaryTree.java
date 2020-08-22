package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        while (root != null) {
            List<Integer> leaves = new ArrayList<>();

            root = findLeaves(root, leaves);
            result.add(leaves);
        }

        return result;
    }

    private TreeNode findLeaves(TreeNode curr, List<Integer> leaves) {
        if (curr.left == null && curr.right == null) {
            leaves.add(curr.val);
            return null;
        }
        else {
            if (curr.left != null && curr.right != null) {
                curr.left = findLeaves(curr.left, leaves);
                curr.right = findLeaves(curr.right, leaves);
            } else if (curr.left != null) {
                curr.left = findLeaves(curr.left, leaves);
            } else {
                curr.right = findLeaves(curr.right, leaves);
            }
        }

        return curr;
    }

}
