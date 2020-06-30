package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampusBikes {

    public static void main(String[] args) {
        CampusBikes cb = new CampusBikes();

        //System.out.println(Arrays.toString(cb.assignBikes(new int[][]{{0, 0}, {2, 1}}, new int[][]{{1, 2}, {3, 3}})));

        System.out.println(Arrays.toString(cb.assignBikes(new int[][]{{0, 0}, {1, 1}, {2, 0}}, new int[][]{{1, 0}, {2, 2}, {2, 1}})));
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        //max worker and bike distance is 2000

        List<int[]>[] buckets = new ArrayList[2001];

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dis = calDistance(workers[i], bikes[j]);
                if (buckets[dis] == null) {
                    buckets[dis] = new ArrayList<int[]>();
                }
                buckets[dis].add(new int[]{i, j});
            }
        }
        int[] res = new int[workers.length];
        boolean[] visited = new boolean[bikes.length];

        Arrays.fill(res, -1);

        for (int i = 0; i <= 2000; i++) {
            if (buckets[i] == null) {
                continue;
            } else {
                for (int[] tmp : buckets[i]) {
                    if (res[tmp[0]] == -1 && !visited[tmp[1]]) {
                        res[tmp[0]] = tmp[1];
                        visited[tmp[1]] = true;
                    }
                }
            }
        }

        return res;
    }

    private int calDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
