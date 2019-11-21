package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        preorder(queue, root);

        queue.poll();
        TreeNode node = root;

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            node.right = curr;
            node.left = null;

            node = node.right;
        }

        return root;
    }

    private void preorder(Queue<TreeNode> queue, TreeNode node) {
        if (node == null) {
            return;
        }

        queue.add(node);

        preorder(queue, node.left);
        preorder(queue, node.right);
    }
}
