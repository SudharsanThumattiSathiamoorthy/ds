package com.sudhar.examples;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/minimum-knight-moves/
public class MinimumKnightMoves {

    class Cell {

        int row, col, dist;

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    private boolean isSafe(int x, int y) {
        if (x < 0 || y < 0 || x > 300 || y > 300) {
            return false;
        }
        return true;
    }


    private int BFS(int row, int col, int x, int y) {
        int dist = 0;
        boolean[][] visited = new boolean[301][301];
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(row, col, 0));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            if (cell.row == x && cell.col == y) {
                return cell.dist;
            }

            if (!visited[cell.row][cell.col]) {
                visited[cell.row][cell.col] = true;
                for (int i = 0; i < 8; i++) {
                    if (isSafe(cell.row + row, cell.col + col)) {
                        queue.add(new Cell(cell.row + row, cell.col + col, cell.dist + 1));
                    }
                }
            }

        }
        return -1;
    }

    public int minKnightMoves(int x, int y) {
        //int[][] board = new int[301][301];

        //handling edge cases
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x == 1 && y == 1) {
            return 2;
        }

        return BFS(0, 0, Math.abs(x), Math.abs(y));
    }

}
