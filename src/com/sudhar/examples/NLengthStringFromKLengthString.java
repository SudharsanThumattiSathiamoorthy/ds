package com.sudhar.examples;

public class NLengthStringFromKLengthString {

    public static void main(final String[] args) {
        final String ip = "ALGO";
        int n =2;
        final char[] permutation = new char[n];

        permutation(ip.toCharArray(), permutation, n, 0);

    }

    private static void permutation(char[] ip, char[] permutation, int n, int currentIndex) {
        if (n <= 0) {
            System.out.println(String.valueOf(permutation));
        } else {

            for (int i = currentIndex; i< ip.length; i++) {
                permutation[n-1] = ip[i];
                permutation(ip, permutation, n-1, i);
            }
        }
    }

}
