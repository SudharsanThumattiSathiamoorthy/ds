package com.sudhar.examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeII {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        MazeII mazeII = new MazeII();

        System.out.println(mazeII.shortestDistance(maze, new int[]{0, 4}, new int[]{4, 4}));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }

        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] s = queue.poll();

            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];

                int count = 0;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];

                    count++;
                }

                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }

        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
