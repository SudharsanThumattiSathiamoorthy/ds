package com.sudhar.examples;

public class MinNoOfJumps {

    public static void main(String[] args) {

    }

    private static int minNoOfJumps(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int count = a[0], steps =0, max = 0;

        for (int i =1; i < a.length; i++) {
            count--;
            max--;

            if (i  == a.length - 1) {
                return steps + 1;
            }

            if (count == 0) {
                if (max  == 0) {
                    return -1;
                }

                count = max;
                max = 0;
                steps++;
            }
        }

        return steps;
    }
}
