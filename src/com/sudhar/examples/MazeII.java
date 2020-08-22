package com.sudhar.examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MazeII {

//    Example 1:
//
//    Input 1: a maze represented by a 2D array
//
//0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//    Input 2: start coordinate (rowStart, colStart) = (0, 4)
//    Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//
//    Output: 12
//
//    Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
//    The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

//    Input 1: a maze represented by a 2D array
//
//0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//    Input 2: start coordinate (rowStart, colStart) = (0, 4)
//    Input 3: destination coordinate (rowDest, colDest) = (3, 2)
//
//    Output: -1
//
//    Explanation: There is no way for the ball to stop at the destination.

//    Note:
//
//    There is only one ball and one destination in the maze.
//    Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//    The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
//    The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.


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

    public class SolutionDFS {
        public int shortestDistance(int[][] maze, int[] start, int[] dest) {
            int[][] distance = new int[maze.length][maze[0].length];
            for (int[] row: distance)
                Arrays.fill(row, Integer.MAX_VALUE);
            distance[start[0]][start[1]] = 0;
            dfs(maze, start, distance);
            return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        }

        public void dfs(int[][] maze, int[] start, int[][] distance) {
            int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
            for (int[] dir: dirs) {
                int x = start[0] + dir[0];
                int y = start[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                    dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
                }
            }
        }
    }

    public class SolutionBFS {
        public int shortestDistance(int[][] maze, int[] start, int[] dest) {
            int[][] distance = new int[maze.length][maze[0].length];
            for (int[] row: distance)
                Arrays.fill(row, Integer.MAX_VALUE);
            distance[start[0]][start[1]] = 0;
            int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
            Queue < int[] > queue = new LinkedList < > ();
            queue.add(start);
            while (!queue.isEmpty()) {
                int[] s = queue.remove();
                for (int[] dir: dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    int count = 0;
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                        distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                        queue.add(new int[] {x - dir[0], y - dir[1]});
                    }
                }
            }
            return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        }
    }

//    Approach #4 Using Dijkstra Algorithm and Priority Queue[Accepted]
//    Algorithm
//
//    In the last approach, in order to choose the current node, we traversed over the whole distancedistance array and found out an unvisited node at the shortest distance from the startstart node. Rather than doing this, we can do the same task much efficiently by making use of a Priority Queue, queuequeue. This priority queue is implemented internally in the form of a heap. The criteria used for heapifying is that the node which is unvisited and at the smallest distance from the startstart node, is always present on the top of the heap. Thus, the node to be chosen as the current node, is always present at the front of the queuequeue.
//
//    For every current node, we again try to traverse in all the possible directions. We determine the minimum number of steps(till now) required to reach all the end points possible from the current node. If any such end point can be reached in a lesser number of steps through the current path than the paths previously considered, we need to update its distancedistance entry.
//
//            Further, we add an entry corresponding to this node in the queuequeue, since its distancedistance entry has been updated and we need to consider this node as the competitors for the next current node choice. Thus, the process remains the same as the last approach, except the way in which the pick out the current node(which is the unvisited node at the shortest distance from the startstart node).
    public class Solution {
        public int shortestDistance(int[][] maze, int[] start, int[] dest) {
            int[][] distance = new int[maze.length][maze[0].length];
            for (int[] row: distance)
                Arrays.fill(row, Integer.MAX_VALUE);
            distance[start[0]][start[1]] = 0;
            dijkstra(maze, start, distance);
            return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        }

        public void dijkstra(int[][] maze, int[] start, int[][] distance) {
            int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
            PriorityQueue< int[] > queue = new PriorityQueue < > ((a, b) -> a[2] - b[2]);
            queue.offer(new int[]{start[0],start[1],0});
            while (!queue.isEmpty()) {
                int[] s = queue.poll();
                if(distance[s[0]][s[1]] < s[2])
                    continue;
                for (int[] dir: dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    int count = 0;
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                        distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                        queue.offer(new int[]{x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]]});
                    }
                }
            }
        }
    }
}
