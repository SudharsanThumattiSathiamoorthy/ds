package com.sudhar.examples;

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

    public static void main(final String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(3);
        tree.root.left = new Node(4);
        tree.root.right = new Node(5);

        System.out.println(tree.isBST());
    }
}
