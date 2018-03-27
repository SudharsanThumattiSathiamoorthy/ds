package com.sudhar.examples;

class BST<T> {
    T data;

    BST left;
    BST right;

    BST(T t) {
        this.data = t;
    }
}
public class BuildTreeFromPreAndIn {

    private static int preIndex = 0;

    public static void main(final String[] args) {

        final char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        final char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};

        final BST node = buildBST(pre, in, 0, pre.length - 1);

        inOrder(node);
    }

    private static void inOrder(BST node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private static BST buildBST(char[] pre, char[] in, int start, int end) {

        if (start > end) {
            return null;
        }

        final BST<Character> node = new BST<>(pre[preIndex++]);

        if (start == end) {
            return node;
        }
        final int index = findIndex(node.data, in);

        node.left = buildBST(pre, in, start, index-1);
        node.right = buildBST(pre, in, index+1, end);

        return node;
    }

    private static int findIndex(char node, char[] in) {
        for (int i =0;i < in.length;i++) {
            if (node == in[i]) {
                return i;
            }
        }
        return -1;
    }
}
