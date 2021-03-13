package com.sudhar.examples;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FindNearestRightNodeinBinaryTree {

    class Solution {
        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            if (root == null) return null;

            ArrayDeque<TreeNode> nextLevel = new ArrayDeque() {{ offer(root); }};
            ArrayDeque<TreeNode> currLevel = new ArrayDeque();

            TreeNode node = null;
            while (!nextLevel.isEmpty()) {
                // prepare for the next level
                currLevel = nextLevel.clone();
                nextLevel.clear();

                while (!currLevel.isEmpty()) {
                    node = currLevel.poll();

                    if (node == u)
                        return currLevel.poll();

                    // add child nodes of the current level
                    // in the queue for the next level
                    if (node.left != null)
                        nextLevel.offer(node.left);
                    if (node.right != null)
                        nextLevel.offer(node.right);
                }
            }
            return null;
        }
    }

    class Solution1 {
        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            if (root == null) return null;

            Queue<TreeNode> queue = new LinkedList(){{ offer(root); offer(null); }};
            TreeNode curr = null;

            while (!queue.isEmpty()) {
                curr = queue.poll();

                if (curr != null) {
                    // if it's the given node
                    if (curr == u)
                        return queue.poll();

                    // add child nodes in the queue
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                } else {
                    // add a sentinel to mark end of level
                    if (!queue.isEmpty())
                        queue.offer(null);
                }
            }
            return null;
        }
    }

    class Solution4 {
        int uDepth;
        TreeNode nextNode, u;

        public void preorder(TreeNode node, int depth) {
            // the depth to look for next node is identified
            if (node == u) {
                uDepth = depth;
                // we're on the level to look for the next node
            } else if (depth == uDepth) {
                // if this next node is not identified yet
                if (nextNode == null)
                    nextNode = node;
            } else {
                // continue to traverse the tree
                if (node.left != null)
                    preorder(node.left, depth + 1);
                if (node.right != null)
                    preorder(node.right, depth + 1);
            }
        }

        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            uDepth = - 1;
            nextNode = null;
            this.u = u;
            preorder(root, 0);
            return nextNode;
        }
    }
}
