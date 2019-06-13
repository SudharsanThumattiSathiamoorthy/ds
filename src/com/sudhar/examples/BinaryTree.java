package com.sudhar.examples;

import java.util.*;

public class BinaryTree {

    Node root;

    Node prev;

    boolean isBST() {
        prev = null;
        return isBST(root);
    }

    boolean isBST(Node node)
    {
        if (node != null) {

            if (!isBST(node.left)) {
                return false;
            }

            if (prev != null && node.data <= prev.data) {
                return false;
            }

            prev = node;

            return isBST(node.right);
        }
        return true;
    }

    void bfs(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            System.out.print(curr + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    void printLevels() {
        if (this.root == null) {
            return;
        }

        Map<Integer, List<Node>> levels = new LinkedHashMap<>();

        printLevels(this.root, levels, 0);

        System.out.println();
        levels.forEach((key, value) -> {
            System.out.print(key + " " + value);
            System.out.println();
        });
    }

    void printLevels(Node root,
                     Map<Integer, List<Node>> levels,
                     int height) {
        if (root == null) {
            return;
        }

        if (levels.containsKey(height)) {
            List<Node> nodes = levels.get(height);
            nodes.add(root);
        } else {
            List<Node> nodes = new ArrayList<>();
            nodes.add(root);
            levels.put(height, nodes);
        }

        printLevels(root.left, levels, height+1);
        printLevels(root.right, levels, height+1);
    }

    public static void main(final String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(3);
        tree.root.left = new Node(4);
        tree.root.right = new Node(5);

        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(7);

        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(9);

        System.out.println(tree.isBST());

        tree.bfs(tree.root);

        tree.printLevels();
    }
}
