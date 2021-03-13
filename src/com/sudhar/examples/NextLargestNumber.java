package com.sudhar.examples;

import java.util.Arrays;

public class NextLargestNumber {

    public static void main(String[] args) {
        int no = 534976;

        char[] a = String.valueOf(no).toCharArray();

        nextGreaterElement(no);

        nextGreaterElement(2147483476);
    }

    public static int nextGreaterElement(int n) {
        if (n <= 0) {
            return -1;
        }

        String no = String.valueOf(n);

        char[] nos = no.toCharArray();

        int i = nos.length - 1;

        while (i > 0 && nos[i - 1] >= nos[i]) {
            i--;
        }

        if (i == 0) {
            return -1;
        }

        int x = i - 1;

        int minIndex = findMinIndex(nos, i, x);

        swap(nos, x, minIndex);

        Arrays.sort(nos, i, nos.length);
        // System.out.println("No :" + new String(nos));

        long val = Long.valueOf(new String(nos));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }

    private static int findMinIndex(char[] a, int index, int x) {
        int minIndex = index;
        char sNo = a[x];
        for (int i = index + 1; i < a.length; i++) {
            if (a[i] > sNo && a[i] <= a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(char[] nos, int i, int j) {
        char temp = nos[i];
        nos[i] = nos[j];
        nos[j] = temp;
    }
}
