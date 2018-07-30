package com.sudhar.examples;

public class GCD {

    public static void main(final String[] args) {
        System.out.println(gcd(98, 56));
    }

    private static int gcd(int a, int b) {

        if (a == 0|| b==0) {
            return 0;
        }

        if (a == b) {
            return a;
        }

        if (a > b) {
            return gcd(a-b, b);
        }
        return gcd(a, b-a);
    }
}
