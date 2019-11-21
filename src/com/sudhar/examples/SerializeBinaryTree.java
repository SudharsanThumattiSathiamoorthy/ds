package com.sudhar.examples;

import java.util.Stack;

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
}
