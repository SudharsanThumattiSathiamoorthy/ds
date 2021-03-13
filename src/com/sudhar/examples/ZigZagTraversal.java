package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int height = getHeight(root);
        //  System.out.println("height : " + height);

        List<List<Integer>> result = new ArrayList<>();
        boolean odd = true;

        for (int i = 1; i <= height; i++) {
            List<Integer> level = new ArrayList<>();
            traverse(level, i, root, odd);
            result.add(level);
            odd = !odd;
        }
        return result;
    }

    private void traverse(List<Integer> level, int height, TreeNode node, boolean odd) {
        if (node == null) {
            return;
        }
        // System.out.println("height : " + height);
        if (height == 1) {
            level.add(node.val);
            return;
        }

        if (odd) {
            traverse(level, height - 1, node.left, odd);
            traverse(level, height - 1, node.right, odd);
        } else {
            traverse(level, height - 1, node.right, odd);
            traverse(level, height - 1, node.left, odd);
        }
    }


    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

}
