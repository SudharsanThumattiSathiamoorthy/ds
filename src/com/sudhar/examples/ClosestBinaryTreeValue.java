package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ClosestBinaryTreeValue {

//    Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
//            Note:
//
//    Given target value is a floating point.
//    You are guaranteed to have only one unique value in the BST that is closest to the target.
//    Example:
//
//    Input: root = [4,2,5,1,3], target = 3.714286
//
//            4
//            / \
//            2   5
//            / \
//            1   3
//
//    Output: 4

//    Approach 1: Recursive Inorder + Linear search, O(N) time
//            Intuition
//
//    The simplest approach (3 lines in Python) is to build inorder traversal and then find the closest element in a sorted array with built-in function min.
//
//            pic
//
//    This approach is simple stupid, and serves to identify the subproblems.

    class Solution1 {
        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) return;
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public int closestValue(TreeNode root, double target) {
            List<Integer> nums = new ArrayList();
            inorder(root, nums);
            return Collections.min(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
                }
            });
        }
    }

//    Approach 2: Iterative Inorder, O(k) time
//            Intuition
//
//    Let's optimise Approach 1 in the case when index k of the closest element is much smaller than the tree heigh H.
//
//    First, one could merge both steps by traversing the tree and searching the closest value at the same time.
//
//    Second, one could stop just after identifying the closest value, there is no need to traverse the whole tree. The closest value is found if the target value is in-between of two inorder array elements nums[i] <= target < nums[i + 1]. Then the closest value is one of these elements.

    class Solution2 {
        public int closestValue(TreeNode root, double target) {
            LinkedList<TreeNode> stack = new LinkedList();
            long pred = Long.MIN_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.removeLast();

                if (pred <= target && target < root.val)
                    return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;

                pred = root.val;
                root = root.right;
            }
            return (int)pred;
        }
    }

//    Approach 3: Binary Search, O(H) time
//            Intuition
//
//    Approach 2 works fine when index k of closest element is much smaller than the tree height H.
//
//    Let's now consider another limit and optimise Approach 1 in the case of relatively large k, comparable with N.
//
//    Then it makes sense to use a binary search: go left if target is smaller than current root value, and go right otherwise. Choose the closest to target value at each step.

    class Solution3 {
        public int closestValue(TreeNode root, double target) {
            int val, closest = root.val;
            while (root != null) {
                val = root.val;
                closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
                root =  target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }
}
