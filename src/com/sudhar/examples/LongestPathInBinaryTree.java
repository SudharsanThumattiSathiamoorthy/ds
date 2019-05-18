package com.sudhar.examples;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestPathInBinaryTree {

    Node root;

    Set<Node> findLongestPath(Node node, Set<Node> currentList, Set<Node> maxList) {
        if (node == null) {
            return currentList;
        }

        if (currentList.size() > maxList.size()) {
            maxList = new LinkedHashSet<>(currentList);
        }

        if (node.left != null && node.left.data == node.data + 1) {
            currentList.add(node);
            currentList.add(node.left);

            return findLongestPath(node.left, currentList, maxList);
        }

        if (node.right != null && node.right.data == node.data + 1) {
            currentList.add(node);
            currentList.add(node.right);
            return findLongestPath(node, currentList, maxList);
        }

        return maxList;
    }

    public static void main(final String[] args) {

        LongestPathInBinaryTree tree = new LongestPathInBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);

        tree.root.right = new Node(2);

        System.out.println(tree.findLongestPath(tree.root, new LinkedHashSet<>(), new LinkedHashSet<>()));
    }
}
