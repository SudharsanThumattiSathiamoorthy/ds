package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    List<TreeNode> result = new ArrayList<>();
    int rootData;

    public static void main(String[] args) {


    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return null;
        }

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int no: to_delete) {
            toDeleteSet.add(no);
        }

        rootData = root.val;
        deleteNodes(root, toDeleteSet);

        return result;
    }

    public TreeNode deleteNodes(TreeNode root, Set<Integer> toDeleteSet) {
        if (root == null) {
            return null;
        }

        root.left = deleteNodes(root.left, toDeleteSet);
        root.right = deleteNodes(root.right, toDeleteSet);

        if (root.val == rootData && toDeleteSet.size() >= 1 && !toDeleteSet.contains(root.val)) {
            result.add(root);
        }

        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }

        return root;
    }
}
