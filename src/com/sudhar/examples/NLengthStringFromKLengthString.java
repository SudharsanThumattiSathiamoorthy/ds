package com.sudhar.examples;

import java.util.Arrays;

public class NLengthStringFromKLengthString {

    public static void main(final String[] args) {

        String s= "abc";

        int  n =2;

        char[] permute = new char[n];

        permute(s, permute, n, 0);
    }

    private static void permute(String s, char[] permute, int n, int ci) {

        if (n == 0) {
            System.out.println(Arrays.toString(permute));
        } else {

            for (int i = ci; i < s.length(); i++) {
                permute[n - 1] = s.charAt(i);

                permute(s, permute, n - 1, i);
            }
        }
    }


}
