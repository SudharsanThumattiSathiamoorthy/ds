package com.sudhar.examples;

public class LongestCommonSubsequence {

    public static void main(final String[] args) {
        final String s1 = "saturday";
        final String s2 = "sunday";

        int lcs = lcs(s1, s2, s1.length(), s2.length());
        System.out.println(lcs);
    }

    private static int lcs(final String s1, final String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m-1) == s2.charAt(n -1 )) {
            return 1 + lcs(s1, s2, m-1, n-1);
        }


        return Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
    }
}
