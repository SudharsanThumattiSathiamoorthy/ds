package com.sudhar.examples;

import java.util.Arrays;

public class KthNonRepeatingString {

    public static void main(String[] args) {

        System.out.println(findKthNonRepeatingString("geeksforgeeks", 3));
    }

    private static char findKthNonRepeatingString(String str, int k) {
        int n = str.length();

        int count[] = new int[256];
        int index[] = new int[256];

        Arrays.fill(index, n);

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            count[c]++;

            if (count[c] == 1) {
                index[c] = i;
            } else {
                index[c] = n;
            }
        }

        Arrays.sort(index);

        return index[k-1] != n ? str.charAt(index[k-1]) : null;
    }
}
