package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int[] x = {1, -1, 0, 0, 1, -1, 1, -1}; // cols
    int[] y = {0, 0, 1, -1, 1, 1, -1, -1}; // rows

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid == null || n == 0 || grid[0][0] != 0 || grid[n - 1][n - 1] != 0) // if start is not 0 or destination is not 0, return -1
            return -1;
        if (n == 1) // if grid consists of just one cell
            return 1;

        // bottom to up
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n - 1, n - 1));
        grid[n - 1][n - 1] = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0; k < 8; k++) {
                int i = node.r + y[k];
                int j = node.c + x[k];
                if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0) // if next cell is not zero skip it i.e visited
                    continue;
                // since we are modifying existing matrix, we dont't need extra data structure to keep track of visited cell
                grid[i][j] = grid[node.r][node.c] + 1; // cost of reaching destination from (i,j)
                if (i == 0 && j == 0)
                    return grid[i][j];
                queue.add(new Node(i, j)); // add it to the queue
            }
        }
        return -1;
    }
}
