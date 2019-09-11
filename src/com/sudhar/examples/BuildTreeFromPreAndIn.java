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
        this.data = data;
        this.height = height;
    }
}

public class BuildTreeFromPreAndIn {

    private static int preIndex = 0;

    private static StringBuilder sb = new StringBuilder();

    private static List<String> list = new ArrayList<>();

    public static void main(final String[] args) {

        final char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        final char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        final char post[] = new char[]{'D', 'E', 'B', 'F', 'C', 'A'};

        final BST node = buildBSTFromPreAndIn(pre, in, 0, pre.length - 1);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        final BST fromPostAndInorder = buildBSTFromPostAndIn(post, new int[]{post.length - 1}, map, 0, post.length - 1);

        System.out.print("\nInorder traversal: ");
        inOrder(node);

        System.out.print("\nPostorder traversal : ");
        postOrder(fromPostAndInorder);

        printTopView(node);

        System.out.println("\nBottom view of the tree");
        printBottomView(node);

        printAllPaths(node);
        System.out.println(list);
    }

    private static void printAllPaths(BST node) {
        sb.append(node.data);

        if (node.left == null && node.right == null) {
            list.add(sb.toString());
            sb.delete(sb.length() -1, sb.length());

            return;
        }

        sb.append("->");
        if (node.left != null) {
            printAllPaths(node.left);
        }

        if (node.right != null) {
            printAllPaths(node.right);
        }

        sb.delete(sb.length() - 3, sb.length());
    }

    private static BST buildBSTFromPostAndIn(char[] post, int pointer[], Map<Character, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }

        BST<Character> node = new BST<>(post[pointer[0]--]);

        if (start == end) {
            return node;
        }

        int index = map.get(node.data);
        node.right = buildBSTFromPostAndIn(post, pointer, map, index + 1, end);
        node.left = buildBSTFromPostAndIn(post, pointer, map, start, index -1);

        return node;
    }
    private static void inOrder(BST node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private static void postOrder(BST node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.data + " ");
    }

    private static BST buildBSTFromPreAndIn(char[] pre, char[] in, int start, int end) {

        if (start > end) {
            return null;
        }

        final BST<Character> node = new BST<>(pre[preIndex++]);

        if (start == end) {
            return node;
        }
        final int index = findIndex(node.data, in);

        node.left = buildBSTFromPreAndIn(pre, in, start, index - 1);
        node.right = buildBSTFromPreAndIn(pre, in, index + 1, end);

        return node;
    }

    private static int findIndex(char node, char[] in) {
        for (int i = 0; i < in.length; i++) {
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

        System.out.print("\nTop View of the tree: ");

        while (!queue.isEmpty()) {
            NodeItem item = queue.poll();
            BST<Character> currNode = (BST<Character>) item.data;

            if (!visitedLevels.contains(item.height)) {
                System.out.print(currNode.data + " ");
                visitedLevels.add(item.height);
            }

            if (currNode.left != null) {
                queue.add(new NodeItem<>(currNode.left, item.height - 1));
            }

            if (currNode.right != null) {
                queue.add(new NodeItem<>(currNode.right, item.height + 1));
            }
        }
    }

    static void printBottomView(BST<Character> node) {
        final Queue<NodeItem<BST<Character>>> queue = new LinkedList<>();

        // 0 is the initial height.
        queue.add(new NodeItem<>(node, 0));

        final Map<Integer, BST<Character>> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            NodeItem item = queue.poll();

            BST<Character> currNode = (BST<Character>) item.data;

            map.put(item.height, currNode);

            if (currNode.left != null) {
                queue.add(new NodeItem<>(currNode.left, item.height - 1));
            }

            if (currNode.right != null) {
                queue.add(new NodeItem<>(currNode.right, item.height + 1));
            }

        }

        System.out.println(map);
    }
}
