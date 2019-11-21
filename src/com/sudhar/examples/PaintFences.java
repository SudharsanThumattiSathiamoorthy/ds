package com.sudhar.examples;

public class PaintFences {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1 };

        System.out.println(noOfWays(arr));
    }

    private static int noOfWays(int[] arr) {
        int pos[] = new int[arr.length];
        int p = 0, i;

        // for loop for saving the
        // positions of all 1s
        for (i = 0; i < arr.length; i++)
        {
            if (arr[i] == 1)
            {
                pos[p] = i + 1;
                p++;
            }
        }

        // If array contains only 0s
        if (p == 0)
            return 0;

        int ways = 1;
        for (i = 0; i < p - 1; i++)
        {
            ways *= pos[i + 1] - pos[i];
        }

        // Return the total ways
        return ways;
    }
}
