package com.sudhar.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZombieInMatrix {

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(0, 1, 1, 0, 1));
        input.add(List.of(0, 1, 0, 1, 0));
        input.add(List.of(0, 0, 0, 0, 1));
        input.add(List.of(0, 1, 0, 0, 0));

        ZombieInMatrix zombie = new ZombieInMatrix();
        System.out.println(zombie.findMinTimeToBecomeZombie(input));
    }

    private int findMinTimeToBecomeZombie(List<List<Integer>> input) {
        int[][] a = new int[input.size()][input.get(0).size()];
        int zombieCount = 0, target = input.size() * input.get(0).size();
        Queue<int[]> zombies = new LinkedList<>();

        for (int i = 0; i < input.size(); i++) {
            List<Integer> row = input.get(i);

            for (int j = 0; j < row.size(); j++) {
                a[i][j] = row.get(j);

                if (a[i][j] == 1) {
                    zombies.add(new int[] {i, j});
                    zombieCount++;
                }
            }
        }

        int result = 0;
        int row = a.length, col = a[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!zombies.isEmpty()) {

            if (zombieCount ==  target) {
                return result;
            }

            int size = zombies.size();
            for (int i = 0; i < size; i++) {

                int[] zombie = zombies.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + zombie[0];
                    int y = dir[1] + zombie[1];

                    if (x >= 0 && x < row && y >= 0 && y < col && a[x][y] == 0) {
                        zombieCount++;
                        zombies.add(new int[]{x, y});
                        a[x][y] = 1;
                    }
                }
            }

            result++;
        }

        return -1;
    }
}
