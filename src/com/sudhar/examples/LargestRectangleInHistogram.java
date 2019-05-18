package com.sudhar.examples;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(final String[] args) {
        int a[] = {2,1,5,6,2,3};

        System.out.println(largestRectangle(a));
    }

    private static int largestRectangle(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        final Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0;

        while (i < a.length) {
            if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                int h = a[index];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int h = a[index];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }
}
