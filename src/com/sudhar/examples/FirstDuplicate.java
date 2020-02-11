package com.sudhar.examples;

public class FirstDuplicate {

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 5, 3, 2};

        System.out.println(findFirstDuplicate(a));
    }

    private static int findFirstDuplicate(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        for (int i = 0; i < a.length; i++) {
            int pos = Math.abs(a[i]) - 1;

            if (a[pos] < 0) {
                return Math.abs(a[pos]);
            }

            a[pos] = ~a[pos] + 1;
        }

        return -1;
    }
}
