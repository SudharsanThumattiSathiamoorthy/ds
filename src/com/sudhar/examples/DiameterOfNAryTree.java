package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfNAryTree {

    class Node {

        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {

        protected int diameter = 0;

        /**
         * return the height of the node
         */
        protected int height(Node node) {
            if (node.children.size() == 0) {
                return 0;
            }

            // select the top two largest heights
            int maxHeight1 = 0, maxHeight2 = 0;
            for (Node child : node.children) {
                int parentHeight = height(child) + 1;
                if (parentHeight > maxHeight1) {
                    maxHeight2 = maxHeight1;
                    maxHeight1 = parentHeight;
                } else if (parentHeight > maxHeight2) {
                    maxHeight2 = parentHeight;
                }
                // calculate the distance between the two farthest leaves nodes.
                int distance = maxHeight1 + maxHeight2;
                this.diameter = Math.max(this.diameter, distance);
            }

            return maxHeight1;
        }

        public int diameter(Node root) {
            this.diameter = 0;
            height(root);
            return diameter;
        }
    }

    class Solution2 {

        protected int diameter = 0;

        /**
         * return the maximum depth of leaves nodes descending from the given node
         */
        protected int maxDepth(Node node, int currDepth) {
            if (node.children.size() == 0) {
                return currDepth;
            }

            // select the top two largest depths
            int maxDepth1 = currDepth, maxDepth2 = 0;
            for (Node child : node.children) {
                int depth = maxDepth(child, currDepth + 1);
                if (depth > maxDepth1) {
                    maxDepth2 = maxDepth1;
                    maxDepth1 = depth;
                } else if (depth > maxDepth2) {
                    maxDepth2 = depth;
                }
                // calculate the distance between the two farthest leaves nodes.
                int distance = maxDepth1 + maxDepth2 - 2 * currDepth;
                this.diameter = Math.max(this.diameter, distance);
            }

            return maxDepth1;
        }

        public int diameter(Node root) {
            this.diameter = 0;
            maxDepth(root, 0);
            return diameter;
        }
    }

    class Solution5 {
        protected int diameter = 0;

        /**
         * return the height of the node
         */
        protected int height(Node node) {
            if (node.children.size() == 0)
                return 0;

            // select the top two largest heights
            int maxHeight1 = 0, maxHeight2 = 0;
            for (Node child : node.children) {
                int parentHeight = height(child) + 1;
                if (parentHeight > maxHeight1) {
                    maxHeight2 = maxHeight1;
                    maxHeight1 = parentHeight;
                } else if (parentHeight > maxHeight2) {
                    maxHeight2 = parentHeight;
                }
                // calculate the distance between the two farthest leaves nodes.
                int distance = maxHeight1 + maxHeight2;
                this.diameter = Math.max(this.diameter, distance);
            }

            return maxHeight1;
        }

        public int diameter(Node root) {
            this.diameter = 0;
            height(root);
            return diameter;
        }
    }

    class Solution6 {
        protected int diameter = 0;

        /**
         * return the maximum depth of leaves nodes descending from the given node
         */
        protected int maxDepth(Node node, int currDepth) {
            if (node.children.size() == 0)
                return currDepth;

            // select the top two largest depths
            int maxDepth1 = currDepth, maxDepth2 = 0;
            for (Node child : node.children) {
                int depth = maxDepth(child, currDepth + 1);
                if (depth > maxDepth1) {
                    maxDepth2 = maxDepth1;
                    maxDepth1 = depth;
                } else if (depth > maxDepth2) {
                    maxDepth2 = depth;
                }
                // calculate the distance between the two farthest leaves nodes.
                int distance = maxDepth1 + maxDepth2 - 2 * currDepth;
                this.diameter = Math.max(this.diameter, distance);
            }

            return maxDepth1;
        }

        public int diameter(Node root) {
            this.diameter = 0;
            maxDepth(root, 0);
            return diameter;
        }
    }
}
