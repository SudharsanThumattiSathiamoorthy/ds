package com.sudhar.examples;

import java.util.Arrays;
import java.util.Stack;

public class LongestRectangleInMatrix {

    public static void main(String[] args) {
        int a[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                };

        System.out.println(maxRectangle(a));
    }

    static int maxRectangle(int[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int r = a.length, c =  a[0].length;
        int result = histogram(a[0], c);

        System.out.println(Arrays.toString(a[0]));

        for (int i = 1; i < r; i++) {

            for (int j = 0; j < c; j++) {
                if (a[i][j] == 1) {
                    a[i][j] += a[i-1][j];
                }

                result = Math.max(result, histogram(a[i], c));

            }
            System.out.println(Arrays.toString(a[i]));
        }

        return result;
    }


    static int histogram(int[] a, int c) {
        int i = 0, max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        while(i < c) {
            if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();

                int h = a[index];
                int w = stack.isEmpty() ? i : i - stack.peek()  -1;

                max = Math.max(max, h * w);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int h = a[index];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;

            max = Math.max(max, h * w);
        }
        return max;
    }
}
