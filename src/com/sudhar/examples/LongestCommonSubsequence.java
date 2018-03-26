package com.sudhar.examples;

public class LongestCommonSubsequence {

    public static void main(final String[] args) {
        int lcs = lcs("saturday", "sunday", "saturday".length(), "sunday".length());
        System.out.println(lcs);
    }

    private static int lcs(String s1, String s2, int m, int n) {
        if (m==0 || n==0) {
            return 0;
        }

        else if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + lcs(s1, s2, m-1, n-1);
        }

        return Math.max(lcs(s1,s2, m-1, n), lcs(s1, s2, m, n-1));
    }
}
