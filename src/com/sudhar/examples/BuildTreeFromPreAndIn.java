package com.sudhar.examples;

import java.util.*;

class BST<T> {
    public T data;

    public BST left;
    public BST right;

    BST(T t) {
        this.data = t;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

class NodeItem<T> {
    int height;

    T data;

    NodeItem(T data, int height) {
        this.data =data;
        this.height = height;
    }
}

public class BuildTreeFromPreAndIn {

    private static int preIndex = 0;

    public static void main(final String[] args) {

        final char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        final char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};

        final BST node = buildBST(pre, in, 0, pre.length - 1);

        System.out.println("Inorder traversal: ");
        inOrder(node);

        System.out.println("Top view of the tree ");
        printTopView(node);

        System.out.println("\nBottom view of the tree");
        printBottomView(node);
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

    static <T> void printTopView(BST<Character> node) {

        Queue<NodeItem<BST<Character>>> queue = new LinkedList<>();
        Set<Integer> visitedLevels = new HashSet<>();
        queue.add(new NodeItem<>(node, 0));

        while (!queue.isEmpty()) {
            NodeItem item = queue.poll();
            BST<Character> currNode = (BST<Character>)item.data;

            if (!visitedLevels.contains(item.height)) {
                System.out.print(currNode.data + " ");
                visitedLevels.add(item.height);
            }

            if (currNode.left != null) {
                queue.add(new NodeItem<>(currNode.left, item.height-1));
            }

            if (currNode.right != null) {
                queue.add(new NodeItem<>(currNode.right, item.height+1));
            }
        }
    }

    static <T> void printBottomView(BST<Character> node) {

        int hd = 0;

        final Queue<NodeItem<BST<Character>>> queue = new LinkedList<>();
        queue.add(new NodeItem<>(node, hd));

        final Map<Integer, BST<Character>> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            NodeItem item = queue.poll();

            BST<Character> currNode = (BST<Character>)item.data;

            map.put(item.height, currNode);

            if (currNode.left != null) {
                queue.add(new NodeItem<>(currNode.left, item.height-1));
            }

            if (currNode.right != null) {
                queue.add(new NodeItem<>(currNode.right, item.height + 1));
            }

        }

//        for (Map.Entry<Integer, BST<Character>> entry: map.entrySet()) {
//            System.out.print(entry.getValue() + " ");
//        }

        Set<Map.Entry<Integer, BST<Character>>> set = map.entrySet();

        // Make an iterator
        Iterator<Map.Entry<Integer, BST<Character>>> iterator = set.iterator();

        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, BST<Character>> me = iterator.next();
            System.out.print(me+" ");
        }
    }
}
