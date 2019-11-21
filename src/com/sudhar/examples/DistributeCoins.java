package com.sudhar.examples;

public class DistributeCoins {

    private static int distance = 0;

    public static void main(String[] args) {
        Node node = new Node(3);

        node.left = new Node(0);
        node.right  = new Node(0);

        distributeCoins(node);
        System.out.println(distance);

        distance = 0;

        node = new Node(1);
        node.left = new Node(1);
        node.right = new Node(1);
        node.left.right = new Node(1);

        distributeCoins(node);
        System.out.println(distance);
    }

    private static int distributeCoins(Node node) {
        if (node == null) {
            return 0;
        }

        int left = distributeCoins(node.left);
        int right = distributeCoins(node.right);

        distance += Math.abs(left) + Math.abs(right);

        return left + right + node.data -1;
    }
}
