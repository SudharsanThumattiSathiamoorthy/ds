package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class TraverseTree {
    private List<String> list;

    private StringBuilder sb;

    public List<String> binaryTreePaths(TreeNode root) {

        list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        sb = new StringBuilder();
        traverseTree(root);
        return list;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int length = sb.length();
        sb.append(root.val);

        //length = sb.length() - length;
        length = 1;
        if (root.left == null && root.right == null) {
            // leaf node.
            list.add(sb.toString());
            sb.delete(sb.length() - length, sb.length());

            return;
        }

        sb.append("->");
        // length += 2;
        length = 3;

        if (root.left != null)
            traverseTree(root.left);

        if (root.right != null)
            traverseTree(root.right);

        sb.delete(sb.length() - length, sb.length());
    }
}

public class PrintAllPathsOfTree {

    public static void main(final String[] args) {

        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.right = new TreeNode(5);


        TraverseTree tree = new TraverseTree();
        System.out.println(tree.binaryTreePaths(node));
    }
}
