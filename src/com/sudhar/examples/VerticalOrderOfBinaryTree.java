package com.sudhar.examples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderOfBinaryTree {

    class BFSSolution {
        // key: column; value: <row, node_value>
        Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap();
        int minColumn = 0, maxColumn = 0;

        private void BFS(TreeNode root) {
            // tuples of <column, <row, value>>
            Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new ArrayDeque();
            int row = 0, column = 0;
            queue.offer(new Pair(root, new Pair(row, column)));

            while (!queue.isEmpty()) {
                Pair<TreeNode, Pair<Integer, Integer>> p = queue.poll();
                root = p.getKey();
                row = p.getValue().getKey();
                column = p.getValue().getValue();

                if (root != null) {
                    if (!columnTable.containsKey(column)) {
                        columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
                    }
                    columnTable.get(column).add(new Pair<>(row, root.val));
                    minColumn = Math.min(minColumn, column);
                    maxColumn = Math.max(maxColumn, column);

                    queue.offer(new Pair(root.left, new Pair(row + 1, column - 1)));
                    queue.offer(new Pair(root.right, new Pair(row + 1, column + 1)));
                }
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> output = new ArrayList();
            if (root == null) {
                return output;
            }

            // step 1). BFS traversal
            this.BFS(root);

            // step 2). retrieve the value from the columnTable
            for (int i = minColumn; i < maxColumn + 1; ++i) {
                // order by both "row" and "value"
                Collections.sort(columnTable.get(i), new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                        if (p1.getKey().equals(p2.getKey()))
                            return p1.getValue() - p2.getValue();
                        else
                            return p1.getKey() - p2.getKey();
                    }
                });

                List<Integer> sortedColumn = new ArrayList();
                for (Pair<Integer, Integer> p : columnTable.get(i)) {
                    sortedColumn.add(p.getValue());
                }
                output.add(sortedColumn);
            }

            return output;
        }
    }

    class DFSSolution {
        Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap();
        int minColumn = 0, maxColumn = 0;

        private void DFS(TreeNode node, Integer row, Integer column) {
            if (node == null)
                return;

            if (!columnTable.containsKey(column)) {
                this.columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
            }

            this.columnTable.get(column).add(new Pair<Integer, Integer>(row, node.val));
            this.minColumn = Math.min(minColumn, column);
            this.maxColumn = Math.max(maxColumn, column);
            // preorder DFS traversal
            this.DFS(node.left, row + 1, column - 1);
            this.DFS(node.right, row + 1, column + 1);
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> output = new ArrayList();
            if (root == null) {
                return output;
            }

            // step 1). DFS traversal
            this.DFS(root, 0, 0);

            // step 2). retrieve the value from the columnTable
            for (int i = minColumn; i < maxColumn + 1; ++i) {
                // order by both "row" and "value"
                Collections.sort(columnTable.get(i), new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                        if (p1.getKey().equals(p2.getKey()))
                            return p1.getValue() - p2.getValue();
                        else
                            return p1.getKey() - p2.getKey();
                    }
                });

                List<Integer> sortedColumn = new ArrayList();
                for (Pair<Integer, Integer> p : columnTable.get(i)) {
                    sortedColumn.add(p.getValue());
                }
                output.add(sortedColumn);
            }

            return output;
        }
    }
}
