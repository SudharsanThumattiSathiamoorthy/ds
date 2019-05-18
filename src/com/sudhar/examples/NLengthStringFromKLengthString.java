package com.sudhar.examples;

import java.util.Arrays;

public class NLengthStringFromKLengthString {

    public static void main(final String[] args) {
        final String ip = "ALGO";
        int n = 2;
        final char[] permutation = new char[n];


        permutation(ip, permutation, n, 0);
    }


    private static void permutation(String ip, char[] permutation, int n, int ci) {
        if (n <= 0) {
            System.out.println(String.valueOf(permutation));
        } else {

            for (int i = ci; i < ip.length(); i++) {
                permutation[n - 1] = ip.charAt(i);
                permutation(ip, permutation, n - 1, i);
            }
        }
    }


}
