package com.sudhar.examples;

public class DiameterOfTheTree {

    public static int diameterOfThree(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int ld = diameterOfThree(node.left);
        int rd = diameterOfThree(node.right);

        return Math.max(lh + rh, Math.max(ld, rd));
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(final String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOfThree(root));
    }
}
