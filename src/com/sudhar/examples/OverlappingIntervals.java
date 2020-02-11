package com.sudhar.examples;

import java.util.Arrays;
import java.util.Comparator;

// Similar Prob:: Overlapping intervals.

public class OverlappingIntervals {

    public static void main(final String[] args) {
        int[][] a = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] < a[i - 1][1]) {
                System.out.println(a[i][0] + "  " + a[i - 1][1]);
                System.err.println("Overlap found");
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i][1] > max) {
                max = a[i][1];
            }
        }

        int[] aux = new int[max + 2];

        for (int i = 0; i < a.length; i++) {
            aux[a[i][0]]++;
            aux[a[i][1] + 1]--;
        }

        for (int i = 1; i <= max; i++) {
            aux[i] += aux[i - 1];

            if (aux[i] > 1) {
                System.out.println("Overlap found");
            }
        }
    }
}
