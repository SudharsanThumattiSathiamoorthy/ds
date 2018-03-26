package com.sudhar.examples;

public class EditDistance {

    public static void main(final String[] args) {
        int distance = editDistance("saturday", "sunday", "saturday".length(), "sunday".length());
        System.out.println(distance);
    }

    private static int editDistance(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return editDistance(s1, s2, m-1, n-1);
        }
        return 1 + min(editDistance(s1, s2, m-1, n),
                editDistance(s1, s2, m, n-1),
                editDistance(s1, s2, m-1, n-1));
     }

    private static int min(int x, int y, int z) {
        if (x < y && x < z) {
            return x;
        } else if (y < z) {
            return y;
        }
        return z;
    }
}
