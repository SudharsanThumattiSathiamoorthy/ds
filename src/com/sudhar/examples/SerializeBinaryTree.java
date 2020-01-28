package com.sudhar.examples;

import java.util.*;

public class SerializeBinaryTree {

    public String serialize(TreeNode node) {
        if (node == null) {
            return null;
        }

        String delim = "";

        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            sb.append(delim).append(curr == null ? "#" : curr.val);
            delim = ",";

            if (curr != null) {
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String node) {
        if (node == null || node.length() == 0) {
            return null;
        }

        String[] nodes = node.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean left = true;

        for (int i = 1; i < nodes.length; i++) {
            TreeNode curr = nodes[i].equals("#") ? null : new TreeNode(Integer.parseInt(nodes[i]));

            if (left) {
                stack.peek().left = curr;

                if (curr == null) {
                    left = false;
                }
            } else {
                stack.pop().right = curr;

                if (curr != null) {
                    left = true;
                }
            }

            if (curr != null) {
                stack.push(curr);
            }
        }

        return root;
    }

    public String serializeUsingLOT(TreeNode node) {
        if (node == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();


        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                result.add("#");
            } else {
                result.add("" + curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        return String.join(",", result);
    }

    private TreeNode deserializeUsingLOT(String result) {
        if (result == null || result.length() == 0) {
            return null;
        }

        String[] nodes = result.split(",");
        TreeNode node = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int i =1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr != null) {

                TreeNode left = null;
                if (!"#".equals(nodes[i])) {
                    left = new TreeNode(Integer.parseInt(nodes[i]));

                }
                curr.left = left;
                i++;
                queue.offer(left);

                TreeNode right = null;
                if (!"#".equals(nodes[i])) {
                    right = new TreeNode(Integer.parseInt(nodes[i]));

                }
                curr.right = right;
                i++;
                queue.offer(right);
            }
        }

        return node;
    }

    void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");

            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(5);

        SerializeBinaryTree sbt = new SerializeBinaryTree();
        System.out.println(sbt.serializeUsingLOT(node));

        sbt.preorderTraversal(sbt.deserializeUsingLOT(sbt.serializeUsingLOT(node)));
    }
}
