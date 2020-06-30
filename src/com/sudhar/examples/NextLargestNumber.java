package com.sudhar.examples;

import java.util.Arrays;

public class NextLargestNumber {

    public static void main(String[] args) {
        int no = 534976;

        char[] a = String.valueOf(no).toCharArray();

        findNextLargestNo(a);
    }

    private static void findNextLargestNo(char[] a) {

        if (a == null || a.length == 0) {
            return;
        }

        int i = a.length - 1;
        for (; i >= 0; i--) {
            if (a[i - 1] > a[i]) {
                continue;
            } else {
                break;
            }
        }

        int x = i - 1;

        int min = findMinNo(a, i);

        swap(a, x, min);

        Arrays.sort(a, i, a.length);

        System.out.println(Arrays.toString(a));
    }

    private static int findMinNo(char[] a, int i) {
        int min = i;

        for (int k = i+1; k < a.length; k++) {
            if (a[k] < a[min]) {
                min = k;
            }
        }
        return min;
    }

    private static void swap(char[] a, int x, int k) {
        char temp = a[x];
        a[x] = a[k];
        a[k] = temp;
    }
}
