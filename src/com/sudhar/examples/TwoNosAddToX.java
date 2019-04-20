package com.sudhar.examples;

import java.util.HashSet;
import java.util.Set;

public class TwoNosAddToX {

    public static void main(final String[] args) {
        int a[] = {1, 4, 45, 6, 10, 8, 9, 7};

        findPair(a, 16);
    }

    private static void findPair(int[] a, int key) {
        if (a == null || a.length == 0) {
            return;
        }

        final Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            int temp = key - a[i];

            if (temp >= 0 && set.contains(temp)) {
                System.out.println("found pair : " + temp + " " + a[i]);
            }

            set.add(a[i]);
        }
    }
}
